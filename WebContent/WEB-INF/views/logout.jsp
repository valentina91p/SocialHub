<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<h1>Hola ${ sessionScope.nombre } </h1>
 
	<c:url value="/logout" var="logoutUrl" />
 
		<!-- csrt support -->
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" 
			name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
 
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
 
</body>
</html>