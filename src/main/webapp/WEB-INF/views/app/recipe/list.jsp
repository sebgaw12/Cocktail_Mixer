<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@ include file="../recipe/jspf/header.jsp" %>

<body>

<table>
    <tr>
        <th>ID</th>
        <th>Nazwa</th>
<%--        <th>Dodany przez</th>--%>
        <th>Akcja</th>
    </tr>
    <c:forEach items="${recipes}" var="recipe">
        <tr>
            <td>${recipe.id}</td>
            <td>${recipe.name}</td>
<%--            <td>${recipe.user.username}</td>--%>
            <td>
                <a href="<c:url value="/recipe/details/${recipe.id}"/>">szczegóły</a>
<%--                <a href="<c:url value="/recipe/edit/${recipe.id}"/>">edytuj</a>--%>
            </td>
        </tr>
    </c:forEach>
</table>

<%@ include file="../recipe/jspf/footer.jsp" %>
</body>
</html>
