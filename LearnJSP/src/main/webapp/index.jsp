<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Hello!</h2>
<font color="red">${error}</font>
<form action="${pageContext.request.contextPath}/login" method="post">
    <p>Username:<input id="username" name="username" type="text" value="${cookie.uname.value}"></p>
    <p>Password:<input id="password" name="password" type="password" value="${cookie.pass.value}"></p>
    <p>记住我：<input type="checkbox" name="rememberMe"/></p>
    <div id="subDiv">
        <input type="submit" class="button" value="登陆">
        <input type="reset" class="button" value="重置"><br>
        未持有账户的请<a href="${pageContext.request.contextPath}/jstl-register.jsp"> 注册 </a>
    </div>
</form>
</body>
</html>
