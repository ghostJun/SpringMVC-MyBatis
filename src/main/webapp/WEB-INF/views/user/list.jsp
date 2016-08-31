<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GhostJun
  Date: 16/8/12
  Time: 下午1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>头像</th>
        <th>姓名</th>
        <th>电话</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.favicon}</td>
            <td>${item.name}</td>
            <td>${item.phone}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
