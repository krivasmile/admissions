<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>Welcome!</title>
	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<style>
	body {
  		padding-top: 56px;
		}
	header {
	background-image: url('image/university-blur.jpg')
	}
	h1, .lead{
	color: white;
	}
	</style>
</head>
<body>
<%-- 	<div class="container">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<h2>
				Welcome ${user.firstName}
				<c:choose>
				<c:when test="${user.imageBase64 != null}">
				<img src="data:image/png;base64, ${user.imageBase64}" width="22" height="17">
				</c:when>
				<c:otherwise>
				<form:form method="POST" action="${contextPath}/imageUpload" modelAttribute="user" enctype="multipart/form-data">
				<p>Please, add your photo:</p>
				<input type="file" name="image">
				<input  type="submit" value="Upload"/>
				</form:form>
				</c:otherwise>
				</c:choose>
				
				 | <button type="button" class="btn" onclick="document.forms['logoutForm'].submit()">Logout</button>
			</h2>
		</c:if>
		<hr>	
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

	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script> --%>
	
	<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">UNIVERSITY</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/home">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">About</a>
          </li>
          <li class="nav-item">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<a type="button" class="btn" onclick="document.forms['logoutForm'].submit()" style="color:red">Logout</a>
		</c:if>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
      <h1 class="display-3">Welcome ${user.firstName}!</h1>
      <p class="lead">We believe, the secret behind each person's superpower lies in the ability to study hard, fast, and eagerly. That's why at our University, we have pulled the opportunities for your development. Just choose yours!</p>
    </header>

    <!-- Page Features -->
    <div class="row text-center">
    
    <c:if test="${not empty faculties}">
					<c:forEach items="${faculties}" var="currentFaculty">

						<div class="col-lg-3 col-md-6 mb-4">
						 <div class="card h-100">
							<img class="card-img-top"
								src="https://miro.medium.com/max/3000/1*YMFKP8e6kR9cbM3IKXBtLw.png"
								alt="Faculty logo" style="width: 100%">
								<div class="card-body">
								<h4 class="card-title">${currentFaculty.name}</h4>
								<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
								</div>
								<div class="card-footer">
            					<a class="btn btn-primary" 
            					href="${contextPath}/registrationEntrant?facultyId=${currentFaculty.id}&email=${pageContext.request.userPrincipal.name}">
            					Register for the faculty</a>
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
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Admissions 2021</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>