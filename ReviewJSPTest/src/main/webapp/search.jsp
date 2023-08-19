<%--
  Created by IntelliJ IDEA.
  User: magol
  Date: 2023/08/19
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<div>
    <div>
        <h1>查询</h1>
        用户名：${uname}<br>
        <a href="/LearnJSP/remove"> 注销 </a><br>
    </div>
    <form action="${pageContext.request.contextPath}/find" method="post">
        输入查找内容：<input name="userInput"><br>
        <div>
            <input type="submit" value="查询">
        </div>
    </form>
</div>
</body>
</html>
