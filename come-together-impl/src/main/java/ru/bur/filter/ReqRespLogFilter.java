package ru.bur.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Этот фильтр используется для логирования запросов и ответов сервера.
 */
//@Component  // Если этот фильтр включен, то появляются ошибки SQL и еще какие-то.
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
/*
        log.trace("===========================request begin================================================");

        log.trace("URI         : {}", request.getRequestURI());
        log.trace("Method      : {}", request.getMethod());
      //  log.trace("Headers     : {}", request.getHeaders());
       // log.trace("Request body: {}", new String(body, "UTF-8"));
        log.trace("==========================request end================================================");
*/
        System.out.println("#INFO request:" + new Date() + " - HttpServletRequest :" + request);
        System.out.println("#INFO response:" + new Date() + " - HttpServletResponse :" + response);

      //  filterChain.doFilter(request, response);
    }
}
