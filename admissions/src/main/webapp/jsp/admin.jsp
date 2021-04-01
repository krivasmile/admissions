<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin console</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<style>
.hover{
background:#D8D8D8;
}
</style>
<body>
<div class="container">
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<form id="logoutForm" method="POST" action="${contextPath}/logout">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

		<h2>
			Welcome Admin |
			<button type="button" class="btn"
				onclick="document.forms['logoutForm'].submit()">Logout</button>
		</h2>
	</c:if>

	<h2>Accepted <small>(average rating more than 10)</small></h2>
	<table class="table table-bordered">
		<thead>
			<tr style="background:#2E8B57">
				<th>Faculty</th>
				<th>Photo</th>
				<th>Name</th>
				<th>Email</th>
				<th>Average rating</th>
				<th>Accepted</th>
			</tr>
		</thead>
		<tbody id="myTable">
			<c:forEach items="${registeredEntrants}" var="currentRegistration">
				<c:choose>
					<c:when test="${currentRegistration.isEnrolled}">
						<tr class="hide-show" style="cursor: pointer">
							<td align="center">${currentRegistration.faculty.name}</td>
							<td align="center"><c:choose>
									<c:when test="${currentRegistration.user.imageBase64 != null}">
										<img
											src="data:image/png;base64, ${currentRegistration.user.imageBase64}"
											width="90" height="60">
									</c:when>
									<c:otherwise>
										<img
											src="https://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg"
											width="90" height="60">
									</c:otherwise>
								</c:choose></td>
							<td align="center">${currentRegistration.user.firstName}
								${currentRegistration.user.surname}</td>
							<td align="center">${currentRegistration.user.email}</td>
							<td  align="center"><fmt:formatNumber type="number" maxFractionDigits="1" 
									value="${currentRegistration.marks.values().stream().map(v -> v).sum() / currentRegistration.faculty.subjects.size()}"/>
							</td>
							<td align="center">${currentRegistration.isEnrolled}</td>
						</tr>
						
						<c:forEach items="${currentRegistration.marks}" var="entry">
							<tr class="marks">
								<td colspan="4" align="center">${entry.key}</td>
								<td colspan="3" align="center">${entry.value}</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</c:forEach>
		</tbody>
	</table>

	<h2>Denied <small>(average rating less than 10)</small></h2>
	<table class="table table-bordered">
		<thead>
			<tr style="background-color: #ff5c33">
				<th align="center">Faculty</th>
				<th align="center">Photo</th>
				<th align="center">Name</th>
				<th align="center">Email</th>
				<th align="center">Average rating (>10 for enrolled)</th>
				<th align="center">Accepted</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${registeredEntrants}" var="currentRegistration">
				<c:choose>
					<c:when test="${!currentRegistration.isEnrolled}">
						<tr class="hide-show" style="cursor: pointer">
							<td  align="center">${currentRegistration.faculty.name}</td>
							<td  align="center"><c:choose>
									<c:when test="${currentRegistration.user.imageBase64 != null}">
										<img
											src="data:image/png;base64, ${currentRegistration.user.imageBase64}"
											width="90" height="60">
									</c:when>
									<c:otherwise>
										<img
											src="https://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg"
											width="90" height="60">
									</c:otherwise>
								</c:choose></td>
							<td align="center">${currentRegistration.user.firstName}
								${currentRegistration.user.surname}</td>
							<td  align="center">${currentRegistration.user.email}</td>
							<td  align="center"><fmt:formatNumber type="number" maxFractionDigits="1" 
									value="${currentRegistration.marks.values().stream().map(v -> v).sum() / currentRegistration.faculty.subjects.size()}"/>
							</td>
							<td  align="center">${currentRegistration.isEnrolled}</td>
						</tr>

						<c:forEach items="${currentRegistration.marks}" var="entry">
							<tr class="marks">
								<td colspan="5" align="center">${entry.key}</td>
								<td colspan="2" align="center">${entry.value}</td>
							</tr>
						</c:forEach>

					</c:when>
				</c:choose>

			</c:forEach>
		</tbody>
	</table>
	</div>

	<script>
		$(document)
				.ready(
						function() {
							$("#myInput")
									.on(
											"keyup",
											function() {
												var value = $(this).val()
														.toLowerCase();
												$("#myTable tr")
														.filter(
																function() {
																	$(this)
																			.toggle(
																					$(
																							this)
																							.text()
																							.toLowerCase()
																							.indexOf(
																									value) > -1)
																});
											});
						});
		
		$(document).ready(function() {
			$(".marks").hide();
			$(".hide-show").hover(function(){
				$(this).toggleClass("hover")
			});
			$(".hide-show").click(function() {
				$(this).nextAll("tr:lt(6)").toggle();
			});
		});
	</script>

</body>
</html>