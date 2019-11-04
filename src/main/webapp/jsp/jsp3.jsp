<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04.11.2019
  Time: 05:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Param a: ${empty param.a ? "brak" : param.a}</p>
<p>Param b: ${empty param.b ? "brak" : param.b}</p>

<p>Wartość ciasteczka foo: ${empty cookie.foo ? "empty" : cookie.foo.value}</p>
</body>
</html>
