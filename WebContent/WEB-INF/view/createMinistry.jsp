<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script
	src="<c:url value='/resources/js/jquery-validation-1.15.1/dist/jquery.validate.js'/>"></script>
<script
	src="<c:url value='/resources/js/jquery-validation-1.15.1/dist/additional-methods.js'/>"></script>
<link rel="stylesheet"
	href="<c:url value='/resources/css/jquery.dataTables.min.css'/>">
	
<script src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>

<head>
<title>Create Ministry</title>

<script type="text/javascript">



$( document ).ready(function() {
	$('#ministryTable').DataTable();
$("#empForm").validate(
	{
	rules : {
				'ministryDesc' :{
					required : true,
					minlength: 4,
					maxlength : 30,
					alpanumericwithspace:true,
				}},
				messages : {
					
					'ministryDesc' :{
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
		$("#empForm").attr("action","createMinistry");
		$("#empForm").submit();

	

	}
		
	});
	
	});
function updateMinistry(ministrydesc,ministryid){
	$("#ministryDesc").val(ministrydesc);
	$("#ministryId").val(ministryid);
	
	}
	
function deleteUser(ministryId){	
	$.ajax({
		url:"deleteMinistry",
		type:"post",
		data:{"ministryId":ministryId},
		success:function(data){
			
			if(data==null){
				alert("fail");
			}else{ 	
	 var html="";
			for (var i= 0; i< data.length; i++) {
				html+="<tr><td>"+data[i].ministryId+"</td><td>"+data[i].ministryDesc+"</td><td><button onclick='updateMinistry("+data[i].ministryDesc+","+data[i].ministryId+");'><i class='fa fa-edit btn'></i></button></td><td><button onclick='deleteUser("+data[i].ministryId+");'><i class='fa fa-trash btn'></i></button></td></tr>";
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
				<div class="col-md-6 col-md-offset-2">
					<div class="userCreation">
						<div class="panel panel-primary">

							<div class="panel-heading">
								<h3 class="panel-title">Create Ministry</h3>
							</div>
							<div class="panel-body">
								<form:form modelAttribute="ministry" id="empForm">

									<div class="form-inline">
										<div class="col-md-6">
											<div class="form-group">
												<label class="proLabel">Ministry :</label>
												<form:input class="proInput form-control"
													path="ministryDesc" id="ministryDesc"
													required="required" />
												<form:input type="hidden" class="proInput form-control"
													path="ministryId" id="ministryId" />
												<div class="FeRror"></div>
												<form:errors cssStyle="color:red;" path="ministryDesc"></form:errors>
											</div>
										</div>
									</div>
									<div class="text-left">
										<input type="submit" value="Save" class="btn btn-primary ">
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>


			<div class="panel panel-primary">

				<div class="panel-heading">
					<div class="panel-title">Ministry list</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">
					<table id="ministryTable"
						class="table table-bordered table-responsive">
						<thead>
							<tr>
								<th>Ministry Id</th>
								<th>Ministry Description</th>
								<th>Update</th>
								<th>Delete</th>

							</tr>
						</thead>
						<!-- loop over and print our employees -->
						<tbody id="ctbody">
							<c:forEach var="tempEmployee" items="${ministries}">
								<tr>
									<td>${tempEmployee.ministryId}</td>
									<td>${tempEmployee.ministryDesc}</td>
									<td><button
											onclick="updateMinistry('${tempEmployee.ministryDesc}',${tempEmployee.ministryId});"><i class="fa fa-edit btn"></i></button>
									</td>
									<td>
										<button onclick="deleteUser(${tempEmployee.ministryId});"><i class="fa fa-trash btn"></i></button>
									</td>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>
			</div>
		</section>
	</div>