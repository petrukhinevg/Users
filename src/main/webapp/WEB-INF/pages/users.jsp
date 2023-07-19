<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<h2>Users</h2>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Country</th>

    </tr>
    <c:forEach var="user" items="${usersList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.country}</td>
            <td>
                <table>
                    <tr>
                        <td>
                            <form action="/edit/${user.id}" method="get">
                                <button type="submit">edit</button>
                            </form>
                        </td>
                        <td>
                            <form action="/delete/${user.id}" method="post">
                                <input type="hidden" name="_method" value="delete">
                                <button type="submit" onclick="return confirm('Точно???')">delete</button>
                            </form>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </c:forEach>
</table>

<h3>Add</h3>
<c:url value="/add" var="add"/>
<a href="${add}">Add new user</a>
</body>
</html>