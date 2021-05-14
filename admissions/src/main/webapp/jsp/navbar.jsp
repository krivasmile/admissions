<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
</head>
<link rel="stylesheet" href="css/navbar.css" type="text/css">
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#"> 
			<c:choose>
					<c:when test="${user.imageBase64 != null}">
						<img src="data:image/png;base64, ${user.imageBase64}" width="26"
							height="21"> ${user.firstName} ${user.surname}
      				</c:when>
	  				<c:otherwise>
     					 ${user.firstName} ${user.surname}
      				</c:otherwise>
			</c:choose>
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active">
					<a class="nav-link toggle" href="/home"><spring:message code="navbar.home" /> 
						<span class="sr-only">(current)</span> </a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="https://github.com/krivasmile/admissions"><spring:message
								code="navbar.about" /></a>
					</li>
					<li class="nav-item"><c:if
							test="${pageContext.request.userPrincipal.name != null}">
							<form id="logoutForm" method="POST"
								action="${contextPath}/logout">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
							<a type="button" class="btn"
								onclick="document.forms['logoutForm'].submit()"
								style="color: red"><spring:message code="navbar.logout" /></a>
						</c:if>
					</li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>