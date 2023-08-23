package com.geekaca.servlet;

import com.alibaba.fastjson.JSON;
import com.geekaca.pojo.Brand;
import com.geekaca.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns ="/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用service查询
        List<Brand> brands = brandService.getAllBrands();
        /**
         * 以往   放入request区间（Vue是无法识别的），利用JSP展示  ，java的范畴，运行于服务端
         *
         * 现在  前后端分离， Vue运行 是要脱离Java环境，无需java解析的
         */
        //2. 转为JSON
        String jsonString = JSON.toJSONString(brands);

        //3. 写数据
        //之前   text/html 告诉浏览器，给你返回的是html页面，可以直接展示
        //现在  text/json   告诉浏览器，给你返回的是JSON结构的数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}