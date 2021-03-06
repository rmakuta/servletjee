<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 08.11.2019
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Books</title>
</head>
<body>

<form action="search-book" method="post">
    Tytuł: <input type="text" name="search">
    <input type="submit" value="szukaj"/>
    <c:if test="${not empty param.isTitle}">
        Nie ma takiego tytułu!
    </c:if>
</form></br>

<table>
    <tr>
        <th>|   ID  |</th>
        <th>|   Title  |</th>
        <th>|  Author  |</th>
        <th>|  ISBN  |</th>
        <th>|   |</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>|  ${book.id}  |</td>
            <td>|  ${book.title}  |</td>
            <td>|  ${book.author}  |</td>
            <td>|  ${book.isbn}  |</td>
            <td>| <a href="/delete-book?id=${book.id}" methods="">Usuń</a>   <a href="edit-book?id=${book.id}">Edytuj</a> |</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
