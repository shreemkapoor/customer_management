<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv='cache-control' content='no-cache'>
<meta http-equiv='expires' content='0'>
<meta http-equiv='pragma' content='no-cache'>

<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
 <!--  <link rel="stylesheet" href="WebContent/resources/css/AdminLTE.min.css" /> -->

  <link rel="stylesheet" href="<c:url value='/resources/css/AdminLTE.css'/>">
   <link rel="stylesheet" href="<c:url value='/resources/css/skins/_all-skins.css'/>">
   <link rel="stylesheet" href="<c:url value='/resources/css/alt/bootstrap.min.css'/>">    
   <link rel="stylesheet" href="<c:url value='/resources/css/alt/AdminLTE-select2.css'/>"> 
   <link rel="stylesheet" href="<c:url value='/resources/css/font-awesome.min.css'/>"> 
   <link rel="stylesheet" href="<c:url value='/resources/css/ionicons.css'/>"> 
  <!--
   <link rel="stylesheet" href="https://adminlte.io/themes/AdminLTE/dist/css/AdminLTE.min.css" /> 
   -->
    <script src="<c:url value='/resources/js/bootstrap.js'/>"></script>
  <script src="<c:url value='/resources/js/jquery-3.3.1.min.js'/>"></script>  
 
<!-- include js -->
		 <script src="https://adminlte.io/themes/AdminLTE/bower_components/jquery/dist/jquery.min.js"></script>
		<script src="https://adminlte.io/themes/AdminLTE/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<script src="https://adminlte.io/themes/AdminLTE/dist/js/pages/dashboard2.js"></script>
				 <script src="<c:url value='/resources/js/adminlte.min.js'/>"></script>
				<script src="<c:url value='/resources/js/demo.js'/>"></script> 
</head>
<body>
<div class="bodyContent">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="sideLayout" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/core.js"></script>
 -->  
<!-- <script src="bower_components/jquery/dist/jquery.min.js"></script>
jQuery UI 1.11.4
<script src="bower_components/jquery-ui/jquery-ui.min.js"></script>
Resolve conflict in jQuery UI tooltip with Bootstrap tooltip
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
Bootstrap 3.3.7
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
Morris.js charts
<script src="bower_components/raphael/raphael.min.js"></script>
<script src="bower_components/morris.js/morris.min.js"></script>
Sparkline
<script src="bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
jvectormap
<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
jQuery Knob Chart
<script src="bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
daterangepicker
<script src="bower_components/moment/min/moment.min.js"></script>
<script src="bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
datepicker
<script src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
Bootstrap WYSIHTML5
<script src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
Slimscroll
<script src="bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
FastClick
<script src="bower_components/fastclick/lib/fastclick.js"></script>
AdminLTE App
<script src="dist/js/adminlte.min.js"></script>
AdminLTE dashboard demo (This is only for demo purposes)
<script src="dist/js/pages/dashboard.js"></script>
AdminLTE for demo purposes
<script src="dist/js/demo.js"></script> -->

</body>
</html>