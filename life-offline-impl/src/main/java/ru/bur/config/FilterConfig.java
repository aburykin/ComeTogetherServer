package ru.bur.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.bur.filter.InitThreadLocalFilter;
import ru.bur.filter.ReqRespLogFilter;

@Configuration
public class FilterConfig {

    @Autowired
    private InitThreadLocalFilter initThreadLocalFilter;

    @Autowired
    private ReqRespLogFilter reqRespLogFilter;

    @Bean
    public FilterRegistrationBean<ReqRespLogFilter> setReqRespLogFilter() {
        FilterRegistrationBean<ReqRespLogFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(reqRespLogFilter);
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<InitThreadLocalFilter> setInitThreadLocalFilter() {
        FilterRegistrationBean<InitThreadLocalFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(initThreadLocalFilter);
        registrationBean.addUrlPatterns("/rest/*");
        registrationBean.addUrlPatterns("/hateoas/*");
        //registrationBean.addUrlPatterns("/auth"); // эту страницу не проверяем
        registrationBean.setOrder(2);
        return registrationBean;
    }
}
