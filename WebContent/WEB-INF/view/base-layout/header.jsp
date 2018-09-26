 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
     <script src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script> 
    <script src="<c:url value='/resources/js/bootstrap.js'/>"></script>
 
 
<!-- include js -->
		  <script src="<c:url value='/resources/js/adminlte.min.js'/>"></script>
				<script src="<c:url value='/resources/js/demo.js'/>"></script> 
</head>

<body class="hold-transition skin-blue sidebar-mini">
<header class="main-header">
    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>WET</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg">Web<b>Employee</b>Tracker</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <li class="dropdown user user-menu">
            <a href="logout" class="dropdown-toggle" >
           
              <span class="hidden-xs">Logout</span>
            </a>
          </li>
          <!-- Control Sidebar Toggle Button -->
          
        </ul>
      </div>
    </nav>
  </header>