<%--
  Created by IntelliJ IDEA.
  User: magol
  Date: 2023/08/19
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.jsp">登录</a>
    </div>
    <font color="red">${error}</font>
    <form id="reg-form" action="${pageContext.request.contextPath}/register" method="post">

        <table>
            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg">${register_msg}</span>
                </td>
            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>
            <tr>
                <td>类型</td>
                <td class="inputs">
                    <input type="radio" name="userType" value="0">类型一
                    <input type="radio" name="userType" value="1">类型二
                </td>
            </tr>


            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img id="checkCodeImg" src="${pageContext.request.contextPath}/code">
                    <a href="#" id="changeImg">看不清？</a>
                </td>
            </tr>
        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>
<script>
    document.getElementById("changeImg").onclick = function () {
        // 后面的?日期，是为了避免浏览器缓存
        document.getElementById("checkCodeImg").src = "${pageContext.request.contextPath}/code?" + new Date().getMilliseconds();
    }

</script>
</body>
</html>
