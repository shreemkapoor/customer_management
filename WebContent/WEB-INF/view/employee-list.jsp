<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<html>

<head>
</head>

<body>
<%@include file="header.jsp" %>
<%@include file="side-layout.jsp" %>
<div class="content-wrapper">
<div class="col-md-10 col-md-offset-1">

	
	<div class="employee-list">
	<!--  add our html table here -->
<div class="panel panel-primary">

				<div class="panel-heading">
					<div class="panel-title">Employee list</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">
	<table class="table table-bordered table-responsive">
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Designation</th>
			<th colspan="2" style="text-align:center;">Action</th>

		</tr>
</thead>
		<!-- loop over and print our employees -->
		<tbody id="ctbody">
				<c:forEach var="tempEmployee" items="${employees}">
			<tr>
				<td>${tempEmployee.firstName}</td>
				<td>${tempEmployee.lastName}</td>
				<td>${tempEmployee.designation}</td>
				<td><form  action="updateEmployee" >
						<input type="submit" value="update" />
						<input type="hidden" value="${tempEmployee.emailId}" name="emailId" />
					</form></td><td>
					
						<button  onclick="deleteUser(${tempEmployee.emailId});">Delete</button>
							
							
					</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
</div>
</div>
</div>
</div>
</div>
<%@include file="footer.jsp" %>
</body>

</html>