<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<form:form method="post" modelAttribute="user" action="/home/register">

    <form:errors path="username"/>
    <form:input path="username" id="username" name="username" placeholder="nazwa użytkownika"/><br/>
    <form:errors path="email"/><br/>
    <form:input path="email" id="email" name="email" placeholder="email"/><br/>
    <form:errors path="password"/>
    <form:password path="password" id="password" name="password" placeholder="hasło"/><br/>
    <form:button name="submit" value="submit">zarejestruj</form:button>
</form:form>

</body>
</html>
