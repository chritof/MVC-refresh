<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrer forfatter</title>
</head>
<body>
<h1>Form:</h1>
    <form method="POST" action="greet">
        <fieldset>
            <legend>Registrering</legend>
        </fieldset>
        <label>Name:</label>
        <input type = "text" name = "name" value = ""/>
        <input type="submit" value="Submit">
    </form>
</body>
</html>