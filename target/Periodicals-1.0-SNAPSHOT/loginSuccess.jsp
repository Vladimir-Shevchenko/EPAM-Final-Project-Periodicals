<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05.09.2021
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <%@ page isELIgnored="false" %>

  <fmt:setLocale value="${lang}"/>

  <fmt:setBundle basename="messages"/>

  <title>Title</title>
  <style>
    body {
      background-image: url('images/fon.jpeg');
    }
  </style>
</head>
<body>
<%@ page import=" RegisterLoginServlets.LoginServlet"%>
<%@ page import="java.util.List" %>
<%@ page import="Bean.Periodical" %>



<div align="right">
  <form  action="Logout"><input type="submit" value="<fmt:message key="periodicalsLogout.logout" />"></form>
</div>
<div align="right"><a href="ProfilServlet"><fmt:message key="periodicals.toMyProfil" /></a></div>

<form action = "I18Servlet" method="get">
  <select name="lan">
    <option>en</option>
    <option>ru</option>
  </select>
  <input type="submit" name="goUserLoginSuccess" value="<fmt:message key="periodicalsApply.apply" />" />


</form>



<div align="center">
  <h1><fmt:message key="loginSuccess.hi" /></h1>

  <hr>

  <%--
    String name = (String) session.getAttribute("username");
 --%>

  <p><h1><fmt:message key="loginSuccess.welcome" /> <c:out value="${username}" />!</h1></p>

  <c:set var = "str" value="n"/>
  <c:set var ="x" value="777"></c:set>



  <c:out value="${un}" />

  <br>
  <p><img src="images/cat-tuxedo.gif" alt="this slowpoke moves"  width="250" /></p>
</div>

<div align="left">
  <h1><a href="/Periodicals/PeriodicalServlet" ><fmt:message key="profil.ToCatalog" /></a></h1>
  <a href="/Periodicals/PeriodicalServlet"><img src="images/Magazines.jpg" width="300" height="200"></a>
</div>

<br>
<h1><a href="PeriodicalServlet"><fmt:message key="profil.ToCatalog" /></a></h1>
мяу
  <c:out value="${sss}" />
</body>
</html>
