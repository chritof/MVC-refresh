<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Butikk</title>
</head>
<body>
<h1>Frukt:</h1>

<table>
    <thead>
        <tr>
            <th>Frukt</th>
            <th>Pris</th>
            <th>Legg til</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="f" items="${fruktListe}">
            <tr>
                <td>${f.navn}</td>
                <td>${f.pris}</td>
                <td>
                    <form method="POST" action="/frukt-leggtil">
                        <!--koden under er feil. feilen er at i controller har vi en @RequestParam int id, denne leter
                         etter et element med navn id 0g tar verdien til denne, i koden under har vi navn=id og
                         value=id, da sender vi i url-en en post som ser noe slik ut GET /frukt-leggtil?1=1
                         vi vil ha GET /frukt-leggtil?id=1-->
                        <!--<button type="submit" name="${f.id}" value="${f.id}">legg til</button> -->
                        <button type="submit" name="id" value="${f.id}">Legg til</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<c:if test="${not empty sessionFrukt}">
    <table>
        <thead>
        <tr>
            <th>Navn</th>
            <th>Pris</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="frukt" items="${sessionFrukt}">
            <tr>
                <td>${frukt.navn}</td>
                <td>${frukt.pris}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<p>${sessionAntall}</p>

</body>
</html>