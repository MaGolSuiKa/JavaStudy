package com.geekaca.filter;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.interfaces.Claim;
import com.geekaca.util.JwtUtil;
import com.geekaca.util.Result;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
//{"/add","/update","/delete","/search"}
@WebFilter("/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("token filter start");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String requestURI = req.getRequestURI();
        Result result = new Result();

        if (requestURI.contains("search") || requestURI.contains("delete")
                || requestURI.contains("update")|| requestURI.contains("add")
                || requestURI.contains("batchDelete")){
            //修改类的操作，需要登陆校验 ，需要是已经登陆的用户
            //要求 针对这些接口的请求，要携带token  header中
            String token = req.getHeader("token");
            if (token == null || "".equals(token.trim())){
                //非法访问 ,拒绝访问
                result.setCode(403);
                result.setMsg("未登录");
                System.out.println("未登录");
                String s = JSON.toJSONString(result);
                resp.setHeader("Content-Type", "text/json;charset=utf-8");
                // 直接返回给前端  ,返回给前端的统一的都是JSON
                PrintWriter writer = resp.getWriter();
                writer.write(s);
                return;
            }else{
                try {
                    Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);

                    if (stringClaimMap == null){
                        result.setCode(403);
                        result.setMsg("非法访问");
                        System.out.println("非法访问");
                        String s = JSON.toJSONString(result);
                        resp.setHeader("Content-Type", "text/json;charset=utf-8");
                        // 直接返回给前端  ,返回给前端的统一的都是JSON
                        PrintWriter writer = resp.getWriter();
                        writer.write(s);
                        return;
                    }
                    Claim userType = stringClaimMap.get("userType");
                    Integer uType = userType.asInt();
                    //非管理员 禁止
                    if (uType != BrandConstant.USER_TYPE_ADMIN){
                        result.setCode(403);
                        result.setMsg("权限不足");
                        System.out.println("权限不足");
                        String s = JSON.toJSONString(result);
                        resp.setHeader("Content-Type", "text/json;charset=utf-8");
                        // 直接返回给前端  ,返回给前端的统一的都是JSON
                        PrintWriter writer = resp.getWriter();
                        writer.write(s);
                        return;
                    }
                } catch (Exception e) {
                    //token 解析报错  比如，过期 ，或者密文错误
                    e.printStackTrace();
                    result.setCode(403);
                    result.setMsg("token 报错");
                    System.out.println("token 报错");
                    String s = JSON.toJSONString(result);
                    resp.setHeader("Content-Type", "text/json;charset=utf-8");
                    // 直接返回给前端  ,返回给前端的统一的都是JSON
                    PrintWriter writer = resp.getWriter();
                    writer.write(s);
                    return;
                }

            }
        }
        System.out.println("token filter end");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
