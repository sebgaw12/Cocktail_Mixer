<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="jspf/header.jsp"%>
<body>

<table>
    <tr>
        <th>ID</th>
        <th>Nazwa</th>
        <th>Opis</th>
    </tr>
    <c:forEach items="${otherIngredients}" var="otherIngredients">
        <tr>
            <td>${otherIngredients.id}</td>
            <td>${otherIngredients.name}</td>
            <td>${otherIngredients.description}</td>
        </tr>
    </c:forEach>
</table>

<%@include file="jspf/footer.jsp"%>
</body>
</html>
