package ru.bur.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bur.domain.db.tables.pojos.AppUser;
import ru.bur.service.AppUserService;
import ru.bur.session.ThreadLocalCurrentUser;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class InitThreadLocalFilter implements Filter {

    private final static Logger log = LoggerFactory.getLogger(InitThreadLocalFilter.class);

    private String USER_TOKEN_COOKIES = "user_token";

    @Autowired
    private AppUserService appUserService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse rs = (HttpServletResponse) response;

        AppUser appUser = ThreadLocalCurrentUser.getAppUser();
        if (appUser != null) {
            chain.doFilter(request, response);
            return;
        }

        HttpServletRequest rq = (HttpServletRequest) request;
        if (rq.getCookies() == null) {
            throw new RuntimeException("Не найдены cookies.");
        }

        Cookie[] cookies = rq.getCookies();
        if (isCookiesCorrect(cookies) == false) {
            rs.sendError(HttpStatus.BAD_REQUEST.value(), "Не найдена cookie с именем " + USER_TOKEN_COOKIES);
            return;
        }


        for (Cookie cookie : cookies) {
            if (USER_TOKEN_COOKIES.equals(cookie.getName())) {
                appUser = appUserService.getAppUserByToken(cookie.getValue());
                break;
            }
        }

        if (appUser == null) {
            rs.sendError(HttpStatus.UNAUTHORIZED.value(), "Пользователь не найден, необходимо пройти авторизацию");
            //chain.doFilter(request, response); без вызова этого метода, фильтр отправит сообщение назад, не пропуская дальше
            return;
        }

        ThreadLocalCurrentUser.setAppUser(appUser);
        chain.doFilter(request, response);
    }

    private boolean isCookiesCorrect(Cookie[] cookies) {
        boolean isCorrect = false;
        for (Cookie cookie : cookies) {
            if (USER_TOKEN_COOKIES.equals(cookie.getName())) {
                log.trace("Rq cookies: name {}, value {}, path {}, domain {}, max age {}, {}, {}", cookie.getName(), cookie.getValue(), cookie.getPath(), cookie.getDomain(), cookie.getMaxAge(), cookie.getVersion(), cookie.getSecure());
                isCorrect = true;
                break;
            }
        }
        return isCorrect;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {

    }
}