package com.portfolio.weplay.comm.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
;
@Slf4j
@WebFilter(urlPatterns = {"/test/*", "/test2/*"})
public class myFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        log.info("-- 필터 초기화 --");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException{

    }

    @Override
    public void destroy() {
        log.info("---필터 인스턴스 종료---");
    }
}
