<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14.09.2021
  Time: 1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="m" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>

<html>
<head>
    <style>
        body {
            background-image: url("images/fon.jpeg");
        }
    </style>
    <title>Title</title>
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
        <input type="submit" name="goProf" value="<fmt:message key="periodicalsApply.apply" />" />
    </form>
</div>

<div align="right"><fmt:message key="profil.myBill" /> ${money}$</div>
<div align="right"><a href="ReplenishServlet"><fmt:message key="profil.replenishMyBill" /></a></div>
<div align="left">
    <fmt:message key="profil.DataTime" /> <m:today/>
</div>

<h1 align="center"><fmt:message key="profil.MyProfil" /></h1>

<h1><a href="PeriodicalServlet"><fmt:message key="profil.ToCatalog" /></a></h1>
<br>
<h1><fmt:message key="profil.MyPeriodicals" /> </h1>


<table border="10px">
    <th></th>
    <th><fmt:message key="profil.thName" /></th>
    <th><fmt:message key="profil.thType" /></th>
    <th><fmt:message key="profil.thDescription" /></th>
    <th></th>
    <c:forEach items="${myOrderslist}" var="magazine" >
    <tr>
        <td><img src="images/magaz.png" height="54" width="58"/></td>
        <td>${magazine.name}</td>
        <td>${magazine.type}</td>
        <td>${magazine.description}</td>



    </tr>
    </c:forEach>
</table>
мяу
</body>
</html>
