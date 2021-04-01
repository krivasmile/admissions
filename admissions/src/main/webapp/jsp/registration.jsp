<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>
<link rel="stylesheet" href="css/login.css" type="text/css">
<meta charset="ISO-8859-1">
<title>Sign up</title>
</head>
<body>
<div class="container">
						<form:form modelAttribute="newUser" method="POST"
							action="${contextPath}/registration" class="form-signin">

							<spring:bind path="firstName">
								<div class="group form-group ${status.error ? 'has-error' : ''}">
									<label class="label">First Name</label>
									<form:input type="text" path="firstName"
										class="input form-control" placeholder="First name"
										autofocus="true"></form:input>
									<form:errors path="firstName"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="surname">
								<div class="group form-group ${status.error ? 'has-error' : ''}">
									<label for="surname" class="label">Surname</label>
									<form:input id="surname" type="text" path="surname"
										class="input form-control" placeholder="Surname"
										autofocus="true"></form:input>
									<form:errors path="surname"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="email">
								<div class="group form-group ${status.error ? 'has-error' : ''}">
									<label for="pass" class="label">Email Address</label>
									<form:input type="email" path="email"
										class="input form-control" placeholder="Email"
										autofocus="true"></form:input>
									<form:errors path="email"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="password">
								<div class="group form-group ${status.error ? 'has-error' : ''}">
									<label class="label">Password</label>
									<form:input type="password" path="password"
										class="form-control input" placeholder="Password"></form:input>
									<form:errors path="password"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="passwordConfirm">
								<div class="group form-group ${status.error ? 'has-error' : ''}">
									<label for="passConfim" class="label">Repeat Password</label>
									<form:input id="passConfim" type="password"
										path="passwordConfirm" class="form-control input"
										placeholder="Confirm your password"></form:input>
									<form:errors path="passwordConfirm"></form:errors>
								</div>
							</spring:bind>

							<div class="group">
								<input type="submit" class="button" value="Sign Up" />
							</div>
						</form:form>
						
					</div>

	<script
		src='https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</body>
</html>