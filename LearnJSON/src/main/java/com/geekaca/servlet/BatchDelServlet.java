package com.geekaca.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.geekaca.service.BrandService;
import com.geekaca.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

@WebServlet(urlPatterns = "/batchDelete")
public class BatchDelServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchDelServlet.class);
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletInputStream ips = req.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(ips));
        String line = br.readLine();
        System.out.println("line: " + line);

        JSONArray jArray = JSON.parseObject(line, JSONArray.class);
        // 从JSON 数组 还原出来 数据
        Integer[] ids = jArray.toArray(new Integer[jArray.size()]);
//        String ids = jArray.toString();
//        String barchId = ids.substring(1, ids.length() - 1);
        //System.out.println("ids:" + ids);
        for (int id:ids){
            System.out.println(id);
        }
        int i = brandService.deleteBrands(ids);
        resp.setHeader("Content-Type", "text/json;charset=utf-8");
        // 直接返回给前端  ,返回给前端的统一的都是JSON
        PrintWriter writer = resp.getWriter();
        Result result = new Result();
        result.setCode(200);
        result.setMsg("删除成功");
        String s = JSON.toJSONString(result);
        writer.write(s);
        writer.flush();


    }
}
