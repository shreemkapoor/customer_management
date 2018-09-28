<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<title>Professional Details</title>
<link rel="stylesheet" href="<c:url value='/resources/css/dataTables.bootstrap.min.css'/>"> 
 </head>
 <body>
 <script src="<c:url value='/resources/js/jquery-validation-1.15.1/dist/jquery.validate.js'/>"></script>
  <script src="<c:url value='/resources/js/jquery-validation-1.15.1/dist/additional-methods.js'/>"></script>
  <script src="<c:url value='/resources/js/bootstrap-datepicker.min.js'/>"></script>
 
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
	  
	  
	  
	  $("#detailform")
		.validate(
			{
				rules : {
					
								},
				messages : {
					
					
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
alert("svcsh");
					  var comp = $("input[name='companyName[]']")
					     .map(function(){return $(this).val();}).get();
					  var des = $("input[name='designation[]']")
					     .map(function(){return $(this).val();}).get();
					  var sd1 = $("input[name='startDate[]']")
					     .map(function(){return $(this).val();}).get();
					  var ed1 = $("input[name='endDate[]']")
					     .map(function(){return $(this).val();}).get();
					  var exp = $("input[name='experienceSummary[]']")
					     .map(function(){return $(this).val();}).get();
					  var cur = $("input[name='course[]']")
					     .map(function(){return $(this).val();}).get();
					  var edu = $("input[name='education[]']")
					     .map(function(){return $(this).val();}).get();
					  var uni = $("input[name='university[]']")
					     .map(function(){return $(this).val();}).get();
					  var ed2 = $("input[name='ENDDATE[]']")
					     .map(function(){return $(this).val();}).get();
					  var sd2 = $("input[name='STARTDATE[]']")
					     .map(function(){return $(this).val();}).get();
					  var per = $("input[name='percentage[]']")
					     .map(function(){return $(this).val();}).get();
					  alert(comp);
					  alert(comp.length);
					  var reportobj = {
								"company" : comp.toString(),
								"designation" : des.toString(),
								"sd1" : sd1.toString(),
								"ed1" : ed1.toString(),
								"exp" : exp.toString(),
								"cur" : cur.toString(),
								"edu" : edu.toString(),
								"uni" : uni.toString(),
								"ed2" : ed2.toString(),
								"sd2" : sd2.toString(),
								"per":per.toString(),
							
							};
					
					 $.ajax({
				         async: false,
				         url: "professionalDetails1",
				         method: "POST",
				         data: reportobj,
				         success:function(rt)
				         {
				             alert(rt);
				             $('#detailform')[0].reset();
				         }
				     });
				}
			});

		    $(".addCF").click(function(){
		    	$("#expTable").append('<tr><td><input type="text" name="companyName[]" class="proInput1 form-control"/></td><td><input type="text" name="designation[]" class="proInput1 form-control"/></td><td><input type="text" name="startDate[]" class="proInput1 form-control"/></td><td><input type="text" name="endDate[]" class="proInput1 form-control"/></td><td><input type="text" name="experienceSummary[]" class="proInput1 form-control"/></td><td><button class="btn remCF"  ><i class="fa fa-trash"></i></button></td></tr>');
		    	});
		    $("#expTable").on('click','.remCF',function(){
		        $(this).parent().parent().remove();
		  });
		    
		    $("#endDate1").datepicker({
		    	autoclose: true
		    });
		    $("#endDate2").datepicker({
		    	autoclose: true
		    });
		    $("#endDate3").datepicker({
		    	autoclose: true
		    });
		    $("#endDate4").datepicker({
		    	autoclose: true
		    });
  
  })  
 	 
