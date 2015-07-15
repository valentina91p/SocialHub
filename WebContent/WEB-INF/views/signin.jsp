<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:social="http://spring.io/springsocial">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <spring:url value="/resources/css/materialize.min.css" var="resources"/>
<link href="${pageContext.request.contextPath}/resources/css/materialize.min.css"  rel="stylesheet" type="text/css"></link> 

<!-- <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"> -->
	 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<style>
nav {
	background-color: RGBA(0, 0, 0, 0.8);
}

nav .nav-wrapper {
	max-width: 1200px;
	margin: 0 auto;
}

.btn, .btn-large{
   background-color: #6a1b9a;
}

.btn:hover, .btn-large:hover{
   background-color: #FF3E85;
}


h1.titulo {
	font-size: 50px;
	line-height: 36%;
	margin: 2rem 0 1rem 0;
	color: white;
}

span.subtitulo {
	font-size: 23px;
	font-weight: 300;
	color: #C5C5C5;
}

.container {
	max-width: 830px;
	padding-top: 60px;
}

.card-content{
	    padding: 36px 160px !important;
}


input[type=text]:focus:not([readonly])+label, input[type=password]:focus:not([readonly])+label, input[type=email]:focus:not([readonly])+label, input[type=url]:focus:not([readonly])+label, input[type=time]:focus:not([readonly])+label, input[type=date]:focus:not([readonly])+label, input[type=datetime-local]:focus:not([readonly])+label, input[type=tel]:focus:not([readonly])+label, input[type=number]:focus:not([readonly])+label, input[type=search]:focus:not([readonly])+label, textarea.materialize-textarea:focus:not([readonly])+label {
    color: #6a1b9a;
}
input[type=text]:focus:not([readonly]), input[type=password]:focus:not([readonly]), input[type=email]:focus:not([readonly]), input[type=url]:focus:not([readonly]), input[type=time]:focus:not([readonly]), input[type=date]:focus:not([readonly]), input[type=datetime-local]:focus:not([readonly]), input[type=tel]:focus:not([readonly]), input[type=number]:focus:not([readonly]), input[type=search]:focus:not([readonly]), textarea.materialize-textarea:focus:not([readonly]) {
    border-bottom: 1px solid #26a69a;
    box-shadow: 0 1px 0 0 #6a1b9a;
}

</style>
</head>
<body class="grey darken-4">
	<div>
		<nav>
			<div class="nav-wrapper">
				<a href="#" class="brand-logo center">Logo</a>
				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<li><a href="sass.html">Iniciar sesion</a></li>
					<li><a href="badges.html">Registrarte</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="container">
		<div>
			<h1 class="titulo">Inicia sesion</h1>
			<span class="subtitulo">ve tu timeline de <span
				style="color: #659FCB;'">twitter</span> y <span
				style="color: #3B5998;'">facebook </span>en un solo lugar
			</span>
		</div>
		<div>
			<div class="row">
				<div class="col s12 m12">
					<div class="card">
						<div class="card-image">
							<img src="<c:url value='/resources/img/Capture.JPG' />"> <span class="card-title">Card
								Title</span>
						</div>
						<div class="card-content">
							<form id="signin" action="<c:url value='signin' />" method="post">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								<div class="formInfo">
									<c:if test="${not empty param.error}">
										<div class="error">${param.error}</div>
									</c:if>
								</div>
								<div class="row">
									<div class="input-field col s12">
								          <input id="login" type="email"  name="email">
								          <label for="login">Email</label>
	        						</div> 
	        						<div class="input-field col s12">
								          <input id="password" type="password"  name="contrasena">
								          <label for="password">Contraseña</label>
	        						</div> 
								</div>
								<div class="center-align"> 
									<button class="center-align btn waves-effect waves-light" type="submit" name="action"><span style="vertical-align: top;">Sign In</span>
  								 	<i class="material-icons">send</i>
  								 </button></div>
								
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
</body>
</html>