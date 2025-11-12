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
<h1>Forfattere:</h1>

<table>
    <thead>
    <tr>
        <th>fornavn</th>
        <th>etternavn</th>
        <th>bøker</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="f" items="${forfattere}">
        <tr>
            <td>${f.authorFName}</td>
            <th>${f.authorLName}</th>
            <th>
                <c:forEach var="bok" items="${f.books}">
                    ${bok}
                </c:forEach>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>