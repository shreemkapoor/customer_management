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
  $( document ).ready(function() {
	  
	 

		    $(".addCF").click(function(){
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
/* 	 
		  var i=1;
		  $(document).on("click","#moreDetail2",
		      		 function() {
			  i++;
			  var html=$("#eduTable").html();
			  html+='<tr><td><input type="text" id="eduList'+i+'" class="proInput1 form-control"></td><td><input type="text" id="course'+i+'" class="proInput1 form-control"></td><td><input type="text" id="university'+i+'" class="proInput1 form-control"></td><td><input type="text" id="startDate'+i+'" class="proInput1 form-control"></td><td><input type="text" id="endDate'+i+'" class="proInput1 form-control"></td><td><input type="text" id="percentage'+i+'" class="proInput1 form-control"></td></tr>';		
			  $("#eduTable").html("");
			  $("#eduTable").html(html);
			  
		  });
  }) */
  
  
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
						<form:form  modelAttribute="profDetails" method="POST" id="detailform" 
								 action="professionalDetails1">
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
						<td><form:input type="text" path="proList[0].companyName" class="proInput1 form-control"/></td>
						<td><form:input type="text" path="proList[0].designation" class="proInput1 form-control"/></td>
						<td><form:input type="text" path="proList[0].startDate" class="proInput1 form-control"/></td>
						<td><form:input type="text" path="proList[0].endDate" class="proInput1 form-control"/></td>
						<td><form:input type="text" path="proList[0].experienceSummary" class="proInput1 form-control"/></td>
						<td><button class="btn remCF"  ><i class="fa fa-trash"></i></button></td>
						</tr>
						</tbody>
						
						 
						</table>
						<div class="text-left">
				         <input type="button"   value="ADD MORE+"  class="addCF btn btn-primary addmore" >
				        </div>
				        
				          
				    <!--    <table class="table">
						<thead>
						<tr><th>Education:</th>
						<th>Course:</th>
						<th>Board/University:</th>
						<th>Start Date: </th>
						<th>End Date:</th>
						<th>% scored:</th>
						
						</tr>
						</thead>
						<tbody id="eduTable">
						<tr>
						
						<td><input type="text" id="education1" class="proInput1 form-control"></td>
						<td><input type="text" id="course1" class="proInput1 form-control"></td>
						<td><input type="text" id="university1" class="proInput1 form-control"></td>
						<td><input type="text" id="startDate1" class="proInput1 form-control"></td>
						<td><input type="text" id="endDate1" class="proInput1 form-control"></td>
						<td><input type="text" id="percentage1" class="proInput1 form-control"></td>
						</tr>
						</tbody>
					</table>
					
						<div class="text-left">
				         <input type="button" id="moreDetail2" value="ADD MORE+"  class="btn btn-primary addmore" >
				        </div> -->
				        
				        <div class="heading1"><h3>Education Detail</h3></div>
				        
				         <div class="heading2"><h2>10th</h2></div>
				         
					<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Course:</label>
						    <form:input class="proInput form-control" path="eduList[0].course" />
						    <form:errors cssStyle="color:red;"  path="eduList[0].course"  ></form:errors>
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						 <form:input type="hidden" path="eduList[0].education" value="10"/>
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Board:</label>
						    <form:input class="proInput form-control" path="eduList[0].university" />
						    <div class="FeRror"></div>
						    <form:errors cssStyle="color:red;"  path="eduList[0].university"  ></form:errors>
						  </div>
						 </div> 
						</div>
						
							<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">End Date:</label>
						    <form:input id="endDate1" class="proInput form-control" path="eduList[0].ENDDATE" />
						    <div class="FeRror"></div>
						    <form:errors cssStyle="color:red;"  path="eduList[0].ENDDATE"  ></form:errors>
						  </div>
						 </div>
						 </div> 
						 	<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Percentage:</label>
						    <form:input class="proInput form-control" path="eduList[0].percentage" />
						    <form:errors cssStyle="color:red;"  path="eduList[0].percentage"  ></form:errors>
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						</div>
						
						    <div class="heading2"><h2>12th/Diploma</h2></div>
					<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Course:</label>
						    <form:input class="proInput form-control" path="eduList[1].course" />
						    <form:errors cssStyle="color:red;"  path="eduList[1].course"  ></form:errors>
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						 <form:input type="hidden" path="eduList[1].education" value="12"/>
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Board/Unversity:</label>
						    <form:input class="proInput form-control" path="eduList[1].university" />
						    <div class="FeRror"></div>
						    <form:errors cssStyle="color:red;"  path="eduList[1].university"  ></form:errors>
						  </div>
						 </div> 
						</div>
						
							<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">End Date:</label>
						    <form:input class="proInput form-control" id="endDate2" path="eduList[1].ENDDATE" />
						    <div class="FeRror"></div>
						    <form:errors cssStyle="color:red;"  path="eduList[1].ENDDATE"  ></form:errors>
						  </div>
						 </div>
						 </div> 
						 	<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Percentage:</label>
						    <form:input class="proInput form-control" path="eduList[1].percentage" />
						    <form:errors cssStyle="color:red;"  path="eduList[1].percentage"  ></form:errors>
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						</div>
						
						    <div class="heading2"><h2>Graduation</h2></div>
					<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Course:</label>
						    <form:input class="proInput form-control" path="eduList[2].course" />
						    <form:errors cssStyle="color:red;"  path="eduList[2].course"  ></form:errors>
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						 <form:input type="hidden" path="eduList[2].education" value="graduation"/>
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">University:</label>
						    <form:input class="proInput form-control" path="eduList[2].university" />
						    <div class="FeRror"></div>
						    <form:errors cssStyle="color:red;"  path="eduList[2].university"  ></form:errors>
						  </div>
						 </div> 
						</div>
						
							<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Start Date:</label>
						    <form:input id="endDate3" class="proInput form-control" path="eduList[2].STARTDATE" />
						    <form:errors cssStyle="color:red;"  path="eduList[2].STARTDATE"  ></form:errors>
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						 
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">End Date:</label>
						    <form:input id="endDate4" class="proInput form-control" path="eduList[2].ENDDATE" />
						    <div class="FeRror"></div>
						    <form:errors cssStyle="color:red;"  path="eduList[2].ENDDATE"  ></form:errors>
						  </div>
						 </div>
						 </div> 
						 	<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Percentage:</label>
						    <form:input class="proInput form-control" path="eduList[2].percentage" />
						    <form:errors cssStyle="color:red;"  path="eduList[2].percentage"  ></form:errors>
						    <div class="FeRror"></div>
						  </div>
						 </div>  
						</div>
						
						 <div class="text-center">
				         <input type="submit" id="userSubmit" value="Save"  class="btn btn-primary" >
				        </div>
						</form:form>
						</div></div></div></div></div></section></div>
 </body>