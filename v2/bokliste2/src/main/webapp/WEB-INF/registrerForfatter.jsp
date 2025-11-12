<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrer forfatter</title>
    <link rel="stylesheet" href="<c:url value='/simple.css'/>">
</head>
<body>
<h1>Registrer en forfatter</h1>

<form method="POST" action="<c:url value='/registrerforfatter'/>">
    <label for="fname">Fornavn:</label>
    <input type="text" id="fname" name="fname" required />

    <label for="lname">Etternavn:</label>
    <input type="text" id="lname" name="lname" required />

    <fieldset>
        <legend>Velg bøker (flere valg mulig)</legend>
        <c:forEach var="bok" items="${bokList}">
            <label>
                <input type="checkbox" name="bokIds" value="${bok.id}">
                    ${bok.title} (${bok.yearOfRelease})
            </label><br/>
        </c:forEach>
    </fieldset>

    <input type="submit" value="Lagre" />
</form>
</body>
</html>