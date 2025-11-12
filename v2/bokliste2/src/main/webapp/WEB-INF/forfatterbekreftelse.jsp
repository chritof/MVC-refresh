<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Forfatter bekreftelse</title></head>
<body>
<h1>Forfatter lagret (uten DB)</h1>
<p>Fornavn: ${fnamevisning}</p>
<p>Etternavn: ${lnamevisning}</p>

<c:choose>
    <c:when test="${empty boktitler}">
        <p>Ingen bøker valgt.</p>
    </c:when>
    <c:otherwise>
        <p>Valgte bok-IDer: ${boktitler}</p>
    </c:otherwise>
</c:choose>
</body>
</html>