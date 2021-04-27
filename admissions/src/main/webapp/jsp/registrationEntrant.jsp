<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/registrationEntrant.css" type="text/css">
<title><spring:message code="registrationEntrant.title"/></title>
</head>
<body>

<!-- Navigation -->
	<jsp:include page="navbar.jsp"></jsp:include>

<!-- Page Content -->
	 <div class="container" style="min-height: 600px">


	<form:form method="POST" action="${contextPath}/registrationEntrant"
				modelAttribute="facultyRegData" enctype="multipart/form-data" class="jumbotron">
				<h1 class="mb-5">${facultyRegData.faculty.name}</h1>
				<h5><spring:message code="registrationEntrant.fill_marks"/>:</h5>
				<table>
					<c:forEach items="${facultyRegData.faculty.subjects}"
						var="currentSubject">
						<tr>
							<td>${currentSubject}</td>
							<td><input type="number" name="marksFromForm"/></td>
						</tr>
					</c:forEach>

					<tr>
						<td><input  type="hidden"  name="facultyId" value="${facultyRegData.faculty.id}"/></td>
						<td><input  type="hidden" name="email" value="${facultyRegData.user.email}"/></td>
					</tr>
				</table>
				<input type="submit" value="<spring:message code="registrationEntrant.register"/>"/>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

			</form:form>
	</div>

	<!-- /.container -->
	
	 <!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
			
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>