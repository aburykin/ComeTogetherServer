package ru.bur.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.bur.filter.InitThreadLocalFilter;

@Configuration
public class FilterConfig {

    @Autowired
    private InitThreadLocalFilter initThreadLocalFilter;

    @Bean
    public FilterRegistrationBean<InitThreadLocalFilter> setInitThreadLocalFilter() {
        FilterRegistrationBean<InitThreadLocalFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(initThreadLocalFilter);
        //registrationBean.addUrlPatterns("/rest/*"); //TODO в hateoas нужно поменять базовый урл, для того чтобы с фильтром работать.
        registrationBean.addUrlPatterns("/meetings");
        //registrationBean.addUrlPatterns("/auth"); // эту страницу не проверяем
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
