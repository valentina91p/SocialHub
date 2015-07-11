<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="signin" action="<c:url value='connect/facebook' />" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="hidden" name="scope" value="read_stream" />
		<button type="submit">Facebook</button>
	</form>
	<form action="<c:url value='connect/facebook' />" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="hidden" name="_method" value="delete" />
		<button type="submit">Quitar facebook</button>
	</form>
	<form action="<c:url value='connect/twitter' />" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button type="submit">Twitter</button>
	</form>
	<form action="<c:url value='connect/twitter' />" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="hidden" name="_method" value="delete" />
		<button type="submit">Quitar twitter</button>
	</form>
</body>
</html>