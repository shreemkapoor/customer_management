<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<title>Create Role</title>
  <script src="<c:url value='/resources/js/jquery-validation-1.15.1/dist/jquery.validate.js'/>"></script>
  <script src="<c:url value='/resources/js/jquery-validation-1.15.1/dist/additional-methods.js'/>"></script>
  <link rel="stylesheet"
	href="<c:url value='/resources/css/jquery.dataTables.min.css'/>">
	
<script src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<script type="text/javascript">
$( document ).ready(function() {
	$('#roleTable').DataTable();
$("#empForm").validate(
	{
	rules : {
				'roleDesc' :{
					required : true,
					minlength: 4,
					maxlength : 30,
					alpanumericwithspace:true,
				}},
				messages : {
					
					'roleDesc' :{
						required : "Field cannot be empty",
						minlength: "Should be more than 4 characters",
						maxlength : "Firstname should be less than 30 characters",
					}},
					errorPlacement : function(error,element) {
						error.addClass("help-block");
						$(element).next('.FeRror').html(
						error.text()).css('display', 'block');

				},
					highlight : function(element,errorClass, validClass) {
					$(element).parent().addClass("has-error").removeClass("has-success");
				},
					unhighlight : function(element,errorClass, validClass) {
					if ($(element).parent().hasClass('has-error')) {
					$(element).parent().addClass("has-success").removeClass("has-error");
					$(element).next('.FeRror').css('display', 'none');
				}
		},
	submitHandler : function(form) {
	
		$("#empForm").attr("method","post");
		$("#empForm").attr("action","createRole1");
		$("#empForm").submit();

	

		/* $.ajax({
			url:"createRole1",
			type:"post",
			success:function(data){
				
				if(data==null){
					alert("fail");
				}else{ 	
		 var html="";
				for (var i= 0; i< data.length; i++) {
					html+="<tr><td>"+data[i].roleId+"</td><td>"+data[i].roleDesc+"</td></tr>";
				}
				$("#ctbody").html(""); 
			$("#ctbody").html(html); 
			/* $("#empForm").submit(); 
			$("#empForm").reset();
				}
				
			},error:function(e){
			
			}
		}); */
	}
		
	});
	
	});
function updateRole(roledesc,roleId){
	$("#roleDesc").val(roledesc);
	$("#roleId").val(roleId);
	
	}
	
function deleteUser(roleId){
	alert("GVfg");	
	$.ajax({
		url:"deleteRole",
		type:"post",
		data:{"roleId":roleId},
		success:function(data){
			
			if(data==null){
				alert("fail");
			}else{ 	
	 var html="";
			for (var i= 0; i< data.length; i++) {
				html+="<tr><td>"+data[i].roleId+"</td><td>"+data[i].roleDesc+"</td><td><button onclick='updateRole("+data[i].roleDesc+","+data[i].roleId+");'><i class='fa fa-edit btn'></i></button></td><td><button onclick='deleteUser("+data[i].roleId+");'><i class='fa fa-trash btn'></i></button></td></tr>";
			}
			$("#ctbody").html(""); 
		$("#ctbody").html(html); 
			}
			
		},error:function(e){
		
		}
	});
}


</script>
  
 </head>

<body>


<div class="content-wrapper" style="min-height: 990px;">
    
    <!-- Main content -->
    <section class="content">
      <div class="row">
			<div class="col-md-6 col-md-offset-2" >
				<div class="userCreation">
				<div class="panel panel-primary">
				
				<div class="panel-heading"><h3 class="panel-title">Create Role</h3></div>
					<div class="panel-body">
						<form:form  modelAttribute="role"  id="empForm" >
						
						<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Role :</label>
						    <form:input class="proInput form-control" path="roleDesc" id="roleDesc" required="required" />
						    <form:input type="hidden"  class="proInput form-control" path="roleId" id="roleId" />
						     <div class="FeRror"></div>
						    <form:errors cssStyle="color:red;"  path="roleDesc"  ></form:errors>
						  </div>
						 </div>  
						</div>
					<div class="text-left">
				         <input type="submit" value="Save"  class="btn btn-primary" >
				        </div>
						</form:form>
						</div>
						</div></div>
						</div></div>
						
						
						<div class="panel panel-primary">

				<div class="panel-heading">
					<div class="panel-title">Role list</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">
	<table id="roleTable" class="table table-bordered table-responsive">
	<thead>
		<tr>
			<th>Role Id</th>
			<th>Role Description</th>
			<th>Update</th>
			<th>Delete</th>

		</tr>
</thead>
		<!-- loop over and print our employees -->
		<tbody id="ctbody">
				<c:forEach var="tempEmployee" items="${roles}">
			<tr>
				<td>${tempEmployee.roleId}</td>
				<td>${tempEmployee.roleDesc}</td>
				 <td><button  onclick="updateRole('${tempEmployee.roleDesc}',${tempEmployee.roleId});"><i class="fa fa-edit btn"></i></button>	
						</td>
						<td>
						<button  onclick="deleteUser(${tempEmployee.roleId});"><i class="fa fa-trash btn"></i></button>	
					</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
</div>
</div>
</section></div>		
</body>
</html>