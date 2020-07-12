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
	<%@include file="./shared/adminsearch.jsp"%>

	<!-- Main content with left side -->
	<div class="container-fluid">
		<div class="row">
			<!-- Left side Navigation section -->
			<%@include file="./shared/adminnav.jsp"%>
			<!-- Top header under the search bar -->
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
				<%@include file="./shared/admintop.jsp"%>


				<!-- Category Creation Form inside the card-->
				<div class="card border-primary">
					<!-- Card header-->
					<div class="card-header bg-primary">
						<h4>Category Form</h4>
					</div>
					<!-- Card header end -->
					<!-- Card body start-->
					<div class="card-body">
						<c:if test="${error != null}">
							<p class="alert alert-danger alert-dismissible fade show" role="alert">${error}</p>
						</c:if>
						<form:form action="${context}/view/categories/create"
							method="POST" enctype="multipart/form-data"
							modelAttribute="category">
								<div class="form-group row">
									<label class="col-sm-2 col-form-label"><span class="text-danger">* </span>Category Name:</label>
									<div class="col-sm-8">
									<form:input path="categoryName" class="form-control" />
									<form:errors path="categoryName" cssClass="text-danger"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-2 col-form-label"><span class="text-danger">* </span>Description:</label>
									<div class="col-sm-8">
									<form:input path="description" class="form-control" />
									<form:errors path="description" cssClass="text-danger"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-2 col-form-label"><span class="text-danger">* </span>File:</label> 
									<div class="col-sm-8">
									<form:input type="file"
									 path="file" class="form-control-file" />
									 <form:errors path="file" cssClass="text-danger"></form:errors>
									 </div>
								</div>
							<div class="form-group row">
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">Create</button>
								</div>
							</div>
						</form:form>
						<!-- Form end -->
					</div>
					<!-- Card body end-->
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