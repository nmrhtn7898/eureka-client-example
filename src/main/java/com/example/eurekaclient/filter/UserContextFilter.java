package com.example.eurekaclient.filter;

import com.example.eurekaclient.util.UserContext;
import com.example.eurekaclient.util.UserContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * HTTP 요청으로 전달된 헤더 정보들을 UserContext 인스턴스에 셋팅
 */
@Slf4j
@Component
public class UserContextFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        UserContext context = UserContextHolder.getContext();
        String correlationId = httpServletRequest.getHeader(UserContext.CORRELATION_ID);
        String token = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        context.setCorrelationId(correlationId);
        context.setAuthToken(token);
        context.setOrgId(httpServletRequest.getHeader(UserContext.ORG_ID));
        context.setUserId(httpServletRequest.getHeader(UserContext.USER_ID));
        log.debug("route service incoming auth token : {}", token);
        log.debug("route service incoming correlation id : {}", correlationId);
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
