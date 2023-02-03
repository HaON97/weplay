package com.portfolio.weplay.comm.config;

import com.portfolio.weplay.comm.filter.myFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.annotation.WebFilter;
import java.util.Arrays;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    private static final String[] INCLUDE_PATHS = {
            "/test/*"
    };

    @Bean
    public FilterRegistrationBean filterBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new myFilter());
        registrationBean.setOrder(Integer.MIN_VALUE);
        registrationBean.setUrlPatterns(Arrays.asList(INCLUDE_PATHS));

        return registrationBean;
    }

}
