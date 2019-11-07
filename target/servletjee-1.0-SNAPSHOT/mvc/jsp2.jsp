<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07.11.2019
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
Start: ${start}
End: ${end}
</br>
<c:forEach begin="${start}" end="${end}" var="i">
    ${i}
</c:forEach>
</body>
</html>
