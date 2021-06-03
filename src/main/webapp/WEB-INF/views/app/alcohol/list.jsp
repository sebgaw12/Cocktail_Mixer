<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@include file="jspf/header.jsp"%>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Nazwa</th>
        <th>Opis</th>
        <th>ABV</th>
    </tr>
    <c:forEach items="${alcohols}" var="alcohol">
        <tr>
            <td>${alcohol.id}</td>
            <td>${alcohol.name}</td>
            <td>${alcohol.description}</td>
            <td>${alcohol.abv}</td>
        </tr>
    </c:forEach>
</table>

<%@include file="jspf/footer.jsp"%>
</body>
</html>
