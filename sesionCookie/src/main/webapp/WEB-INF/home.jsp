<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Butikk</title>
</head>
<body>
<h1>Butikk:</h1>

<table>
    <thead>
    <tr>
        <th>Navn</th>
        <th>Pris</th>
        <th>Legg Til</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="vare" items="${vareliste}">
        <tr>
            <td>${vare.navn}</td>
            <td>${vare.pris}</td>
            <td>
                <form method="post" action="/legg-til">
                    <button type="submit" name="id" value="${vare.id}">
                        Legg til
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Handlekurv</h2>

<c:if test="${empty handlekurv}">
    <p>Handlekurven er tom.</p>
</c:if>

<c:if test="${not empty handlekurv}">
    <table>
        <thead>
        <tr>
            <th>Navn</th>
            <th>Pris</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="vare" items="${handlekurv}">
            <tr>
                <td>${vare.navn}</td>
                <td>${vare.pris}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>


<form action="/lag-cookie" method="post">
    <fieldset>
        <legend>Cookie form:</legend>
        <input type="text" name="tekst" placeholder="Lagres som cookie...">
        <button type="submit">Send Cookie</button>
    </fieldset>
</form>


<c:if test="${not empty cookieTekst}">
    <p>Lagret cookie: ${cookieTekst}</p>
</c:if>

<c:if test="${empty cookieTekst}">
    <p>Ingen cookie funnet.</p>
</c:if>


</body>
</html>