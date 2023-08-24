package com.geekaca.filter;

import com.auth0.jwt.interfaces.Claim;
import com.geekaca.util.JwtUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebFilter(urlPatterns = {"/add","/update","/delete","/search"})
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("token filter start");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //针对token的过滤，拦截，放在过滤器中，统一处理，用来保护你的那些 需要登陆过的用户
        //才能操作的接口
        String token = req.getHeader("token");
        //判断token的有效性，
        if (token == null){
            //说明 此人没有登陆，试图直接访问接口，不允许
            return;
        }
        try {
            Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
            Claim id = stringClaimMap.get("id");
            if (id == null){
                //说明token格式不对，非法的访问
            }
        }catch (Exception ex){
            ex.printStackTrace();;
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
