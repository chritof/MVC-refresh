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
<h1>Emneliste</h1>
<!--Eneste denne c:if setningen gjør er hvis mendingen ikke er rett gitt fra backend eller den er tom
da skal den ikke vises-->
<c:if test="${not empty melding}">
    <p style="color:${farge}; font-weight:bold;">
            ${melding}
    </p>
</c:if>

<form action="registrer" method="post">
    <table>
        <thead>
        <tr>
            <th>Valg</th>
            <th>Kode</th>
            <th>Navn</th>
            <th>Stp</th>
            <th>Antall</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="emne" items="${emneliste}">
            <tr>
                <td>
                    <input type="checkbox"
                           name="valgteEmner"
                           value="${emne.kode}"/>
                </td>
                <td>${emne.kode}</td>
                <td>${emne.navn}</td>
                <td>${emne.studiepoeng}</td>
                <td>${emne.antall}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>Du kan maks krysse av for 3 emne</p>
    <input type="submit" value="Submit">
</form>

</body>
</html>