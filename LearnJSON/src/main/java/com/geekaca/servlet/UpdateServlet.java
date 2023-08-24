package com.geekaca.servlet;

import com.alibaba.fastjson.JSON;
import com.geekaca.pojo.Brand;
import com.geekaca.service.BrandService;
import com.geekaca.util.Result;

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

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletInputStream ips = req.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(ips));
        String line = br.readLine();
        System.out.println("line: " + line);
        //JSON String -> Brand
        Brand brand = JSON.parseObject(line, Brand.class);
        StringBuilder msg = new StringBuilder();

        if (brand.getStatus() == null || "".equals(brand.getStatus())){
            msg.append("状态不能为空<br>");
        }
        if (brand.getBrandName() == null || "".equals(brand.getBrandName().trim())){
            msg.append("品牌名不能为空<br>");
        }
        resp.setHeader("Content-Type", "text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        Result result = new Result();
        if (!"".equals(msg.toString())) {
            result.setCode(400);
            result.setMsg(msg.toString());
            String s = JSON.toJSONString(result);
            writer.write(s);
            writer.flush();
            return;
        }

        int ud = brandService.updateBrand(brand);
        if (ud > 0) {
            result.setCode(200);
            result.setMsg(msg.toString());
            String s = JSON.toJSONString(result);
            writer.write(s);
            writer.flush();
        } else {
            result.setCode(400);
            result.setMsg(msg.toString());
            String s = JSON.toJSONString(result);
            writer.write(s);
            writer.flush();
        }
    }
}
