<%--
  Created by IntelliJ IDEA.
  User: wenhe
  Date: 2019/11/19
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    td{
        border: 2px black solid
    }


</style>
<table  >
    <thead>List</thead>
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>生日</td>
        <td>性别</td>
        <td>地址</td>
    </tr>
    <c:forEach var="user"  items="${list}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.birthday}</td>
            <td>${user.sex}</td>
            <td>${user.address}</td>
        </tr>
    </c:forEach>


</table>




</body>
</html>
