<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>alle boker</title>
    <link rel="stylesheet" href="simple.css">
    <link rel="icon" type="image/jpeg" href="/favicon.jpg"></head>
<body>
<h1>Alle bøker:</h1>


<table>
    <thead>
        <tr>
            <th>tittel</th>
            <th>utgivelsesår</th>
            <th>forfattere</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="bok" items="${bokList}">
            <tr>
                <td>${bok.title}</td>
                <td>${bok.yearOfRelease}</td>
                <td>
                    ${bok.authors}
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>