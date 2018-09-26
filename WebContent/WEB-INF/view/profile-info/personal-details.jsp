<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<head><title>Personal Details</title></head>

<form:form  modelAttribute="employee" id="empForm" method="get"
								 action="updateEmployee">
						
<div class="content-wrapper">
<div class="col-md-10 col-md-offset-1">

	
	<div class="employee-list">
	<!--  add our html table here -->
<div class="panel panel-primary">

				<div class="panel-heading">
					<div class="panel-title"><b>${employee.userName}</b></div>
				</div>

				<div style="padding-top: 30px" class="panel-body">
				<div class="heading"><h3>Personal Details</h3></div>
	<table class="table table-bordered table-responsive">
	<thead>
		
</thead>
		<!-- loop over and print our employees -->
		<tbody id="ctbody">	
			<tr>
				<td>Full name</td>
				<td>:</td>
				<td>${employee.userName}</td>	
			</tr>
			<tr>
				<td>Email</td>
				<td>:</td>
				<td>${employee.emailId}</td>	
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td>:</td>
				<td>${employee.mobileNumber}</td>	
			</tr>
			<tr>
				<td>Date of birth</td>
				<td>:</td>
				<td>${employee.DOB}</td>	
			</tr>
			<tr>
				<td>Gender</td>
				<td>:</td>
				<td>${employee.gender}</td>	
			</tr>
			<tr>
				<td>City</td>
				<td>:</td>
				<td>${employee.city}</td>	
			</tr>
			<tr>
				<td>Address</td>
				<td>:</td>
				<td>${employee.address}</td>	
			</tr>
			<tr>
				<td>Postal code</td>
				<td>:</td>
				<td>${employee.postalCode}</td>	
			</tr>
			<tr>
				<td>Designation</td>
				<td>:</td>
				<td>${employee.designation}</td>	
			</tr>	
		</tbody>
		
	</table>
	
						<input type="submit" value="Update details" class="btn btn-primary"  />
						<input type="hidden" value="${employee.emailId}" name="emailId" />
</div>
</div>
</div>
</div>
</div>
</form:form>