package com.geekaca.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.geekaca.pojo.Brand;
import com.geekaca.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JSTL find");

        String pageNo = req.getParameter("pageNo");
        String cntPerPage = req.getParameter("cntPerPage");
        if (pageNo == null) {
            pageNo = "1";
        }
        if (cntPerPage == null) {
            cntPerPage = "10";
        }
        int pNo = Integer.parseInt(pageNo);
        int pageSize = Integer.parseInt(cntPerPage);

        ServletInputStream ips = req.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(ips, "UTF-8"));
        String line = br.readLine();
        System.out.println("line: " + line);
        Brand brand = JSON.parseObject(line, Brand.class);
        brand.setPageNo(pNo);
        brand.setPageSize(pageSize);

        List<Brand> brandList = brandService.searchWithPage(brand);
        int BrandCount = brandService.getBrandCount(brand);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cnt", BrandCount);
        jsonObject.put("brands", brandList);
        resp.setHeader("Content-Type", "text/json;charset=utf-8");
        // 直接返回给前端
        PrintWriter writer = resp.getWriter();
        writer.write(jsonObject.toJSONString());
        writer.flush();
    }
}
