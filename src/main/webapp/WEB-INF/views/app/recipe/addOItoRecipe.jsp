<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@ include file="jspf/header.jsp"%>

<body>
<h3>Inne składniki</h3>
<form:form modelAttribute="recipeOtherIngredient">

    <%--        <form:form modelAttribute="otherIngredient">--%>
    <%--                <form:checkboxes path="empty" items="${otherIngredient}"/><br/>--%>
    <%--        </form:form>--%>
    <form:select path="otherIngredient" items="${otherIngredient}" itemLabel="name" itemValue="id"/>

    <form:input path="volumeAdd" id="volumeAdd"/>

    <form:select path="type">
        <form:option value="ml"/>
        <form:option value="szt"/>
        <form:option value="łyżeczek"/>
    </form:select>

</form:form>
</body>
</html>
