<%--
  Created by IntelliJ IDEA.
  User: magol
  Date: 2023/08/19
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Showcase</title>
</head>
<body>
<div>
    <div>
        <h1>查询结果</h1>
        用户名：${uname}<br>
        <a href="/LearnJSP/remove"> 注销 </a><br>
        <a href="jstl-add.jsp"> 新增 </a><br>
        <a href="jstl-search.jsp"> 查找 </a><br>
    </div>
    <table border="1" cellspacing="0" width="800">
        <tr>
            <th>序号</th>
            <th>品牌名称</th>
            <th>企业名称</th>
            <th>排序</th>
            <th>品牌介绍</th>
            <th>状态</th>
            <th>操作</th>

        </tr>

        <%--    用JSTL Java 标准标签库 来去循环 从servlet 传递过来的变量 jstl-foreach.jsp
        items: 要对谁进行循环
        var： 从集合中取出的当前元素
        id=${brand.id}&brandName=${brand.brandName}&companyName=${brand.companyName}
                             &ordered=${brand.ordered}&description=${brand.description}&status=${brand.status}
        <%--    items：指定 要循环的变量   var ：从集合中拿到每个变量名字--%>
        <c:forEach items="${brandList}" var="brand" varStatus="status">
            <tr align="center">
                    <%--            <td>${brand.id}</td>--%>
                <td>${status.count}</td>
                <td>${brand.brandName}</td>
                <td>${brand.companyName}</td>
                <td>${brand.ordered}</td>
                <td>${brand.description}</td>
                <c:if test="${brand.status == 1}">
                    <td>启用</td>
                </c:if>
                <c:if test="${brand.status != 1}">
                    <td>禁用</td>
                </c:if>

                <td><a href="${pageContext.request.contextPath}/updateBrand?id=${brand.id}">修改</a>
                    <a href="${pageContext.request.contextPath}/deleteBrand?id=${brand.id}">删除</a>
                </td>
            </tr>

        </c:forEach>

    </table>
    <hr>
    <div>
        <c:forEach begin="1" end="5" step="1" var="i">
            <a href="#">${i}</a>
        </c:forEach>
    </div>

</div>
</body>
</html>
