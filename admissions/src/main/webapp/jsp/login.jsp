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
<title><spring:message code="login.page_title"/></title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/login.css" type="text/css">
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css'>

<script type="text/javascript">
	$(document).ready(function() {
		var selItem = localStorage.getItem("locales");
		$('#locales').val(selItem ? selItem : 'en');
		$("#locales").change(function() {
			var selectedOption = $('#locales').val();
			if (selectedOption) {
				window.location.replace('?lang=' + selectedOption);
				localStorage.setItem("locales", selectedOption);
			}
		});
	});
</script>

</head>
<body>
		<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <form method="POST" action="${contextPath}/login" class="box">
                    <h1><spring:message code="login.title"/></h1>
                    <p class="text-muted"><spring:message code="login.massage"/></p>
                    <span>${message}</span> 
                    <input name="email" type="text" class="form-control" placeholder="<spring:message code="login.email"/>"/>
                    <input name="password" type="password" class="form-control" placeholder="<spring:message code="login.password"/>"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <span style="color:red">${error}</span> 
                    <a class="forgot text-muted" href="${contextPath}/registration"><spring:message code="login.create_account"/></a> 
                    <input type="submit" value="<spring:message code="login.login"/>">
                </form>
                
                <div>
				<fieldset>
					<label><spring:message code="login.choose_language" /></label> 
					<select id="locales">
						<option value="en"><spring:message code='login.english'/></option>
						<option value="ua"><spring:message code='login.ukrainian'/></option>
					</select>
				</fieldset>
			</div>
                
            </div>
        </div>
    </div>
</div>

</body>
</html>