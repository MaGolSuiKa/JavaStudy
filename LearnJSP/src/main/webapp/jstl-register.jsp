<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link href="css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="index.jsp">登录</a>
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
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <%--                    img html 图片元素  src 设置图片的路径，来源
                                            由servlet来给出图片的字节数据，浏览器来组装，显示图片
                    --%>
                    <img id="checkCodeImg" src="${pageContext.request.contextPath}/code">
                    <%--                    超链接地址指向#   指向当前页面，点击后刷新当前页面
                                            结果是每次都会重新访问 img 的src， 相当于重新访问checkCodeServlet
                                            就会重新生成一个新的验证码图片
                    --%>
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