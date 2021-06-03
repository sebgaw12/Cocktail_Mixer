<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="jspf/header.jsp"%>
<body>

<form:form method="post" modelAttribute="alcohol" action="/alcohol/add">

    <form:errors path="name"/>
    <form:input path="name" id="name" placeholder="nazwa"/><br/>

    <form:textarea path="description" id="description" placeholder="opis"/><br/>

    <form:errors path="abv"/>
    <p>zawartość alkoholu (sama liczba)</p>
    <form:input path="abv" id="abv"/><br/>

    <form:button value="submit" name="submit">dodaj</form:button>
</form:form>
</body>
<%@include file="jspf/footer.jsp"%>
</html>
