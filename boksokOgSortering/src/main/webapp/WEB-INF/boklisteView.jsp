<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="simple.css">
</head>
<body>
<h4>Bokliste</h4>
<a href="sokeside.html">Gjør et boksøk</a><br>
<a href="alleboker">Se listen av alle bøker</a><br>

<table>

    <tr>
        <th>Tittel</th>
        <th>Forfatter</th>
        <th>sjanger</th>
        <th>år</th>
    </tr>

    <c:forEach var="b" items="${boker}">
        <tr>
        <td>${b.tittel}</td>
        <td>${b.forfatter}</td>
        <td>${b.genre}</td>
        <td>${b.utgivelsesaar}</td>
        </tr>
    </c:forEach>
</table
</body>
</html>
