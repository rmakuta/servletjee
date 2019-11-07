<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07.11.2019
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<br>


<table>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>ISBN</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.isbn}</td>
        </tr>
    </c:forEach>
</table>


<%--Tytuł: ${book.title}</br>--%>
<%--Autor: ${book.author}</br>--%>
<%--ISBN: ${book.isbn}--%>
</body>
</html>
