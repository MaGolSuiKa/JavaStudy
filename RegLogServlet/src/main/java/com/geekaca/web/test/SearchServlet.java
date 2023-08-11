package com.geekaca.web.test;

import com.geekaca.web.mapper.UserMapper;
import com.geekaca.web.pojo.User;
import com.geekaca.web.util.SqlUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type"," text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String userName = req.getParameter("username");

        if (userName == null || "".equals(userName.trim())){
            writer.write("alert('输入不能为空')");
            resp.sendRedirect(req.getContextPath()+"/search.html");
            return;
        }

        SqlSession sqlSession = SqlUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectUserByName(userName);

        if(userList.size() == 0){
            writer.write("没有找到含有: " + userName + " 的用户");
            return;
        }
        writer.write("<table border=1>");
        writer.write("<tr>\n" +
                "        <td>id</td>\n" +
                "        <td>用户名</td>\n" +
                "        <td>性别</td>\n" +
                "        <td>城市</td>\n" +
                "    </tr>");
        for(User user : userList){
            writer.write("<tr>");
            writer.write("<td>" + user.getId()+"</td>");
            writer.write("<td>" + user.getUsername()+"</td>");
            if (user.getGender() != null) {
                writer.write("<td>" + (user.getGender().intValue() == 1 ? "男" : "女")+"</td>");
            }
            if (user.getCity()!= null) {
                writer.write("<td>");
                switch (user.getCity()){
                    case 1:writer.write("北京");break;
                    case 2:writer.write("上海");break;
                    case 3:writer.write("广州");break;
                }
                writer.write("</td>");
            }
            writer.write("</tr>");
        }
        writer.write("</table>");
        writer.write("<a href=\"login.html\">登录</a>!");
        writer.write("<br/>");
        writer.write("<a href=\"search.html\">查询</a>!");
    }
}
