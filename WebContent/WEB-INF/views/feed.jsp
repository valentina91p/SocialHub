<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
    <title>Test</title>
    
</head>
<body>
<h1>
    Hola ${ usuario.nombre }
</h1>

<c:if test="${!empty perfil}">
	<h4>${ perfil.name }</h4>
	<img src = "${ perfil.cover }" />
	<h6>${ perfil.gender }</h6>
	<h6>Cumplea&ntilde;os ${ perfil.birthday }</h6>
	<h6><a href="${ perfil.link }">Ir a mi perfil</a></h6>
	
</c:if> 

<c:if test="${!empty feed}">
    
    <c:forEach items="${feed}" var="post">
        <div>
        	<img src="${post.authorImage}"/>
            <h6>${post.author}</h6> wrote:
			<p>${post.message}</p>
			${post.createdAt}
			<img src="${post.image}"/>
			<hr/>
        </div>
    </c:forEach>
</c:if>
<c:url value="/signout" var="logoutUrl" />
 
		<!-- csrt support -->
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" 
			name="${_csrf.parameterName}"
			value="${_csrf.token}" />
			<input type="submit" value="Salir"/>
	</form>
</body>
</html>