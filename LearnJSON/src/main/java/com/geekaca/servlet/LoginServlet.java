package com.geekaca.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //现阶段 servlet方式这样接收，稍稍麻烦一点
        ServletInputStream inputStream = req.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);
        //{"uname":"test","pwd":"123"}
        //把一个JSON 的字符串 解析，提取其中各个属性的值   非常像 Hash Map
        JSONObject jsonObject = JSON.parseObject(s, JSONObject.class);
        Object uname = jsonObject.get("uname");
        System.out.println(uname + " pass:" + jsonObject.get("pwd"));
        /**
         * todo: 拿着用户名和密码
         * 到数据库查询，判断登陆是否成功
         * 调用Mybatis
         *
         * 返回给前端的仍然需要是一个JSON结构的字符串
         *
         * 比如： 登陆成功，返回  {"code": 200, "msg": "登陆成功"}
         * 登陆失败  返回  {"code": 400, "msg": "登陆失败"}
         */
        boolean isLoginOk = "test".equals(uname);
        Result result = new Result();
        if (isLoginOk){

            result.setCode(200);
            result.setMsg("登陆成功");
        }else{
            result.setCode(400);
            result.setMsg("登陆失败");
        }
        String jsonString = JSON.toJSONString(result);
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write(jsonString);
    }
}
