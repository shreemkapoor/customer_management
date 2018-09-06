<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<html>

<head>
</head>

<body>
	<h2>CRM - Customer Relationship Manager</h2>
	<hr>
	<!--  add our html table here -->
<div class="panel panel-info container">

				<div class="panel-heading">
					<div class="panel-title">Customer list</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">
	<table class="table">
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Action</th>

		</tr>
</thead>
		<!-- loop over and print our customers -->
		<tbody id="ctbody">
				<c:forEach var="tempCustomer" items="${customers}">
			<tr>
				<td>${tempCustomer.firstName}</td>
				<td>${tempCustomer.lastName}</td>
				<td>${tempCustomer.email}</td>
				<td><form method="post" action="showFormForUpdate" >
						<input type="submit" value="update"  class="btn btn-primary" />
						<input type="hidden" value="${csrf_token}" name="token" />
						<input type="hidden" value="${tempCustomer.id}" name="id" />
					</form></td><td>
					
						<button  class="btn btn-primary" onclick="deleteUser(${tempCustomer.id});">Delete</button>
							
							
					</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
</div>
</div>
	<button onclick="window.location.href='${pageContext.request.contextPath}/showFormForAdd'"  class="btn btn-success">Add a
		new Customer</button>
		<br><br>
		<button onclick="window.location.href='logout'" class="btn btn-danger">LOGOUT</button>
</body>
</html>