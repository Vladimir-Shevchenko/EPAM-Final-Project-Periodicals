<%@ page contentType="text/html;charset=UTF-8" language="java"   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${lang}"/>

<fmt:setBundle basename="messages"/>

<html>
<head>

    <title>PhraseApp - i18n</title>
</head>
<body>

<form action = "I18Servlet" method="post">
    <select name="lan">
        <option>En</option>
        <option>Ru</option>
    </select>
    <input type="submit" name="go" value="Apply" />


</form>



<h2>
    <fmt:message key="label.welcome" />
</h2>
Волчок
</body>
</html>