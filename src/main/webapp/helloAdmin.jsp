<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09.09.2021
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tf" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>

<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-image: url("images/fon.jpeg");
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
        <input type="submit" name="HelloAdmin" value="<fmt:message key="periodicalsApply.apply" />" />
    </form>
</div>

<div align="left">
    <p><fmt:message key="helloAdmin.Todayis" /> <tf:tagfileone/></p>
</div>
<h1><fmt:message key="helloAdmin.HiAdmin" /></h1>

<div align="center"><h1><a href="AdminPeriodicalsServlet"><fmt:message key="helloAdmin.PerMeneg" /></a></h1></div>
<div align="center"><h1><a href="AdminUsersServlet"><fmt:message key="helloAdmin.Users" /></a></h1></div>

</body>
</html>
