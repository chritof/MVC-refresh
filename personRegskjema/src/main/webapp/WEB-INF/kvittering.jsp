<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kvittering</title>
</head>
<body>
<h2>Kvittering</h2>
<p>Du registrerte følgende informasjon:</p>
<ul>
    <li>Navn: ${navn}</li>
    <li>Alder: ${alder}</li>
</ul>

<a href="/regskjema.html">Registrer en ny person</a>
</body>
</html>