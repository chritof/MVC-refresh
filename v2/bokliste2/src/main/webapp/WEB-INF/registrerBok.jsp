<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrer forfatter</title>
    <link rel="stylesheet" href="simple.css">
</head>
<body>
<h1>Registrer en forfatter</h1>
    <form action="/forfatter" method="post">
        <label for="title">tittel:</label>
        <input type="text" name="title" id="title" placeholder="title..." />

        <label for="year">year:</label>
        <input type="number" name="year" id="year" placeholder="year..." />

        <c:forEach var="forfatter" items="${forfatternavn}">
            <label>
                <input type="checkbox" name="${forfatter}" id="${forfatter}">
                ${forfatter}
                <br>
            </label>
        </c:forEach>

        <input type="submit"  value="submit" />
    </form>

</body>
</html>