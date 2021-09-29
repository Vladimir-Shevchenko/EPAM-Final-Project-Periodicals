<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13.09.2021
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form  action="Logout"><input type="submit" value="Logout"></form>
</div>
<div align="right"><a href="ProfilServlet">To my profil</a></div>

<p>
    <div align="left"><img src="images/ordernow.PNG" height="60"></div>
<br>

<p style="color:blue;"><h6>Magazine title: </h6></u><h1>${nameConfirm}</h1></p>
<u><h6>Theme:  </h6></u><h1>${typeConfirm}</h1>
<u><h6>Description:  </h6></u><h1>${descriptionConfirm}</h1>
<div align="center"><u><h2>Price ONLY:  </h2></u><h1>${priceConfirm}</h1>
 <a href="ThankyouServlet"><img src="images/v.png" height="50" ></a>
</div>

</body>
</html>
