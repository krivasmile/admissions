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
				<c:choose>
				<c:when test="${facultyRegData.user.imageBase64 != null}">
				<img alt="" src="data:image/png;base64, ${facultyRegData.user.imageBase64}" width="100" height="70">
				</c:when>
				<c:otherwise>
				<tr>
					<th><img src="https://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg"></th>
						<th>You can add your photo on home page</th>
					</tr>
				</c:otherwise>
				</c:choose>
					<tr>
						<th>To register for the faculty fill the marks:</th>
					</tr>
					
					<c:forEach items="${facultyRegData.faculty.subjects}"
						var="currentSubject">
						<tr>
							<td>${currentSubject}</td>
							<td><input type="number" name="marksFromForm"/></td>
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