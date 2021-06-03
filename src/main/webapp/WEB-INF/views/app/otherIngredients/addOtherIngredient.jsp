<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="jspf/header.jsp"%>
<body>
<form:form method="post" modelAttribute="otherIngredient" action="/otherIngredient/add">

    <form:errors path="description"/>
    <form:errors path="name"/>

    <form:input path="name" id="name" placeholder="nazwa"/>

    <form:textarea path="description" id="description" placeholder="opis"/>

    <form:button value="submit" id="submit">dodaj</form:button>
</form:form>
</body>
</html>
