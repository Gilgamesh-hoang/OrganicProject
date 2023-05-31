<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title><dec:title default="Trang chủ" /></title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8" />
	<meta name="description" content="" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
	<!-- bootstrap & fontawesome -->
	<link rel="stylesheet" href='<c:url value="/assets/css/bootstrap.min.css"/>' />
	<link rel="stylesheet" href='<c:url value="/assets/font-awesome/4.2.0/css/font-awesome.min.css"/>'/>
	<!-- text fonts -->
	<link rel="stylesheet" href='<c:url value="/assets/fonts/fonts.googleapis.com.css"/>' />
	<!-- ace styles -->
	<link rel="stylesheet" href='<c:url value="/assets/css/ace.min.css"/>' class="ace-main-stylesheet" id="main-ace-style" />
	<!-- ace settings handler -->
	<script src='<c:url value="/assets/js/ace-extra.min.js"/>'></script>
    <script src='<c:url value="/assets/js/jquery.2.1.1.min.js"/>'></script>
    <script src='<c:url value="/sweetalert/sweetalert.min.js"/>'></script>
    <script src='<c:url value="/ckeditor/ckeditor.js"/>'></script>
    
	
    
</head>
<body class="no-skin">
	<!-- header -->
    <%@ include file="/common/admin/header.jsp" %>
    <!-- header -->
	
	<div class="main-container" id="main-container">
		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
		</script>
		<%@ include file="/common/admin/menu-left.jsp" %>
		
		<dec:body/>
		
		<!-- footer -->
    	<%@ include file="/common/admin/footer.jsp" %>
	</div>
		
		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src='<c:url value="/assets/js/bootstrap.min.js"/>'></script>
		<!-- ace scripts -->
		<script src='<c:url value="/assets/js/ace-elements.min.js"/>'></script>
		<script src='<c:url value="/assets/js/ace.min.js"/>'></script>
		<!-- page specific plugin scripts -->
		<script src='<c:url value="/assets/js/jquery.dataTables.min.js"/>'></script>
		<script src='<c:url value="/assets/js/jquery.dataTables.bootstrap.min.js"/>'></script>
		<script src='<c:url value="/assets/js/dataTables.tableTools.min.js"/>'></script>
		<script src='<c:url value="/assets/js/dataTables.colVis.min.js"/>'></script>
		
</body>
</html>