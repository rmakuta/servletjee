<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.11.2019
  Time: 08:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit-book</title>
</head>
<body>
<form method="post" action="/edit-book">
    <p>Tytuł: <input type="text" name="title" value="${book.title}"/></p>
    <p>Author: <input type="text" name="author" value="${book.author}"/></p>
    <p>ISBN: <input type="number" name="isbn" value="${book.isbn}"/></p>
    <input type="hidden" name="id" value="${book.id}"/>
    <input type="submit" value="Zapisz zmiany!"/>
</form>
</body>
</html>
