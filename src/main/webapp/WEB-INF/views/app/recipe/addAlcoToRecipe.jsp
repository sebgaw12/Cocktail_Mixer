<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@ include file="jspf/header.jsp" %>

<body>

<h3>Alkohol</h3>

<form:form modelAttribute="recipeAlcohol" method="post" action="/recipe/addAlcohol/${recipe.id}">

    <form:select path="alcohol" id="alcohol" items="${alcohols}" itemValue="id" itemLabel="name"/>

    <form:input path="volumeAdd" id="volumeAdd"/>

    <form:select path="type" id="type">
        <form:option value="ml"/>
        <form:option value="dash"/>
    </form:select>

    <form:button name="submit" value="submit">przejdź dalej</form:button>

</form:form>
</body>
</html>
