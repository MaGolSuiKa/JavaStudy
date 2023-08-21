<%--
  Created by IntelliJ IDEA.
  User: magol
  Date: 2023/08/19
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<div>
    <div>
        <h3>修改品牌</h3>
        <font color="red">${error}</font>
        用户名：${uname}<br>
        <a href="${pageContext.request.contextPath}/remove"> 注销 </a><br>
    </div>
    <form action="${pageContext.request.contextPath}/update" method="post">
        <input type="hidden" name="id" value="${brand.id}"/>
        品牌名称：<input name="brandName" value="${brand.brandName}"><br>
        企业名称：<input name="companyName" value="${brand.companyName}"><br>
        排序：<input name="ordered" value="${brand.ordered}"><br>
        描述信息：<textarea rows="5" cols="20" name="description">${brand.description}</textarea><br>
        类型：
        <select name="typeId">
            <option value="${brand.typeId}">${typeNameById}</option>
            <c:forEach items="${allType}" var="tp">
                <option value="${tp.idt}">${tp.typeName}</option>
            </c:forEach>
        </select><br>
        状态：
        <input type="radio" name="status" value="0" ${brand.status == 0?"checked":" "}>禁用
        <input type="radio" name="status" value="1" ${brand.status == 1?"checked":" "}>启用
        <br>
        <div>
            <input type="submit" value="提交">
        </div>
    </form>
</div>

</body>
</html>
