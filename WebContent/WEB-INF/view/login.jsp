<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/resources/css/AdminLTE.css'/>">
   <link rel="stylesheet" href="<c:url value='/resources/css/skins/_all-skins.css'/>">
   <link rel="stylesheet" href="<c:url value='/resources/css/alt/bootstrap.min.css'/>">    
   <link rel="stylesheet" href="<c:url value='/resources/css/alt/AdminLTE-select2.css'/>"> 
   <link rel="stylesheet" href="<c:url value='/resources/css/font-awesome.min.css'/>"> 
   <link rel="stylesheet" href="<c:url value='/resources/css/ionicons.css'/>"> 
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
     
  <!--
   <link rel="stylesheet" href="https://adminlte.io/themes/AdminLTE/dist/css/AdminLTE.min.css" /> 
   -->
    <script src="<c:url value='/resources/js/bootstrap.js'/>"></script>
  <script src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script>  

<!-- include js -->
		  <script src="<c:url value='/resources/js/adminlte.min.js'/>"></script>
				<script src="<c:url value='/resources/js/demo.js'/>"></script> 
	<title>Web Employee Tracker</title>
<script src="<c:url value='/resources/js/jquery-validation-1.15.1/dist/jquery.validate.js'/>"></script>
<script src="<c:url value='/resources/js/jquery-validation-1.15.1/dist/additional-methods.js'/>"></script>
<script src="<c:url value='resources/js/loginValidation.js'/>"></script>
 <script src="<c:url value='/resources/js/hashes.min.js'/>"></script>
<style>
.skin-blue .main-header .logo{float: left; width: 100%; text-decoration: none; text-align: center; }
</style>
</head>
<body>		
	

<header class="main-header">
    <a href="#" class="logo">
      <span class="logo-lg">Web<b>Employee</b>Tracker</span>
    </a>
  </header>


<div class="container">
<div class="col-md-6 col-md-offset-3">
  <div class="login_page">
  
<div class="panel panel-success"> 
<div class="panel-heading">
 <div class="panel-title"><h3>Sign in</h3></div>
</div> 
  <div class="panel-body">


	<form:form id="loginForm" action="checkUser" method="post" modelAttribute="formUser" >
	
	<div class="form-group">
	  <label class="proLabel">User name:</label>
	  <form:input type="text" label="Enter Email ID" path="emailId" class="form-control proInput" />
	</div>
	
	<div class="form-group">
	  <label class="proLabel">Password:</label>
	  <form:input type="password" path="userPassword" class="form-control proInput" id="userPwd" />
	</div>
	
		<div class="form-group text-center">
								<img src="captchaimg" alt="captcha" id="captcha_id" /> <i
									class="fa fa-lg fa-refresh" onclick='refresh_captcha()'
									style='cursor: pointer; padding-top: 10px; vertical-align: middle;'
									style="vertical-align: middle;"></i>
							</div>

							<div class="form-group" style="margin-bottom: 0px">
								<form:input path="captcha" cssClass="form-control"
									placeholder="Enter Text Shown Above" htmlEscape="true"
									maxlength="6" id="captcha" autocomplete="off" />
									 <form:errors path="captcha" />
							</div>
	
	<div class="pull-left">
	  <button  id="submit" class="btn btn-primary" style="margin-top: 10px;">Login</button>
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
		
<%-- 		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 --%>		
		</form:form>
		<input type="hidden" value="${randSalt}" id="randSalt">
		</div>
</div>		
  </div>
</div>
</div>

</body>

</html>