<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <c:url value="/servlet" var="converterServlet">
            <c:param name="amount" value="100"></c:param>
        </c:url>

        <c:url value="/service" var="converterService">
            <c:param name="amount" value="100"></c:param>
        </c:url>

        <a href="${converterServlet}">Servlet Converter</a>
        <br/>
        <a href="${converterService}">Service Converter</a>
    </body>
</html>