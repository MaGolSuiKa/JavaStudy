<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>修改</title>
</head>
<body>

<h3>修改品牌</h3>
<font color="red">${error}</font>
<%-- todo:
需要定义一个servlet ，访问路径是/updateBrand
和新增逻辑类似
但是发送的是更新语句
--%>
<form action="/update" method="post">
<%--    不显示在网页上的--%>
    <input type="hidden" name="id" value="${brand.id}"/>
    品牌名称：<input name="brandName" value="${brand.brandName}"><br>
    企业名称：<input name="companyName" value="${brand.companyName}"><br>
    排序：<input name="ordered"><br>
    描述信息：<textarea rows="5" cols="20" name="description"></textarea><br>
    状态：
    <input type="radio" name="status" value="0" ${brand.status == 0? 'checked':''}>禁用
    <input type="radio" name="status" value="1" ${brand.status == 1? 'checked':''}>启用
    <br>

    <input type="submit" value="提交">
</form>
</body>
</html>
