package com.geekaca.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/add", "/delete", "/update", "/search","/show", "/update"})
public class UserLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /**
         * 检查用户是否登陆
         */
        System.out.println("filter start");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();
        Object uname = session.getAttribute("uname");
        if (uname == null) {
            System.out.println("filter end");
            req.setAttribute("error", "请登录后操作");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        //过滤器链 放行请求
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
