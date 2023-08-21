<%--
  Created by IntelliJ IDEA.
  User: magol
  Date: 2023/08/19
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>AddBrand</title>
</head>
<body>
<div>
    <div>
        <h3>添加品牌</h3>
        <font color="red">${error}</font>
        用户名：${uname}<br>
        <a href="${pageContext.request.contextPath}/remove"> 注销 </a><br>
    </div>
    <form action="${pageContext.request.contextPath}/add" method="post">
        品牌名称：<input name="brandName"><br>
        企业名称：<input name="companyName"><br>
        排序：<input name="ordered"><br>
        描述信息：<textarea rows="5" cols="20" name="description"></textarea><br>
        类型：<input name="type"><br>
        状态：
        <input type="radio" name="status" value="0">禁用
        <input type="radio" name="status" value="1">启用
        <br>
        <div>
            <input type="submit" value="提交">
        </div>
    </form>
</div>

</body>
</html>
