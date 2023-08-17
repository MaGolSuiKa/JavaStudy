<%--
  Created by IntelliJ IDEA.
  User: magol
  Date: 2023/08/17
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search</title>
</head>
<body>
用户名：${uname}<br>
<a href="/LearnJSP/remove"> 注销 </a><br>

<form action="${pageContext.request.contextPath}/find" method="post">
    输入查找内容：<input name="userInput"><br>
    <input type="submit" value="查询">
</form>
</body>
</html>
