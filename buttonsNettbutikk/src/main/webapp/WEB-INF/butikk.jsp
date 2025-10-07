<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Butikk</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h2 { color: #333; }
        .vare, .ordrelinje { margin-bottom: 10px; }
        button { margin-left: 5px; }
        hr { margin: 20px 0; }
    </style>
</head>

<body>

<h2>Våre populære buttons!</h2>

<c:forEach var="vare" items="${varer}">
    <div class="vare">
        <strong>${vare.navn}</strong><br>
        Beskrivelse: ${vare.beskrivelse}<br>
        Pris: ${vare.pris},-<br>

        <form action="${pageContext.request.contextPath}/handle" method="post">
            <input type="hidden" name="vareid" value="${vare.id}" />
            Antall:
            <input type="number" name="antall" min="1" max="10" value="1">
            <button type="submit">Legg i handlekurv</button>
        </form>
    </div>
</c:forEach>

<hr>

<h2>Din handlekurv</h2>

<c:if test="${sessionScope.handlekurv.tom}">
    <p><i>Handlekurven er tom</i></p>
</c:if>

<c:if test="${not sessionScope.handlekurv.tom}">
    <p><strong>Varenavn&nbsp;&nbsp;Stykkpris&nbsp;&nbsp;Antall&nbsp;&nbsp;Beløp</strong></p>

    <c:forEach var="ordrelinje" items="${sessionScope.handlekurv.ordrelinjer}">
        <div class="ordrelinje">
                ${ordrelinje.vare.navn}
            &nbsp;&nbsp; ${ordrelinje.vare.pris},-
            &nbsp;&nbsp; ${ordrelinje.antall}
            &nbsp;&nbsp; ${ordrelinje.belop},-

            <form action="${pageContext.request.contextPath}/fjerne" method="post" style="display:inline">
                <input type="hidden" name="vareid" value="${ordrelinje.vare.id}" />
                <button type="submit" title="Fjern">x</button>
            </form>
        </div>
    </c:forEach>

    <p>
        <strong>Totalt:</strong> ${sessionScope.handlekurv.total},- &nbsp;
    <form action="${pageContext.request.contextPath}/kasse" method="get" style="display:inline">
        <button type="submit">Gå til kassen</button>
    </form>
    </p>
</c:if>

</body>
</html>