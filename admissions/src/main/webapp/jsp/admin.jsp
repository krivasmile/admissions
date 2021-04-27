<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="admin.page_title"/></title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/admin.css" type="text/css">
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>

<body>

<!-- Navigation -->
	<jsp:include page="navbar.jsp"></jsp:include>

<div class="container">
		<h1><spring:message code="admin.welcome"/></h1>

	<h2><spring:message code="admin.accepted_title"/></h2>
	<table class="table table-bordered">
		<thead>
			<tr style="background:#2E8B57">
				<th><spring:message code="admin.faculty"/></th>
				<th><spring:message code="admin.photo"/></th>
				<th><spring:message code="admin.name"/></th>
				<th><spring:message code="admin.email"/></th>
				<th><spring:message code="admin.average_raiting"/></th>
				<th><spring:message code="admin.accepted"/></th>
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

	<h2><spring:message code="admin.denied"/></h2>
	<table class="table table-bordered">
		<thead>
			<tr style="background-color: #ff5c33">
				<th><spring:message code="admin.faculty"/></th>
				<th><spring:message code="admin.photo"/></th>
				<th><spring:message code="admin.name"/></th>
				<th><spring:message code="admin.email"/></th>
				<th><spring:message code="admin.average_raiting"/></th>
				<th><spring:message code="admin.accepted"/></th>
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