function show(){
	
  }
  
  
  </script>
  	
  
  <div class="content-wrapper" style="min-height: 990px;">
    
    <!-- Main content -->
    <section class="content">
      <div class="row">
			<div class="col-md-10 col-md-offset-1" >
				<div class="userCreation">
				<div class="panel panel-primary">
				
				<div class="panel-heading"><h3 class="panel-title">Professional Details</h3></div>
					<div class="panel-body">
						<form   method="POST" id="detailform" 				 action="">
						<div class="heading1"><h3>Experience Detail</h3></div>
						
						<table class="table">
						<thead>
						<tr><th>Company Name:</th>
						<th>Designation:</th>
						<th>Start Date: </th>
						<th>End Date:</th>
						<th>Experience Summary:</th>
						</tr>
						</thead>
						<tbody id="expTable">
						<tr>
						<td><input type="text" name="companyName[]" class="proInput1 form-control"/></td>
						<td><input type="text" name="designation[]" class="proInput1 form-control"/></td>
						<td><input type="text" name="startDate[]" class="proInput1 form-control"/></td>
						<td><input type="text" name="endDate[]" class="proInput1 form-control"/></td>
						<td><input type="text" name="experienceSummary[]" class="proInput1 form-control"/></td>
						<td><button class="btn remCF"  ><i class="fa fa-trash"></i></button></td>
						</tr>
						</tbody>
						
						 
						</table>
						<div class="text-left">
				         <input type="button"    value="ADD MORE+"  class="addCF btn btn-primary addmore" >
				        </div>
				        <div class="heading1"><h3>Education Detail</h3></div>
				        
				         <div class="heading2"><h2>10th</h2></div>
				         
					<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Course:</label>
						    <input class="proInput form-control" name="course[]" />
						    
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						 <input type="hidden" name="education[]" value="10"/>
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Board:</label>
						    <input class="proInput form-control" name="university[]" />
						    <div class="FeRror"></div>
						   
						  </div>
						 </div> 
						</div>
						
							<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">End Date:</label>
						    <input id="endDate1" class="proInput form-control" name="ENDDATE[]" />
						    <div class="FeRror"></div>
						  	    <input type="hidden"  class="proInput form-control"value=" " name="STARTDATE[]" />
						  </div>
						 </div>
						 </div> 
						 	<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Percentage:</label>
						    <input class="proInput form-control" name="percentage[]" />
						  
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						</div>
						
						    <div class="heading2"><h2>12th/Diploma</h2></div>
					<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Course:</label>
						    <input class="proInput form-control" name="course[]" />
						 
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						 <input type="hidden" name="education[]" value="12"/>
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Board/Unversity:</label>
						    <input class="proInput form-control" name="university[]" />
						    <div class="FeRror"></div>
						  
						  </div>
						 </div> 
						</div>
						
							<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">End Date:</label>
					
						    <input class="proInput form-control" id="endDate2" name="ENDDATE[]" />
						    <div class="FeRror"></div>
						   
						  </div>
						 </div>
						 </div> 
						 	<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Percentage:</label>
						    <input class="proInput form-control" name="percentage[]" />
						  <input type="hidden"  class="proInput form-control" value=" " name="STARTDATE[]" />
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						</div>
						
						    <div class="heading2"><h2>Graduation</h2></div>
					<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Course:</label>
						    <input class="proInput form-control" name="course[]" />
						  
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						 <input type="hidden" name="education[]" value="graduation"/>
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">University:</label>
						    <input class="proInput form-control" name="university[]" />
						    <div class="FeRror"></div>
						   
						  </div>
						 </div> 
						</div>
						
							<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Start Date:</label>
						    <input id="endDate3" class="proInput form-control" name="STARTDATE[]" />
				
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						 
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">End Date:</label>
						    <input id="endDate4" class="proInput form-control" name="ENDDATE[]" />
						    <div class="FeRror"></div>
						    
						  </div>
						 </div>
						 </div> 
						 	<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Percentage:</label>
						    <input class="proInput form-control" name="percentage[]" />
						    
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						</div>
						
						 <div class="text-center">
				         <button id="userSubmit"   class="btn btn-primary" >Save</button>
				        </div>
						</form>
						</div></div></div></div></div></section></div>
 </body>