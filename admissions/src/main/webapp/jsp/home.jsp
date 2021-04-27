<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title><spring:message code="home.title"/></title>
<style>
header {
	background-image: url('image/university-blur.jpg')
}

h1, .lead {
	color: white;
}
</style>
</head>
<body>

	<!-- Navigation -->
	<jsp:include page="navbar.jsp"></jsp:include>

	<!-- Page Content -->
	<div class="container" style="min-height: 500px">
		<c:choose>
		<c:when test="${user.imageBase64 == null}">
		<form:form method="POST" action="${contextPath}/imageUpload"
			modelAttribute="user" enctype="multipart/form-data">
			<p><spring:message code="home.photo"/></p>
			<input type="file" name="image">
			<input type="submit" value="<spring:message code="home.upload"/>"/>
		</form:form>
		</c:when>
		</c:choose>


		<!-- Jumbotron Header -->
		<header class="jumbotron my-4">
			<h1 class="display-3"><spring:message code="home.welcome"/> ${user.firstName}!</h1>
			<p class="lead"><spring:message code="home.welcome_message"/></p>
		</header>

		<!-- Page Features -->
		<div class="row text-center">

			<c:if test="${not empty faculties}">
				<c:forEach items="${faculties}" var="currentFaculty">

					<div class="col-lg-3 col-md-6 mb-4">
						<div class="card h-100">
							<img class="card-img-top"
								src="data:image/png;base64, ${currentFaculty.imageBase64}"
								style="width: 100%; height: 250px;">
							<div class="card-body">
								<h4 class="card-title">${currentFaculty.name}</h4>
								<p class="card-text">${currentFaculty.description}</p>
							</div>
							<div class="card-footer">
								<a class="btn btn-primary"
									href="${contextPath}/registrationEntrant?facultyId=${currentFaculty.id}&email=${pageContext.request.userPrincipal.name}">
									<spring:message code="home.register"/></a>
							</div>
						</div>
					</div>

				</c:forEach>
			</c:if>

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>