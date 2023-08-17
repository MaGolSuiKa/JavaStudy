<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Hello!</h2>
<font color="red">${error}</font>
<form action="/LearnJSP/login" method="post">
    <p>Username:<input id="username" name="username" type="text"></p>

    <p>Password:<input id="password" name="password" type="password"></p>

    <input type="submit" class="button" value="登陆">
    <input type="reset" class="button" value="重置">&nbsp;&nbsp;&nbsp;

</form>
</body>
</html>
