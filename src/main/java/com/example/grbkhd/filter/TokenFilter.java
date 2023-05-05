package com.example.grbkhd.filter;

import com.example.grbkhd.pojo.Token;
import com.example.grbkhd.util.TokenCreate;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@WebFilter(urlPatterns = "/login",filterName = "tokenfilter")
public class TokenFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("token过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getMethod()!="OPTIONS"){
            String token = request.getHeader("token");
            System.out.println("过滤器里的token:"+token);
            if (token!=null){
                Token token1 = TokenCreate.tokenToOut(token);
                if ("admin".equals(token1.getUsername())){
                    request.setAttribute("state",true);
                }else{
                    request.setAttribute("state",false);
                }
            }else{
                request.setAttribute("state",false);
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("token过滤器销毁");
    }
}
