<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value='/resources/js/urlMapper.js'/>"></script>
<div class="content-wrapper" style="min-height: 960px;">
	<section class="content">

		<!-- Info boxes -->
		<div class="row">
<script type="text/javascript">

</script>

			<form action="#" method="get">
				<div class="col-md-12">
					<div class="form-group">
						<div class="col-md-5">

							<label for="sel1" class="proLabel">Employee Role:</label> 
							<select	class="proInput form-control" >
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
											<th>URL</th>
											<th>URL Description</th>
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

			</form>


		</div>


	</section>
</div>

