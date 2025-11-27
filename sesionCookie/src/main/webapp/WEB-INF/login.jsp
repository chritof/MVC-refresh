<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Butikk</title>
</head>
<body>
<h1>login:</h1>

<form method="POST" action="/login">
    <fieldset>
        <legend>Login</legend>
        <label>Username:</label>
        <input type="text" name="navn" />

        <label>Password:</label>
        <input type="password" name="password" />
        <input type="submit"/>
    </fieldset>
</form>

</body>
</html>