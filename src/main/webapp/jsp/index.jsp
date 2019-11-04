<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 03.11.2019
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
    <p>Param km: ${param.km} km</p>
    <p>Mile: ${param.km*1.60344} mil</p>
<jsp:include page="footer.jsp"/>
</body>
</html>
