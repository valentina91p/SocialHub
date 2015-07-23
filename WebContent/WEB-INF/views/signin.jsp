<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	  xmlns:social="http://spring.io/springsocial"
	  xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title></title>
	<link href="<c:url value='resources/css/materialize.min.css' />" rel="stylesheet"
		type="text/css"></link>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css">
</head>
<body>
	<div>
		<nav>
	    <div class="nav-wrapper">
	      <a href="#" class="brand-logo">Logo</a>
	      <ul id="nav-mobile" class="right hide-on-med-and-down">
	        <li><a href="sass.html">Sass</a></li>
	        <li><a href="badges.html">Components</a></li>
	        <li><a href="collapsible.html">JavaScript</a></li>
	      </ul>
	    </div>
	  </nav>
	</div>
		<div id="content" >
			<form id="signin" action="<c:url value='signin' />" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<div class="formInfo">
			  		<c:if test="${not empty param.error}">
						<div class="error">${param.error}</div>
					</c:if>
				</div>
				<fieldset>
					<label for="login">Email</label>
					<input id="login" name="email" type="text" size="25"></input>
					<label for="password">Password</label>
					<input id="password" name="contrasena" type="password" size="25"></input>
				</fieldset>
				<button type="submit">Sign In</button>
				
				<p>Some test user/password pairs you may use are:</p>
				<ul>
					<li>habuma/freebirds</li>
					<li>kdonald/melbourne</li>
					<li>rclarkson/atlanta</li>
				</ul>
				
				<p>Or you can <a href="<c:url value='signup'/>">signup</a> with a new account.</p>
			</form>
		</div>
		<script type="text/javascript" src="<c:url value='resources/js/materialize.min.js'/>"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
</body>
</html>