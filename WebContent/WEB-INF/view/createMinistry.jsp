<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <script src="<c:url value='/resources/js/jquery-validation-1.15.1/dist/jquery.validate.js'/>"></script>
  <script src="<c:url value='/resources/js/jquery.serializeJSON-master/jquery.serializejson.min.js'/>"></script>
  <script src="<c:url value='/resources/js/jquery-validation-1.15.1/dist/additional-methods.js'/>"></script>
<%--   <script src="<c:url value='/resources/js/dataTables.bootstrap.min.js'/>" type="text/javascript" ></script> --%>
  <script src="<c:url value='/resources/js/jquery.dataTables.min.js'/>" type="text/javascript" ></script>
<link rel="stylesheet" href="<c:url value='/resources/css/dataTables.bootstrap.min.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/jquery.dataTables.min.css'/>">
<script type="text/javascript">
(function($) {
	$.fn.serializeFormJSON = function() {

		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
})(jQuery)
$( document ).ready(function() {
	
	$("#minForm")
	.validate(
		{
			rules : {
				'ministryName' : {
					required : true,
					maxlength : 40,
					minlength : 4,
				},
							},
			messages : {
				'ministryName' : {
					required : "Please enter Email",
					maxlength : "Email Should be less than or equal to 40 characters",
					email : "please enter vaild email"
				},
				
			},
			errorPlacement : function(error,
				element) {
			 error.addClass("help-block");
				$(element).next('.FeRror').html(
					error.text()).css(
					'display', 'block'); 

			},
			highlight : function(element,
				errorClass, validClass) {
	 		$(element).parent().addClass(
					"has-error").removeClass(
					"has-success"); 
			},
			unhighlight : function(element,
				errorClass, validClass) {
				 if ($(element).parent().hasClass(
						'has-error')) {
					$(element).parent().addClass(
						"has-success")
						.removeClass(
							"has-error");
					$(element).next('.FeRror').css(
						'display', 'none');
				} 
			},
			submitHandler : function(form) {
			
				var jsonData = JSON.stringify($("#minForm")).serializeJSON();
				console.log("jsonData vic:::  " + jsonData);
				$
					.ajax({
						type : 'POST', // define
						url : 'saveMinistry', // the
						data : jsonData,
						async : false,
						dataType : 'json', // what
						/* encode : true,
						beforeSend : function(xhr) {
							xhr.setRequestHeader("Accept",
								"application/json");
							xhr.setRequestHeader("Content-Type",
								"application/json");
							xhr.setRequestHeader('X-CSRF-Token', $(
								'#secureToken').val());
						}, */
						success : function(data, textStatus, jqXHR) {

/* 
				var id=$("#ministryId").val();
				var desc=$("#ministryName").val();
				alert(id+ desc);
				$.ajax({
					url:"saveMinistry",
					data :{"desc":desc,"id":id},
					type:"post",
					success:function(data){ */

						if(data=="success"){
							showdialog(
									"Ministry created successfully.",
									"alert-success",
									"alert-danger",
									"alert-info");
						} if(data=="fail"){
						showdialog(
								"User creation not done successfully ",
								"alert-danger",
								"alert-success",
								"alert-info");
						}
						//createTable();
					},error:function(e){
						
					}
					

			});
				
			}
		});
	
});
function showdialog(msg, addclass, removeclass1, removeclass2) {
	$("#messg").addClass(addclass);
	$("#messg").removeClass(removeclass1);
	$("#messg").removeClass(removeclass2);
	$(".alert-Msg").empty();
	$(".alert-Msg").append(msg);

	$("#dialogcModal").modal("show");

}
function createTable(){
	
	$('#ministryTable').DataTable({

		/* dom: 'Bfrtip',
        buttons: [
            {
                extend: 'pdfHtml5',
                orientation: 'portrait',
                pageSize: 'LEGAL',
                messageTop: 'Total active Ministry List.',
                title: 'Ministry'
            }
        ], */
        "ajax" : {
			"url" : "getMinistrylist",
		},
		"destroy" : true,
		"columns" : [ {
			"data" : "ministryId"
		}, {
			"data" : "ministryName"
		},  {
			"data" : "enteredon"
		}, ]

	});

}
</script>
<div class="content-wrapper" style="min-height: 990px;">
    
    

    <!-- Main content -->
    <section class="content">
      <div class="row">
			<div class="col-md-8 col-md-offset-2" >
				<div class="userCreation">
				<div class="panel panel-primary">
				
				<div class="panel-heading"><h3 class="panel-title">Register</h3></div>
					<div class="panel-body">
						<form:form  modelAttribute="ministry" method="POST" id="minForm" >
						
						<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Ministry name:</label>
						    <form:input class="proInput form-control" path="ministryName"
						    id="ministryName" required="required" />
						     <form:hidden class="proInput form-control" path="ministryId" id="ministryId" required="required" />
						    <form:errors cssStyle="color:red;"  path="ministryName"  ></form:errors>
						  </div>
						 </div>  
						 
						 <div class="col-md-6">
						  <div class="form-group">
						   						     
				         <input type="button" id="userSubmit" value="Save"  class="btn btn-primary" >
				    		  </div>
						 </div> 
						</div>
						</form:form>
						
						</div>
						</div>
						
				</div>		
</div>
</div>
  <div class="panel panel-default" style="margin-top:40px;">
                  <div class="panel-heading">Ministry List.</div>
                   <div class="panel-body">
                   <div class="table-responsive">
                    <table id="ministryTable" class="table table-striped table-bordered" width="100%">
                    <thead>
                      <tr>
                      <th colspan="10"></th>
                      </tr>
                      <tr>
                      <th>Ministry Id</th>
                      <th>Ministry Name</th>
                      <th>Entered on</th>
                      
                      </tr>
                     </thead>
                    </table>
                    </div>
                   
                  </div>
                 </div>
                 
                 <div class="modal fade" id="dialogcModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
	               <div class="modal-dialog">
		            <div class="modal-content">

			         <div class="modal-body" style="padding: 0;">
			     	  <div id="messg" class="alert alert-success alert-info alert-danger alert-dismissible"	style="margin-bottom: 0;">
					    <a href="#" class="close" data-dismiss="modal" aria-label="close">&times;</a>
					  <div class="alert-Msg">
						<strong>Success!</strong> Indicates a successful or positive
						action.
					</div>
				 </div>
			   </div>

		     </div>
	      </div>
        </div>
			  
			  
              
</section>
</div>
