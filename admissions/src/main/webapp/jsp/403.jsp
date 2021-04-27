<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><spring:message code="403.page_title"/></title>
</head>
<body>
	<div>
		<div>
				<h3><spring:message code="403.message"/></h3>
		</div>
			<form action="/logout" method="post">
				<input type="submit" value="<spring:message code="403.change_user"/>"/>
				<input type="hidden" name="${_csrf.parameterName}" value ="${_csrf.token}"/>
			</form>
	
	</div>
</body>
</html>