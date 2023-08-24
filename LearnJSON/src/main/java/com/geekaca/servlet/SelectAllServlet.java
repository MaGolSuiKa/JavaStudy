package com.geekaca.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.geekaca.pojo.Brand;
import com.geekaca.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns ="/all")
public class SelectAllServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用mybatis
        String pageNo = req.getParameter("pageNo");
        String cntPerPage = req.getParameter("cntPerPage");
        if (pageNo == null){
            pageNo = "1";
        }
        if (cntPerPage == null){
            cntPerPage = "5";
        }
        int pNo = Integer.parseInt(pageNo);
        int pageSize = Integer.parseInt(cntPerPage);
        //1. 调用service查询
        List<Brand> brands = brandService.getAllBrands(pNo, pageSize);
        // 单独执行一个查询，查询符合条件的总记录条数
        int allBrandsCount = brandService.getAllBrandsCount();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cnt", allBrandsCount);
        jsonObject.put("brands", brands);

        resp.setHeader("Content-Type", "text/json;charset=utf-8");
        // 直接返回给前端
        PrintWriter writer = resp.getWriter();
        writer.write(jsonObject.toJSONString());
        writer.flush();
    }

}