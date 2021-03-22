<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Faculty Registration</title>
</head>
<body>
	<form:form method="POST" action="${contextPath}/registrationEntrant"
				modelAttribute="facultyRegData" enctype="multipart/form-data">
				<table>
					<tr>
						<th>Please, add your photo:</th>
					</tr>
					<tr>
						<td><input type="file" name="image"></td>
					</tr>
					<tr>
						<th>To register for the faculty fill the marks:</th>
					</tr>
					
					<c:forEach items="${facultyRegData.faculty.subjects}"
						var="currentSubject">
						<tr>
							<td>${currentSubject}</td>
							<td><input type="number" name="marks"/></td>
						</tr>
					</c:forEach>

					<tr>
						<td><input  type="hidden"  name="facultyId" value="${facultyRegData.faculty.id}"/></td>
						<td><input  type="hidden" name="email" value="${facultyRegData.user.email}"/></td>
					</tr>
					<tr>
						<td><input  type="submit" value="Register"/></td>
					</tr>

				</table>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

			</form:form>
</body>
</html>