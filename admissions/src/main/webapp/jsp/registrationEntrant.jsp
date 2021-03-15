<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" action="${contextPath}/registrationEntrant"
				modelAttribute="facultyRegData">
				<table>
					<tr>
						<th>To register for the faculty fill the marks:</th>
					</tr>

					<c:forEach items="${facultyRegData.faculty.subjects}"
						var="currentSubject">
						<tr>
							<td><form:label path="marks">${currentSubject}</form:label></td>
							<td><form:input path="marks" /></td>
						</tr>
					</c:forEach>

					<tr>
						<td><form:input type="hidden" path="facultyId"
								value="${facultyRegData.faculty.id}" /></td>
						<td><form:input type="hidden" path="email"
								value="${facultyRegData.user.email}" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Register" /></td>
					</tr>

				</table>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form:form>
</body>
</html>