<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h1><fmt:formatDate pattern="dd-MM-yyyy hh:mm:ss" value="${requestScope.date}" /></h1>

        <h2><fmt:formatNumber pattern="#,##0" value="${requestScope.price}" /></h2>
</body>
</html>
