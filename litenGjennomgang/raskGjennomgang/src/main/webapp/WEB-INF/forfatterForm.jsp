<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrer forfatter</title>
</head>
<body>
<h1>Forfatter form:</h1>

<c:if test="${not empty errors}">
    <ul>
        <c:forEach var="error" items="${errors}">
            <li>${error.defaultMessage}</li>
        </c:forEach>
    </ul>
</c:if>

<form method="POST" action="forfatter">
    <fieldset>
        <legend>Registrering</legend>
    <label>Name:</label>
    <input type = "text" name = "navn" value = "${forfatter.navn}"/>
    <label>E-mail:</label>
    <input type = "text" name = "email" value = "${forfatter.email}"/>
    <input type="submit" value="Submit">
    </fieldset>
</form>
</body>
</html>