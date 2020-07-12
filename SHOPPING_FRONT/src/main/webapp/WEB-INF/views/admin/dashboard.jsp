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
<link href="/css/dashboard.css" rel="stylesheet">

<!-- Dynamic Title -->
<title>${title}</title>
</head>
<body>

	<!-- Top navigation with the search button -->
	<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
		<a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Online
			Shopping</a> <input class="form-control form-control-dark w-100"
			type="text" placeholder="Search" aria-label="Search">
		<ul class="navbar-nav px-3">
			<li class="nav-item text-nowrap"><a class="nav-link" href="#">Sign
					out</a></li>
		</ul>
	</nav>

	<!-- Main content with left side -->
	<div class="container-fluid">
		<div class="row">
		<!-- Left side Navigation section -->
			<%@include file="./shared/adminnav.jsp" %>
			<!-- Top header under the search bar -->
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
					<h1 class="h2">Dashboard</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group mr-2">
							<button class="btn btn-sm btn-outline-secondary">Share</button>
							<button class="btn btn-sm btn-outline-secondary">Export</button>
						</div>
						<button class="btn btn-sm btn-outline-secondary dropdown-toggle">
							<span data-feather="calendar"></span> This week
						</button>
					</div>
				</div>

				<canvas class="my-4" id="myChart" width="900" height="380"></canvas>

				<h2>Section title</h2>
				<div class="table-responsive">
					<table class="table table-striped table-sm">
						<thead>
							<tr>
								<th>#</th>
								<th>Header</th>
								<th>Header</th>
								<th>Header</th>
								<th>Header</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1,001</td>
								<td>Lorem</td>
								<td>ipsum</td>
								<td>dolor</td>
								<td>sit</td>
							</tr>
						</tbody>
					</table>
				</div>
			</main>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- Bootstrap core JavaScript -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/popper.js/umd/popper.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<!-- Icons -->
	<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
	<script>
		feather.replace()
	</script>
</body>
</html>