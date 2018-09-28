<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value='/resources/js/urlMapper.js'/>"></script>
<div class="content-wrapper" style="min-height: 960px;">
	<section class="content">

		<!-- Info boxes -->
		
<script type="text/javascript">

	function showRoleTable(){

		var roleid=$("#roleid").val();
		$.ajax({
			
		
			url:"getUrlByRole",
			data :{"id":roleid},
			type:"post",
			success:function(data){

				var html = '';
				
			
				var len = data.length;
			if(len>0){
				for (var i = 0; i < len; i++) {
					 
					html += "<tr><td>"+data[i].urlId+"</td><td>"+data[i].urlDesc+"</td>" +
							"<td>";
							for(var j=0;j<data[i].subList.length;j++){
								if(data[i].subList.length==0){
									html+="NA";
								}else{
								html+=data[i].subList[j].subUrlDesc+"<br>";
								}
							}
							
							html+="</td><td><button><i class='fa fa-trash btn'></i></button></td></tr>";
							}
			
				$('#ctbody').html("");
				$('#ctbody').html(html); 
				$('#urlroletable').show();
			}else{
				$('#urlroletable').hide();
			}
			},error:function(e){
				
			}
			

	});
		
}


</script>

			<form action="#" method="get">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<div class="col-md-5">

							<label for="sel1" class="proLabel">Employee Role:</label> 
							<select onchange="showRoleTable();"	class="proInput form-control" id="roleid">
								<option value=""  >--Select Role --</option>
								<c:forEach items="${allroles}" var="x">
									<option value="${x.roleId}" >${x.roleDesc}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>

				<div class="col-md-12">
					<div class="form-group">
						<div class="col-md-5">

							<label for="sel1" class="proLabel">URL:</label>
							 <select onchange="showURLTable();"
								class="form-control proInput" id="urlid">
								<option value=""  >--Select url --</option>
								<c:forEach items="${allurl}" var="x">
									<option value="${x.urlId}" >${x.urlDesc}</option>
								</c:forEach>
							</select>
						</div>


						<div class="col-md-7" id="urltableDiv" style="display: none;">
							<div class="table-responsive">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>#</th>
											<th>SUB URL</th>
											<th>SUB URL Description</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody id="urltable">
									
									</tbody>
									<tbody>
										
								</table>
							</div>

						</div>
					</div>

				</div>
								
</div>
			<div class="col-md-10 col-md-offset-1" id="urlroletable" style="display: none;">	
				<div class="panel panel-primary">

				<div class="panel-heading">
				
					<div class="panel-title">Designation list</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">
				
					<table id="designationTable"
						class="table table-bordered table-responsive">
						
						<thead>
						
							<tr>
								<th>Role</th>
								<th>URL</th>
								<th>SUB URL</th>
								<th>Action</th>

							</tr>
						</thead>
						<!-- loop over and print our employees -->
						<tbody id="ctbody">
						
						</tbody>

					</table>
					
				</div>
				</div>
			</div>
</form>
			
	</section>
</div>

