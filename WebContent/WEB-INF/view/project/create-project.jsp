 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <head>
<title>Create Project</title>

</head>
 <body>
 <div class="content-wrapper" style="min-height: 990px;">
    
    <!-- Main content -->
    <section class="content">
 <div class="row">
			<div class="col-md-8 col-md-offset-2" >
				<div class="userCreation">
				<div class="panel panel-primary">
				
				<div class="panel-heading"><h3 class="panel-title">Register</h3></div>
					<div class="panel-body">
						<form:form  modelAttribute="project" method="POST" id="projectForm" 
								action="createProject">
						
						<div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Project name:</label>
						    <form:input class="proInput form-control" path="projectName" />
						     <div class="FeRror"></div>
						    <form:errors cssStyle="color:red;"  path="projectName"  ></form:errors>
						  </div>
						 </div>  
						 
						 	  <div class="col-md-6">
						  <div class="form-group">
						    <label class="proLabel">Priority:</label>
					    <form:select class="proInput form-control" path="priority" id="priorityDesc_id" >
										<form:option value="" label="--Select priority --" />
										<div class="FeRror"></div>
										<form:options items="${allpriority}" itemValue="priorityId" itemLabel="priorityDesc" />
										<form:errors cssStyle="color:red;"  path="priority"  ></form:errors>
								</form:select>	
						  </div>
						 </div>  
						 
						 <div class="form-inline">
						 <div class="col-md-6">
						  <div class="form-group">
						   <label class="proLabel">Project Type:</label>
					    <form:select class="proInput form-control" path="projectType"  >
										<form:option value="" label="--Select projectType --" />
										<div class="FeRror"></div>
										<form:options items="${allprojectType}" itemValue="projectTypeId" itemLabel="projectTypeDesc" />
										<form:errors cssStyle="color:red;"  path="projectType"  ></form:errors>
								</form:select>	
						  </div>
						 </div>  
						 
						 	  <div class="col-md-6">
						  <div class="form-group">
						     <label class="proLabel">Project Description:</label>
						    <form:textarea class="proInput form-control" path="projectDesc"  />
						    <div class="FeRror"></div>
						    <form:errors cssStyle="color:red;"  path="projectDesc"  ></form:errors>
						  </div>
						 </div>  
						</div>
						</form:form>
						</div>
				</div>
			</div>
		</div>
	</div>
						
</section>
</div>
</body>