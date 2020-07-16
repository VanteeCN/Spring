<%--
  Created by IntelliJ IDEA.
  User: GIAO
  Date: 2020/2/18
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的信息</title>
</head>
<body>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>出生日期</th>
        <th>性别</th>
        <th>月薪</th>
        <c:forEach var="item" items="${page.list}">
            <tr>
                <td>${item.pid}</td>
                <td>${item.pname}</td>
                <td>${item.age}</td>
                <td><fmt:formatDate value="${item.hiredate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                <td>${item.sex}</td>
                <td>${item.salary}</td>
            </tr>
        </c:forEach>
    </tr>
</table>
</body>
</html>
