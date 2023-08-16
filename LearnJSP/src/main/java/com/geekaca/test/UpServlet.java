package com.geekaca.test;

import com.geekaca.pojo.Brand;
import com.geekaca.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/update")
public class UpServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        String description = req.getParameter("description");
        String ordered = req.getParameter("ordered");
        String status = req.getParameter("status");
        Brand brand = new Brand(Integer.parseInt(id),
                brandName, companyName, Integer.parseInt(ordered),
                description, Integer.parseInt(status));

        StringBuilder msg = new StringBuilder();
        if (status == null || "".equals(status.trim())) {
            msg.append("状态不能为空<br>");
        }
        if (brandName == null || "".equals(brandName.trim())) {
            msg.append("品牌名不能为空<br>");
        }

        if (!"".equals(msg.toString())) {
            req.setAttribute("brand", brand);
            req.setAttribute("error", msg.toString());
            req.getRequestDispatcher("/jstl-update.jsp").forward(req, resp);
            return;
        }

        int ud = brandService.updateBrand(brand);
        if (ud > 0) {
            resp.sendRedirect("/LearnJSP/test");
        } else {
            req.setAttribute("error", "更改失败");
            req.getRequestDispatcher("/jstl-update.jsp").forward(req, resp);
        }
    }
}
