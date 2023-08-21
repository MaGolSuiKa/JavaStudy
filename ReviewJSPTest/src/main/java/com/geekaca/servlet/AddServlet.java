package com.geekaca.servlet;

import com.geekaca.pojo.Brand;
import com.geekaca.pojo.Type;
import com.geekaca.service.BrandService;
import com.geekaca.service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        /**
         * 检查用户是否登陆
         */
        HttpSession session = req.getSession();
        Object uname = session.getAttribute("uname");
        if (uname == null) {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        String ordered = req.getParameter("ordered");
        String description = req.getParameter("description");
        String status = req.getParameter("status");
        String typeId = req.getParameter("typeId");

        StringBuilder msg = new StringBuilder();

        if (status == null || "".equals(status.trim())) {
            msg.append("状态不能为空<br>");
        }
        if (brandName == null || "".equals(brandName.trim())) {
            msg.append("品牌名不能为空<br>");
        }

        if (!"".equals(msg.toString())) {
            req.setAttribute("error", msg.toString());
            req.getRequestDispatcher("/addbrand.jsp").forward(req, resp);
            return;
        }
        System.out.println("add brand");
        Brand brand = new Brand(null, brandName,
                companyName, Integer.parseInt(ordered), description,
                Integer.parseInt(status), Integer.parseInt(typeId));

        int add = brandService.addBrand(brand);

        if (add > 0) {
            resp.sendRedirect("/ReviewJSPTest/show");
        } else {
            req.setAttribute("error", "新增失败");
            req.getRequestDispatcher("/addbrand.jsp").forward(req, resp);
        }
    }
}
