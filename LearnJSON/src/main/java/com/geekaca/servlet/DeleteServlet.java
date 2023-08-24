package com.geekaca.servlet;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.interfaces.Claim;
import com.geekaca.service.BrandService;
import com.geekaca.util.JwtUtil;
import com.geekaca.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteServlet.class);
    private BrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        LOGGER.info("service : ", id);
        if (id == null || "".equals(id.trim())){
            return;
        }
        PrintWriter writer = resp.getWriter();
        Result result = new Result();

        int i = brandService.deleteBrand(Integer.parseInt(id));
        //req.getRequestDispatcher("/all").forward(req, resp);
        result.setCode(200);
        String s = JSON.toJSONString(result);
        writer.write(s);
        writer.flush();


    }
}
