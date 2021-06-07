<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Cocktail Mixer</title>
</head>

<header class="page-header">
    <nav>
        <a href="/home">
            Cocktail <span>Mixer</span>
        </a>
        <ul>
            <li>
                <a href="/recipe/addRecipe">dodaj przepis</a>
            </li>
            <li>
                <a href="/recipe/list">zobacz wszystkie</a>
            </li>
            <li>
                <a href="/alcohol/list">lista alkoholi</a>
            </li>
            <li>
                <a href="/alcohol/add">dodaj alkohol</a>
            </li>
            <li>
                <a href="/otherIngredient/list">lista innych składników</a>
            </li>
            <li>
                <a href="/otherIngredient/add">dodaj inny składnik</a>
            </li>
            <li>
                <form action="<c:url value="/logout"/>" method="post">
                    <input class="fa fa-id-badge" type="submit" value="Wyloguj">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </li>
        </ul>
    </nav>
</header>
