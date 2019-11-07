<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07.11.2019
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/mvc14" method="POST">
    <c:forEach begin="1" end="5" varStatus="loopStatus">
        <label>
            Tiltle${loopStatus.count}:
            <input type="text" name="title${loopStatus.count}">
        </label>
        <label>
            Author${loopStatus.count}:
            <input type="text" name="author${loopStatus.count}">
        </label>
        ISBN${loopStatus.count}:
        <input type="text" name="isbn${loopStatus.count}"></br>
        </label>
    </c:forEach>
    <input type="submit">
</form>
</body>
</html>
