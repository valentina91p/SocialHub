<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	  xmlns:social="http://spring.io/springsocial"
	  xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	  layout:decorator="layout">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div id="content" >
			<form id="signin" action="<c:url value='signup' />" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<div class="formInfo">
			  		<c:if test="${not empty param.error}">
						<div class="error">${param.error}</div>
					</c:if>
				</div>
				<fieldset>
					<label for="login">Email</label>
					<input id="login" name="email" type="text" size="25"></input>
					<label for="Nombre">Email</label>
					<input id="nombre" name="nombre" type="text" size="25"></input>
					<label for="password">Password</label>
					<input id="password" name="contrasena" type="password" size="25"></input>
				</fieldset>
				<button type="submit">Sign In</button>
				
				
				<p>Or you can <a href="<c:url value='signin'/>">signin</a> with a new account.</p>
			</form>
		</div>
</body>
</html>