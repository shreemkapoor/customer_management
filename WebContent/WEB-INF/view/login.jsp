<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<head>
	<title>Web Employee Tracker</title>
<script src="<c:url value='/resources/js/jquery-validation-1.15.1/dist/jquery.validate.js'/>"></script>
<script src="<c:url value='/resources/js/jquery-validation-1.15.1/dist/additional-methods.js'/>"></script>
<script src="<c:url value='resources/js/loginValidation.js'/>"></script>
<style>
.skin-blue .main-header .logo{float: left; width: 100%; text-decoration: none;}
</style>
<body>		
	</head>


<%@include file="header.jsp"%> 


<div class="container">
<div class="col-md-6 col-md-offset-3">
  <div class="login_page">
  
<div class="panel panel-success"> 
<div class="panel-heading">
 <div class="panel-title"><h3>Sign in</h3></div>
</div> 
  <div class="panel-body">


	<form:form id="loginForm" action="checkUser"  modelAttribute="formUser" >
	
	<div class="form-group">
	  <label class="proLabel">User name:</label>
	  <form:input type="text" label="Enter Email ID" path="emailId" class="form-control proInput" />
	</div>
	
	<div class="form-group">
	  <label class="proLabel">Password:</label>
	  <form:input type="password" path="userPassword" class="form-control proInput" />
	</div>
	
	<div class="pull-left">
	  <button  id="submit" class="btn btn-primary">Login</button>
	</div>
	
	<%-- <div class="pull-right">
	  <a href="${pageContext.request.contextPath}/registerNewForm">New User ? Register now</a>
	</div> --%>
  
<%-- <p>

			User name: <form:input type="text" path="userName" />
			<form:errors cssStyle="color: red;" path="userName"></form:errors>
		</p>
		<p>
	
		Password:  <form:input type="password" path="userPassword" />
		<form:errors cssStyle="color: red;"  path="userPassword"></form:errors>
	
	</p>
		
		<button  id="submit">Login</button>
		<br><br>
		<a href="${pageContext.request.contextPath}/registerNewForm">New User ? Register now</a> --%>
		</form:form>
		</div>
</div>		
  </div>
</div>
</div>

</body>

</html>