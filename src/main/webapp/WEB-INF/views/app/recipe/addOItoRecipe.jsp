<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@ include file="jspf/header.jsp"%>

<body>
<h3>Inne składniki</h3>
<form:form modelAttribute="recipeOtherIngredients" method="post" action="/recipe/addOI">

    <form:select path="recipe" id="recipe" items="${recipes}" itemValue="id" itemLabel="name"/>

    <form:select path="otherIngredient" items="${otherIngredients}" itemLabel="name" itemValue="id"/>

    <form:input path="volumeAdd" id="volumeAdd"/>

    <form:select path="type">
        <form:option value="ml"/>
        <form:option value="szt"/>
        <form:option value="łyżeczek"/>
    </form:select>

    <form:button name="submit" value="submit">zapisz</form:button>

</form:form>
</body>
</html>
