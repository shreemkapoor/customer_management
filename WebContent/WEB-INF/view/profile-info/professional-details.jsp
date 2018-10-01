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
	  
	  let addvalue=1;
	  
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


if(addvalue>=0){
							reorder_recovery(addvalue);	
}
form.submit();
				}
			});

		    $(".addCF").click(function(){
		    	    	
		    	$("#expTable").append('<tr><td><input type="text" name="proList['+addvalue+'].companyName" class="proInput1 form-control"/></td><td><input type="text" name="proList['+addvalue+'].designation" class="proInput1 form-control"/></td><td><input type="text" name="proList['+addvalue+'].STARTDATE" class="proInput1 form-control"/></td><td><input type="text" name="proList['+addvalue+'].ENDDATE" class="proInput1 form-control"/></td><td><input type="text" name="proList['+addvalue+'].experienceSummary" class="proInput1 form-control"/></td><td><button class="btn remCF"  id="dele'+addvalue+'" ><i class="fa fa-trash"></i></button></td></tr>');
		    	addvalue++;	
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
 	 

function reorder_recovery(k){
	
	var arr=new Array();		
	var n=0;
	for(var i=0;i<k;i++){
		
		if($('[name="proList['+i+'].companyName"]').val()!=undefined){
			arr.push(i);
			n++;
		}
	}
	//alert("values are "+JSON.stringify(arr));	

	for(var j=0;j<n;j++){
		i=arr[j];
		
	$('[name="proList['+i+'].companyName"]').attr('name',"proList["+j+"].companyName");
		$('[name="proList['+i+'].designation"]').attr('name',"proList["+j+"].designation");
		$('[name="proList['+i+'].STARTDATE"]').attr('name',"proList["+j+"].STARTDATE");
		$('[name="proList['+i+'].ENDDATE"]').attr('name',"proList["+j+"].ENDDATE");
		$('[name="proList['+i+'].experienceSummary"]').attr('name',"proList["+j+"].experienceSummary");

	}
	
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
						<form:form  modelAttribute="profDetails"  method="POST" id="detailform"  action="professionalDetails1">
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
						<td><input type="text" name="proList[0].companyName" class="proInput1 form-control"/></td>
						<td><input type="text" name="proList[0].designation" class="proInput1 form-control"/></td>
						<td><input type="text" name="proList[0].STARTDATE" class="proInput1 form-control"/></td>
						<td><input type="text" name="proList[0].ENDDATE" class="proInput1 form-control"/></td>
						<td><input type="text" name="proList[0].experienceSummary" class="proInput1 form-control"/></td>
						<td></td>
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
						    <input class="proInput form-control" name="eduList[0].course" />
						    
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						 <input type="hidden" name="eduList[0].education" value="10"/>
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Board:</label>
						    <input class="proInput form-control" name="eduList[0].university" />
						    <div class="FeRror"></div>
						   
						  </div>
						 </div> 
						</div>
						
							<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">End Date:</label>
						    <input id="endDate1" class="proInput form-control" name="eduList[0].ENDDATE" />
						    <div class="FeRror"></div>
						  	    <input type="hidden"  class="proInput form-control"value=" " name="eduList[0].STARTDATE" />
						  </div>
						 </div>
						 </div> 
						 	<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Percentage:</label>
						    <input class="proInput form-control" name="eduList[0].percentage" />
						  
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						</div>
						
						    <div class="heading2"><h2>12th/Diploma</h2></div>
					<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Course:</label>
						    <input class="proInput form-control" name="eduList[1].course" />
						 
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						 <input type="hidden" name="eduList[1].education" value="12"/>
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Board/Unversity:</label>
						    <input class="proInput form-control" name="eduList[1].university" />
						    <div class="FeRror"></div>
						  
						  </div>
						 </div> 
						</div>
						
							<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">End Date:</label>
					
						    <input class="proInput form-control" id="endDate2" name="eduList[1].ENDDATE" />
						    <div class="FeRror"></div>
						   
						  </div>
						 </div>
						 </div> 
						 	<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Percentage:</label>
						    <input class="proInput form-control" name="eduList[1].percentage" />
						  <input type="hidden"  class="proInput form-control" value=" " name="eduList[1].STARTDATE" />
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						</div>
						
						    <div class="heading2"><h2>Graduation</h2></div>
					<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Course:</label>
						    <input class="proInput form-control" name="eduList[2].course" />
						  
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						 <input type="hidden" name="eduList[2].education" value="graduation"/>
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">University:</label>
						    <input class="proInput form-control" name="eduList[2].university" />
						    <div class="FeRror"></div>
						   
						  </div>
						 </div> 
						</div>
						
							<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Start Date:</label>
						    <input id="endDate3" class="proInput form-control" name="eduList[2].STARTDATE" />
				
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						 
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">End Date:</label>
						    <input id="endDate4" class="proInput form-control" name="eduList[2].ENDDATE" />
						    <div class="FeRror"></div>
						    
						  </div>
						 </div>
						 </div> 
						 	<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Percentage:</label>
						    <input class="proInput form-control" name="eduList[2].percentage" />
						    
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						</div>
						
						 <div class="text-center">
				         <button id="userSubmit"   class="btn btn-primary" >Save</button>
				        </div>
						</form:form>
						</div></div></div></div></div></section></div>
 </body>