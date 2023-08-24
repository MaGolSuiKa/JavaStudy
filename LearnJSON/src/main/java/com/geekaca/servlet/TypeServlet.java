package com.geekaca.servlet;

import com.alibaba.fastjson.JSON;
import com.geekaca.pojo.Type;
import com.geekaca.service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/allTypes")
public class TypeServlet extends HttpServlet {
    private TypeService typeService = new TypeService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Type> allTypes = typeService.searchType();
        String jsonString = JSON.toJSONString(allTypes);
        resp.setHeader("Content-Type", "text/json;charset=utf-8");
        // 直接返回给前端
        PrintWriter writer = resp.getWriter();
        writer.write(jsonString);
        writer.flush();
    }
}
