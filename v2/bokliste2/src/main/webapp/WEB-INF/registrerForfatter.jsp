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
<h1>Registrer en Forfatter:</h1>

<form method="POST">

    <fieldset>fyll inn</fieldset>
    <label for="fffname">First name:</label>
    <input type="text" id="fffname" name="fname" placeholder="First name" />

    <label for="lllname">Last name:</label>
    <input type="text" id="lllname" name="lname" placeholder="Last name" />

    <fieldset>
        <legend>Velg bøker</legend>
        <c:forEach var="bok" items="${bokList}">
            <label>
                <input type="checkbox" name="bokIds" value="${bok.id}">
                    ${bok.title} (${bok.yearOfRelease})
            </label><br/>
        </c:forEach>
    </fieldset>

    <input type="submit" value="Submit" />

</form>

</body>
</html>