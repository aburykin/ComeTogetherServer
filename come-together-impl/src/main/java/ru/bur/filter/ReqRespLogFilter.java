package ru.bur.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Этот фильтр используется для логирования запросов и ответов сервера.
 */
@Component  // Если этот фильтр включен, то появляются ошибки SQL и еще какие-то.
public class ReqRespLogFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        log.info("===========================request begin==========================================");
        log.info("URL         : {}", request.getRequestURL());
        log.info("Method      : {}", request.getMethod());
        log.info("Cookies     : {}", getCookies(request.getCookies()));
        //log.info("Request body: {}", getRequestBody(request));
        log.info("==========================request end============================================");


        log.info("============================response begin=======================================");
        log.info("Status code   : {}", response.getStatus());
        log.info("ContentType   : {}", servletResponse.getContentType());
        log.info("Header-Cookie : {}", response.getHeaders("Cookie"));
        //    log.info("Response body : {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
        log.info("=======================response end==============================================");

        filterChain.doFilter(request, response);

    }

    private String getCookies(Cookie[] cookies) {
        List<Cookie> list = new ArrayList<>(Arrays.asList(cookies));
        Map<String, String> result = new HashMap<>();
        list.forEach(cookie->{
            result.put(cookie.getName(), cookie.getValue());
        });
        return result.toString();
    }

    private String getRequestBody(HttpServletRequest request) throws IOException {
        String result = "";
        try(BufferedReader bufferedReader =request.getReader()){ // TODO чтобы не падало, нужно делать через ServletRequestWrapper
            result = bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e){
            log.error(e.getLocalizedMessage());
        }finally {
            request.getReader().close();
        }

        return result;
    }
}


