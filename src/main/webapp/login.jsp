<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${lang}"/>

<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
    body {
      background-image: url("images/fon.jpeg");
    }
  </style>

  <link rel="stylesheet" href="CSS/testlogin.css">

</head>
<body>

<form action = "I18Servlet" method="get">
  <select name="lan">
    <option>en</option>
    <option>ru</option>
  </select>
  <input type="submit" name="go" value="<fmt:message key="periodicalsApply.apply" />" />


</form>



<div align="left"><img  src="images/periodicals3.png" alt="this slowpoke moves"  width="650"  /></div>


<form action = "login" method="post">
  <div class="container" >
    <p class="heading"><fmt:message key="login.LogIn" /> </p>
    <div class="box">
      <p><fmt:message key="login.Login" /></p>
      <div> <input type="text" autocomplete="off" placeholder="<fmt:message key="login.LogHolder" />" name="username"> </div>
    </div>
    <div class="box" >
      <p>Email</p>
      <div> <input type="password" autocomplete="off" placeholder="<fmt:message key="login.PassHolder" />" name="password"> </div>
    </div> <button class="loginBtn"><fmt:message key="label.button" /> </button>
    <p class="text"><fmt:message key="label.haveAccount" /> <a href="registration.jsp"><fmt:message key="login.Signup" /></a></p>
  </div>
</form>

</body>
</html>