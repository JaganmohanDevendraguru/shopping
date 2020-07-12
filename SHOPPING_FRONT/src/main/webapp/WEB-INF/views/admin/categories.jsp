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


				<!-- List of Categories inside the card-->
				<div class="card border-primary">
					<!-- Card header for filter -->
					<div class="card-header">
						<c:if test="${success != null}">
							<p class="alert alert-success alert-dismissible fade show"
								role="alert">${success}</p>
						</c:if>
					</div>
					<!-- Card body -->
					<div class="card-body">
						<!-- Card title -->
						<!-- <h4 class="card-title">Card title goes here</h4> -->
						<!-- Table start for content -->
						<div class="table-responsive">
							<c:if test="${categories.size() != 0}">
								<table class="table table-striped table-sm">
									<thead>
										<tr>
											<th>Logo</th>
											<th>Id</th>
											<th>Name</th>
											<th>Description</th>
											<th>Active</th>
										</tr>
									</thead>
									<tbody>
										<!-- Actual data looping over the tr in table -->
										<c:forEach var="cat" items="${categories}">
											<tr>
												<td><img class="logo" alt="${cat.categoryName}"
													src="${context}/uploads/${cat.picturePath}" /></td>
												<td>${cat.categoryId}</td>
												<td>${cat.categoryName}</td>
												<td>${cat.description}</td>
												<!-- Switch toggle for activation -->
												<td><label class="switch"> <input
														type="checkbox" checked value="${cat.categoryId}"> <span
														class="slider round"></span>
												</label></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:if>
						</div>
						<!-- Card footer for main -->
						<div class="card-footer text-muted">

							<div class="row">
								<!-- Button trigger modal inside the card footer-->
								<button type="button" class="btn btn-outline-primary"
									data-toggle="modal" data-target="#exampleModalCenter">Add
									New</button>

								<!-- Modal content button-->
								<div class="modal fade" id="exampleModalCenter" tabindex="-1"
									role="dialog" aria-labelledby="exampleModalCenterTitle"
									aria-hidden="true">
									<div class="modal-dialog modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalCenterTitle">Modal
													title</h5>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<!-- Model Body and the Form goes -->
											<div class="modal-body">
												<form>
													<div class="form-group">
														<label for="recipient-name" class="col-form-label">Recipient:</label>
														<input type="text" class="form-control"
															id="recipient-name">
													</div>
													<div class="form-group">
														<label for="message-text" class="col-form-label">Message:</label>
														<textarea class="form-control" id="message-text"></textarea>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Close</button>
												<button type="button" class="btn btn-primary">Save
													changes</button>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
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