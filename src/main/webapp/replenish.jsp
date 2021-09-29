<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14.09.2021
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>

<div align="right">
    <form  action="Logout"><input type="submit" value="<fmt:message key="periodicalsLogout.logout" />"></form>
</div>
<div align="right"><a href="ProfilServlet"><fmt:message key="replenish.ToMyProfil" /></a></div>

<div align="left">
    <form action = "I18Servlet" method="get">
        <select name="lan">
            <option>en</option>
            <option>ru</option>
        </select>
        <input type="submit" name="goReplenish" value="<fmt:message key="periodicalsApply.apply" />" />
    </form>
</div>


<div class="row">
    <div class="col-75">
        <div class="container">
            <form action="ReplenishServlet" method="post">

                <div class="row">
                    <div class="col-50">
                        <h3><fmt:message key="replenish.BillAdress" /></h3>
                        <label for="fname"><i class="fa fa-user"></i> <fmt:message key="replenish.FullName" /></label>
                        <input type="text" id="fname" name="firstname" placeholder="<fmt:message key="replenish.PlaceName" />">
                        <label for="email"><i class="fa fa-envelope"></i> </label>
                        <input type="text" id="email" name="email" placeholder="john@example.com">



                    </div>

                    <div class="col-50">
                        <h3><fmt:message key="replenish.Payment" /></h3>
                        <label for="fname"><fmt:message key="replenish.AcceptedCards" /></label>
                        <div class="icon-container">
                            <i class="fa fa-cc-visa" style="color:navy;"></i>
                            <i class="fa fa-cc-amex" style="color:blue;"></i>
                            <i class="fa fa-cc-mastercard" style="color:red;"></i>
                            <i class="fa fa-cc-discover" style="color:orange;"></i>
                        </div>
                        <label for="cname"><fmt:message key="replenish.NameOnCard" /></label>
                        <input type="text" id="cname" name="cardname" placeholder="<fmt:message key="replenish.placeName" />">
                        <label for="ccnum"><fmt:message key="replenish.CreditCardNumber" /></label>
                        <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
                        <label for="expmonth"><fmt:message key="replenish.ExpMonth" /></label>
                        <input type="text" id="expmonth" name="expmonth" placeholder="<fmt:message key="replenish.September" />">

                        <div class="row">
                            <div class="col-50">
                                <label for="expyear"><fmt:message key="replenish.ExpYear" /></label>
                                <input type="text" id="expyear" name="expyear" placeholder="2021">
                            </div>
                            <div class="col-50">
                                <label for="cvv">CVV</label>
                                <input type="text" id="cvv" name="cvv" placeholder="352">
                            </div>
                            <div class="col-50">
                                <label for="cvv"><fmt:message key="replenish.Amount" /></label>
                                <input type="text" id="am" name="amount" placeholder="100$">
                            </div>
                        </div>
                    </div>

                </div>

                <input type="submit" value="<fmt:message key="replenish.button" />" class="btn">
            </form>
        </div>
    </div>

    <div class="col-25">
    </div>
</div>
мяу
</body>
</html>
