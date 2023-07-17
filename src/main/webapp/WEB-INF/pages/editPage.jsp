<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty user.name}">
        <title>Добавить</title>
    </c:if>
    <c:if test="${!empty user.name}">
        <title>Редактировать</title>
    </c:if>
</head>
<body>
<c:if test="${empty user.name}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty user.name}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty user.name}">
        <input type="hidden" name="id" value="${user.id}">
    </c:if>
    <label for="name">Имя</label>
    <input type="text" placeholder="введите имя" name="name" id="name" value="${not empty user.name ? user.name : ''}">
    <label for="age">Возраст</label>
    <input type="text" placeholder="введите возраст" name="age" id="age" value="${not empty user.age ? user.age : ''}">
    <label for="country">Страна</label>
    <input type="text" placeholder="введите страну" name="country" id="country" value="${not empty user.country ? user.country : ''}">
    <c:if test="${empty user.name}">
        <input type="submit" value="Добавить юзера">
    </c:if>
    <c:if test="${!empty user.name}">
        <input type="submit" value="Редактировать юзера">
    </c:if>
</form>
</body>
</html>