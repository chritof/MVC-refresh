<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>alle boker</title>
    <link rel="icon" type="image/jpeg" href="/favicon.jpg"></head>
<body>
<h1>Online2..:</h1>
<form method="POST" action="/save-text">
    <textarea name="tekst">${tekst}</textarea>
    <button type="submit">Lagre</button>
</form>
</body>
</html>