<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forfatter bekreftelse</title>
    <link rel="stylesheet" href="simple.css">
</head>
<body>
<h1>Forfatter registrert</h1>

<p>Fornavn: ${fnamevisning}</p>
<p>Etternavn: ${lnamevisning}</p>

<c:choose>
    <c:when test="${empty boktitler}">
        <p>Ingen bøker valgt.</p>
    </c:when>
    <c:otherwise>
        <p>Valgte bøker:</p>
        <ul>
            <c:forEach var="t" items="${boktitler}">
                <li>${t}</li>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>

<p><a href="registrerforfatter">Registrer en til</a></p>
</body>
</html>