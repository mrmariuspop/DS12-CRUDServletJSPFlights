<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	<%@ include file="error.css"%>
</style>
<title>Error</title>
</head>
<body>
<form>
<p id="error" ><span>Error!</span><p>
<p id="errormessage"><span><c:out value="${requestScope.err}"/></span></p>
</form>
</body>
</html>