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
<title>Sign in/ Sign up</title>
<link rel="stylesheet" href="login.css" type="text/css">
</head>
<body>
	<div class="row">
		<div class="col-md-6 mx-auto p-0">
			<div class="cardt">
				<div class="login-box">
					<div class="login-snip">
						<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
							for="tab-1" class="tab">Login</label> <input id="tab-2"
							type="radio" name="tab" class="sign-up"><label
							for="tab-2" class="tab">Sign Up</label>
						<div class="login-space">
							<form method="POST" action="${contextPath}/login" class="login">
								<div class="form-group ${error != null ? 'has-error' : ''}">
									<div class="group">
										<label for="user" class="label mb-1">Email</label> <input
											id="user" name="email" type="text" class="input form-control"
											placeholder="Enter your Email">
									</div>
									<div class="group">
										<label for="pass" class="label mb-1">Password</label> <input
											id="pass" name="password" type="password"
											class="input form-control" placeholder="Enter your password">
										<span>${error}</span> <input type="hidden"
											name="${_csrf.parameterName}" value="${_csrf.token}" />
									</div>
									<div class="group">
										<button type="submit" class="button">Sign In</button>
									</div>
									<span>${message}</span>
									<div class="hr"></div>
									<div class="foot">
										<a href="#">Forgot Password?</a>
									</div>
								</div>
							</form>
							<div class="sign-up-form">
								<form:form method="POST" modelAttribute="userForm"
									class="form-signin">

									<spring:bind path="firstName">
										<div
											class="group form-group ${status.error ? 'has-error' : ''}">
											<label for="user" class="label">First Name</label>
											<form:input id="user" type="text" path="firstName"
												class="input form-control" placeholder="First name"
												autofocus="true"></form:input>
											<form:errors path="firstName"></form:errors>
										</div>
									</spring:bind>

								<spring:bind path="surname">
									<div
										class="group form-group ${status.error ? 'has-error' : ''}">
										<label for="user" class="label">Surname</label>
										<form:input id="user" type="text" path="surname"
											class="input form-control" placeholder="Surname"
											autofocus="true"></form:input>
										<form:errors path="surname"></form:errors>
									</div>
								</spring:bind>

								<spring:bind path="email">
									<div
										class="group form-group ${status.error ? 'has-error' : ''}">
										<label for="pass" class="label">Email Address</label>
										<form:input id="pass" type="email" path="email"
											class="input form-control" placeholder="Email"
											autofocus="true"></form:input>
										<form:errors path="email"></form:errors>
									</div>
								</spring:bind>

								<spring:bind path="password">
									<div
										class="group form-group ${status.error ? 'has-error' : ''}">
										<label for="pass" class="label">Password</label>
										<form:input id="pass" type="password" path="password"
											class="form-control input" placeholder="Password"></form:input>
										<form:errors path="password"></form:errors>
									</div>
								</spring:bind>

								<spring:bind path="passwordConfirm">
									<div class="group form-group ${status.error ? 'has-error' : ''}">
									<label for="pass" class="label">Repeat Password</label>
										<form:input id="pass" type="password" path="passwordConfirm"
											class="form-control input" placeholder="Confirm your password"></form:input>
										<form:errors path="passwordConfirm"></form:errors>
									</div>
								</spring:bind>

								<div class="group">
									<button class="button" type="submit">Submit</button>
								</div>
								</form:form>
								<div class="hr"></div>
								<div class="foot">
									<label for="tab-1">Already Member?</label>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src='https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>

</body>
</html>