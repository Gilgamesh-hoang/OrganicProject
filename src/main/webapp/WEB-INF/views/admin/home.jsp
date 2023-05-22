<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Blank Page - Ace Admin</title>

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

	</head>
<body class="no-skin">
		<%@ include file="/common/admin/header.jsp" %>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<%@ include file="/common/admin/menu-left.jsp" %>

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>

							<li>
								<a href="#">Other Pages</a>
							</li>
							<li class="active">Blank Page</li>
						</ul><!-- /.breadcrumb -->

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- /.nav-search -->
					</div>

					<div class="page-content">
						
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<%@ include file="/common/admin/footer.jsp" %>
		</div><!-- /.main-container -->

		<!--[if !IE]> -->
		<script src='<c:url value="/assets/js/jquery.2.1.1.min.js"/>'></script>

		<!--[if !IE]> -->
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

	</body>
</html>