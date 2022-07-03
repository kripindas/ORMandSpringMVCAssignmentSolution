<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>CRM</title>
</head>
<body>
	<div class="container">
		<h3
			style="background-color: #0dd70d; color: #fff; font-weight: bold; padding-left: 10px; margin-top: 10px; height: 50px; padding-top: 8px;">CUSTOMER
			RELATIONSHIP MANAGEMENT</h3>
		<hr>
		<!-- Add a search form -->
		<form action="/ORMandSpringMVCAssignmentSolution/customers/search"
			class="form-inline">
			<!-- Add a button -->
			<a href="/ORMandSpringMVCAssignmentSolution/customer/addCustomerForm"
				class="btn btn-primary btn-sm mb-3"> Add Customer </a>
		</form>
		<table class="table table-bordered table-striped"
			style="text-align: center;">
			<thead class="thead-dark">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Customers}" var="tempcustomer">
					<tr>
						<td><c:out value="${tempcustomer.firstName}" /></td>
						<td><c:out value="${tempcustomer.lastName}" /></td>
						<td><c:out value="${tempcustomer.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/ORMandSpringMVCAssignmentSolution/customer/showFormForUpdate?customerId=${tempcustomer.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a
							href="/ORMandSpringMVCAssignmentSolution/customer/delete?customerId=${tempcustomer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
								Delete </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>



