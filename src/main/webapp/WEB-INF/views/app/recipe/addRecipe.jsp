<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@ include file="jspf/header.jsp" %>

<body>

<form:form method="post" modelAttribute="recipe" action="/recipe/addRecipe">

    <form:errors path="name"/>
    <form:errors path="volume"/>
    <form:input path="name" id="name" placeholder="nazwa"/><br/>

    <form:textarea path="description" id="description" placeholder="opis"/><br/>

    <p>Łączna objętość</p>
    <form:input path="volume" id="volume"/><br/>

    <form:button value="submit" name="submit">przejdź dalej</form:button>
<%--    <form:button><a href="/recipe/addAlcohol/${recipe.id}">dodaj alkohol</a></form:button>--%>
<%--    <form:button><a href="/recipe/addOI/${recipe.id}">dodaj inny składnik</a></form:button>--%>
</form:form>

<%@ include file="jspf/footer.jsp" %>
</body>
</html>
