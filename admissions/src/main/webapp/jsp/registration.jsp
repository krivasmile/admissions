<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/registration.css" type="text/css">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><spring:message code="registration.page_title"/></title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="card">
					 <form:form modelAttribute="newUser" method="POST"
						action="${contextPath}/registration" class="box">
						<h1><spring:message code="registration.title"/></h1>
						<spring:bind path="firstName">
						<spring:message code="registration.name" var="name"/>
							<div class="group form-group ${status.error ? 'has-error' : ''}">
								<form:input type="text" path="firstName"
									class="form-control" placeholder="${name}"></form:input>
								<form:errors path="firstName"></form:errors>
							</div>
						</spring:bind>

						<spring:bind path="surname">
						<spring:message code="registration.surname" var="surname"/>
							<div class="group form-group ${status.error ? 'has-error' : ''}">
								<form:input id="surname" type="text" path="surname"
									class="form-control" placeholder="${surname}"></form:input>
								<form:errors path="surname"></form:errors>
							</div>
						</spring:bind>

						<spring:bind path="email">
						<spring:message code="registration.email" var="email"/>
							<div class="group form-group ${status.error ? 'has-error' : ''}">
								<form:input type="email" path="email" class="form-control"
									placeholder="${email}"></form:input>
								<form:errors path="email"></form:errors>
							</div>
						</spring:bind>

						<spring:bind path="password">
						<spring:message code="registration.password" var="password"/>
							<div class="group form-group ${status.error ? 'has-error' : ''}">
								<form:input type="password" path="password"
									class="form-control" placeholder="${password}"></form:input>
								<form:errors path="password"></form:errors>
							</div>
						</spring:bind>

						<spring:bind path="passwordConfirm">
						<spring:message code="registration.passwordConfirm" var="passwordConfirm"/>
							<div class="group form-group ${status.error ? 'has-error' : ''}">
								<form:input id="passConfim" type="password"
									path="passwordConfirm" class="form-control"
									placeholder="${passwordConfirm}"></form:input>
								<form:errors path="passwordConfirm"></form:errors>
							</div>
						</spring:bind>

						<div class="group">
							<input type="submit" class="button" value="<spring:message code="registration.signup"/>" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>