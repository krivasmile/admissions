<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
	<title>Welcome!</title>
	
	<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<h2>
				Welcome ${user.firstName}
				<c:choose>
				<c:when test="${user.imageBase64 != null}">
				<img alt="" src="data:image/png;base64, ${user.imageBase64}" width="22" height="17">
				</c:when>
				</c:choose>
				
				 | <button type="button" class="btn" onclick="document.forms['logoutForm'].submit()">Logout</button>
			</h2>
		</c:if>
		
		<div class="w3-container" style="display: flex">
				<c:if test="${not empty faculties}">
					<c:forEach items="${faculties}" var="currentFaculty">

						<div class="w3-card-4" style="width: 20%; margin: 2%">
							<img
								src="https://miro.medium.com/max/3000/1*YMFKP8e6kR9cbM3IKXBtLw.png"
								alt="Faculty logo" style="width: 100%">
							<div class="w3-container w3-center">
								<h3>${currentFaculty.name}</h3>
							</div>
							<a class="w3-button w3-block w3-dark-grey"
								href="${contextPath}/registrationEntrant?facultyId=${currentFaculty.id}&email=${pageContext.request.userPrincipal.name}">
								Register for the faculty</a>
						</div>
					</c:forEach>
				</c:if>
			</div>

	</div>

	<!-- /container -->
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>