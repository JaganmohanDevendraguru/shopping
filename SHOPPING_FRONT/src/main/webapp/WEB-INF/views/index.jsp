<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Spring form tag library -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- JSTL Tag library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--Context page  -->
<c:set var="context" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap Style sheet -->
<link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/css/bootstrap.min.css">

<!-- Custom styles for this template -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- Dynamic Title -->
<title>${title}</title>
</head>

<body>

	<!-- Navigation -->
	<%@include file="./shared/navbar.jsp"%>

	<!-- Page Content -->
	<div class="wrapper">
	<!-- Include Home only user clicks Home -->
	<c:if test="${userClickHome == true}">
		<%@include file="home.jsp"%>
	</c:if>
	<!-- Include About Us only user clicks About -->
		<c:if test="${userClickAbout == true}">
		<%@include file="about.jsp"%>
	</c:if>
	<!-- Include Contact us only user clicks Contact -->
		<c:if test="${userClickContact == true}">
		<%@include file="contact.jsp"%>
	</c:if>
</div>
	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/popper.js/umd/popper.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
