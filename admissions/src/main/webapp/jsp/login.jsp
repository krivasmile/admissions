<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>
<title>Sign in</title>
<link rel="stylesheet" href="css/login.css" type="text/css">
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css'>
</head>
<body>
		<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <form method="POST" action="${contextPath}/login" class="box">
                    <h1>Login</h1>
                    <p class="text-muted"> Please enter your login and password!</p>
                    <span>${message}</span> 
                    <input name="email" type="text" class="form-control" placeholder="Email"/>
                    <input name="password" type="password" class="form-control" placeholder="Password"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <span style="color:red">${error}</span> 
                    <a class="forgot text-muted" href="${contextPath}/registration">Create an account</a> 
                    <input type="submit" value="Login">
                </form>
            </div>
        </div>
    </div>
</div>

<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js'></script>

</body>
</html>