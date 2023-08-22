<%--
  Created by IntelliJ IDEA.
  User: magol
  Date: 2023/08/19
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <div>
        <h1>登录</h1>
        <font color="red">${error}</font>
    </div>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td class="inputs">
                    <input id="username" name="username" type="text" value="${cookie.uname.value}">
                </td>
            </tr>
            <tr>
                <td>密码:</td>
                <td class="inputs">
                    <input id="password" name="password" type="password" value="${cookie.pass.value}">
                </td>
            </tr>
        </table>
        <p>记住我：<input type="checkbox" name="rememberMe"/></p>
        <a href="${pageContext.request.contextPath}/clearCookie"> 清除cookie </a><br>
        <div id="subDiv">
            <input type="submit" class="button" value="登录">
            <input type="reset" class="button" value="重置"><br>
            未持有账户的请<a href="${pageContext.request.contextPath}/register.jsp"> 注册 </a>
        </div>
    </form>
</div>
</body>
</html>
