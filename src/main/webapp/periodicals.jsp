<%@ page import="Bean.Periodical" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Array" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11.09.2021
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<div align="right"><a href="ProfilServlet"><fmt:message key="periodicals.toMyProfil" /></a></div>
<form action = "I18Servlet" method="get">
    <select name="lan">
        <option>en</option>
        <option>ru</option>
    </select>
    <input type="submit" name="goPer" value="<fmt:message key="periodicalsApply.apply" />" />
</form>
<h1></h1>
<h1> <fmt:message key="periodicals.catalog" /></h1>


<div class="header">

    <form class="search_form" name="search_form" method="post">
        <img src="images/search.jpg" height="24" width="25"/>
        <input type="text" name="search_String" value="" size="100" placeholder="<fmt:message key="periodicals.Placeholder" />"/>
        <input type="submit" name="search_button" value="<fmt:message key="periodicals.Search" />" />
        <select name="search_option">
            <option><fmt:message key="periodicals.SortBy" />...</option>
            <option><fmt:message key="periodicals.Theme" /></option>
            <option><fmt:message key="periodicals.Title" /></option>
            <option><fmt:message key="periodicals.Price" /></option>
        </select>

    </form>

</div>
<a  href="PeriodicalServlet?letter=A"><img height="25" width="24" src="images/ABC/3dAletter.png"></a>
<a  href="PeriodicalServlet?letter=B"><img height="25" width="24" src="images/ABC/3dBletter.png"></a>
<a onclick="alert('Пример 1 сработал'); return false;"><img height="25" width="24" src="images/ABC/3dCletter.png" onclick=""></a>
<a  href="PeriodicalServlet?letter=D"><img height="25" width="24" src="images/ABC/3dDletter.png"></a>
<a  href="PeriodicalServlet?letter=E"><img height="25" width="24" src="images/ABC/3dEletter.png"></a>
<a  href="PeriodicalServlet?letter=F"><img height="25" width="24" src="images/ABC/3dFletter.png"></a>
<a  href="PeriodicalServlet?letter=G"><img height="25" width="24" src="images/ABC/3dGletter.png"></a>
<a  href="PeriodicalServlet?letter=H"><img height="25" width="24" src="images/ABC/3dHletter.png"></a>
<a  href="PeriodicalServlet?letter=I"><img height="25" width="24" src="images/ABC/3dIletter.png"></a>
<a  href="PeriodicalServlet?letter=J"><img height="25" width="24" src="images/ABC/3dJletter.png"></a>
<a  href="PeriodicalServlet?letter=K"><img height="25" width="24" src="images/ABC/3dKletter.png"></a>
<a  href="PeriodicalServlet?letter=L"><img height="25" width="24" src="images/ABC/3dLletter.png"></a>
<a  href="PeriodicalServlet?letter=M"><img height="25" width="24" src="images/ABC/3dMletter.png"></a>
<a  href="PeriodicalServlet?letter=N"><img height="25" width="24" src="images/ABC/3dNletter.png"></a>
<a  href="PeriodicalServlet?letter=O"><img height="25" width="24" src="images/ABC/3dOletter.png"></a>
<a  href="PeriodicalServlet?letter=P"><img height="25" width="24" src="images/ABC/3dPletter.png"></a>
<a  href="PeriodicalServlet?letter=Q"><img height="25" width="24" src="images/ABC/3dQletter.png"></a>
<a  href="PeriodicalServlet?letter=R"><img height="25" width="24" src="images/ABC/3dRletter.png"></a>
<a  href="PeriodicalServlet?letter=S"><img height="25" width="24" src="images/ABC/3dSletter.png"></a>
<a  href="PeriodicalServlet?letter=T"><img height="25" width="24" src="images/ABC/3dTletter.png"></a>

<a  href="PeriodicalServlet?letter=U"><img height="25" width="24" src="images/ABC/3dUletter.png"></a>
<a  href="PeriodicalServlet?letter=V"><img height="25" width="24" src="images/ABC/3dVletter.png"></a>
<a  href="PeriodicalServlet?letter=W"><img height="25" width="24" src="images/ABC/3dWletter.png"></a>
<a  href="PeriodicalServlet?letter=X"><img height="25" width="24" src="images/ABC/3dXletter.png"></a>
<a  href="PeriodicalServlet?letter=Y"><img height="25" width="24" src="images/ABC/3dYletter.png"></a>
<a  href="PeriodicalServlet?letter=Z"><img height="25" width="24" src="images/ABC/3dZletter.png"></a>





<table border="10px">
    <th></th>
    <th><fmt:message key="periodicals.thName" /></th>
    <th><fmt:message key="periodicals.thPrice" /></th>
    <th><fmt:message key="periodicals.thType" /></th>
    <th><fmt:message key="periodicals.thDescription" /></th>
    <th></th>
<c:forEach items="${list}" var="magazine" >
    <tr>
        <td><img src="images/magaz.png" height="84" width="88"/></td>
        <td>${magazine.name}</td>
        <td>${magazine.price}$</td>
        <td>${magazine.type}</td>
        <td>${magazine.description}</td>
        <td><a  href="ConfirmServlet?id=${magazine.id}&name=${magazine.name}&price=${magazine.price}$&type=${magazine.type}&description=${magazine.description}"><img height="25" width="64" src="images/sub.PNG"></a></td>
 <%--       <td>${list.indexOf(magazine)}</td> --%>


    </tr>
</c:forEach>
</table>
мяу

</body>
</html>
