<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14.09.2021
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>

<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-image: url('images/fon.jpeg');
        }
    </style>
</head>
<body>
<div align="right">
    <form  action="Logout"><input type="submit" value="<fmt:message key="periodicalsLogout.logout" />"></form>
</div>

<div align="left">
    <form action = "I18Servlet" method="get">
        <select name="lan">
            <option>en</option>
            <option>ru</option>
        </select>
        <input type="submit" name="AdminUsers" value="<fmt:message key="periodicalsApply.apply" />" />
    </form>
</div>

<h1 align="right"><a href="AdminPeriodicalsServlet"> <fmt:message key="helloAdmin.PerMeneg" /></a></h1>

<h1><fmt:message key="adminUsers.AllUsers" /></h1>
<table border="5px">
    <th><fmt:message key="adminUsers.Name" /></th>
    <th><fmt:message key="adminUsers.Email" /></th>
    <th><fmt:message key="adminUsers.Phone" /></th>
    <th><fmt:message key="adminUsers.Money" /></th>
    <th><fmt:message key="adminUsers.NumOfSubs" /></th>
    <th><fmt:message key="adminUsers.Flag" /></th>

     <c:forEach items="${mList}" var="u" >
        <tr>
            <td>${u.uname}</td>
            <td>${u.email}</td>
            <td>${u.phone}</td>
            <td>${u.money}</td>
            <td>${u.numberOrders}</td>
            <td>${u.isBlocked}</td>
            <td><a href="AdminUsersServlet?blockUser=${u.uname}"><img src="images/block.PNG" width="50" height="25"></a><a href="AdminUsersServlet?unblockUser=${u.uname}"><img src="images/unblock.PNG" width="50" height="25"></a></td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
