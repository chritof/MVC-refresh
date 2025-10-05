<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
${ansatte}

    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>navn</th>
                <th>kjonn</th>
                <th>lonn</th>
                <th>avdeling</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="ansatt" items="${ansatte}">
            <tr>
                <td>${ansatt.id}</td>
                <td>${ansatt.navn}</td>
                <td>${ansatt.kjonn}</td>
                <td>${ansatt.manedslonn}</td>
                <td>${ansatt.avdeling.navn}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>




</body>
</html>