<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="jspf/header.jsp"%>
<body>
<h1>Nazwa</h1>
<h2>${recipe.name}</h2><br/>
<h2>Opis</h2>
<h3>${recipe.description}</h3><br/>
<h2>Łączna objętość</h2>
<h3>${recipe.volume}</h3>
</body>
<%@include file="jspf/footer.jsp"%>
</html>
