<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Butikk</title>
    <link href="simple.css" rel="stylesheet">
    <style>

    </style>
</head>

<body>

<h2>!</h2>
<c:if test="${not empty error}">
    <p style="color:red;"><c:out value="${error}"/></p>
</c:if>
<c:if test="${not empty success}">
    <p style="color:green;"><c:out value="${success}"/></p>
</c:if>

<form method="POST" action="${pageContext.request.contextPath}/valgemner">
    <table>
        <tr>
            <th>Valg</th>
            <th>Kode</th>
            <th>Navn</th>
            <th>Stp</th>
            <th>Antall</th>
        </tr>

        <c:forEach var="emne" items="${emner}">
            <tr>
                <td><input type="checkbox" name="emnekoder" value="${emne.kode}"></td>
                <td>${emne.kode}</td>
                <td>${emne.navn}</td>
                <td>${emne.studiepoeng}</td>
                <td>${emne.antall}</td>
            </tr>
        </c:forEach>
    </table>

    <p>Du kan maks krysse av for 3 emner.</p>
    <button type="submit">Registrer dine valg!</button>
</form>




</body>
</html>