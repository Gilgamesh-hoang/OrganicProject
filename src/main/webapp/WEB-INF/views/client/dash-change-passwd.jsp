<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thay đổi mật khẩu</title>
	<!--====== Google Font ======-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800" rel="stylesheet">
	<!--====== Utility-Spacing ======-->
     <link rel="stylesheet" href='<c:url value="/css/utility.css"/>'>
     <!--====== App ======-->
     <link rel="stylesheet" href='<c:url value="/css/app.css"/>'>
     <!-- Icon -->
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> 
    <!-- Css Styles -->
    <link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>' > 
    <link rel="stylesheet" href='<c:url value="/css/elegant-icons.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/nice-select.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/jquery-ui.min.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/owl.carousel.min.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/slicknav.min.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/style.css"/>' >
</head>
<body class="config">
    <div class="preloader is-active">
        <div class="preloader__wrap">

            <img class="preloader__img" src="images/preloader.png" alt=""></div>
    </div>

    <!--====== Main App ======-->
    <div id="app">

        <!--====== Main Header ======-->
        <%@ include file="/common/client/header.jsp" %>
        
        <section class="hero hero-normal">
                <div class="container">
                    <div class="row">
                        <!-- menu left -->
			   			<%@ include file="/common/client/menu_left.jsp" %>
                        <div class="col-lg-9">
                            <!-- search bar -->
    						<%@ include file="/common/client/search_bar.jsp" %>
                        </div>
                    </div>
                </div>
            </section>
        <!--====== End - Main Header ======-->


        <!--====== App Content ======-->
        <div class="app-content">

            <!--====== Section 2 ======-->
            <div class="u-s-p-b-60">

                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="dash">
                        <div class="container">
                            <div class="row">
                                 <%@ include file="/common/client/nav-left-dashboard.jsp" %>
                                <div class="col-lg-9 col-md-12">
                                    <div class="dash__box dash__box--shadow dash__box--radius dash__box--bg-white">
                                        <div class="dash__pad-2">
                                        	<!-- nếu vừa đăng kí thành công thì hiển thị ra thông báo này hoặc đăng nhập thất bại -->
		                                 	<c:if test="${param.error != null}">
								                <div class="alert alert-danger alert-dismissible fade show" role="alert">
												  <strong>Thay đổi mật khẩu thất bại.</strong> Có thể mật khẩu bạn nhập không khớp với mật khẩu hiện tại, vui lòng kiểm tra lại.
												  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
												    <span aria-hidden="true">&times;</span>
												  </button>
												</div>
		                                 	</c:if>
                                            <h1 class="dash__h1 u-s-m-b-14">Thay đổi mật khẩu</h1>
                                            <div class="row">
                                                <div class="col-lg-12">
                                                    <form class="dash-edit-p" action='<c:url value="/thay-doi-mat-khau"/>' method="post" onsubmit="return validateForm()" name="myForm">
                                                        <div class="gl-inline">
                                                            <div class="u-s-m-b-30">
                                                                <label class="gl-label">Mật khẩu hiện tại</label>
                                                                <input class="input-text input-text--primary-style" name="currentPassword" type="password" placeholder="Nhập mật khẩu hiện tại"  required="required">
                                                            </div>
                                                        
                                                        </div>
                                                        <div class="gl-inline">
                                                            <div class="u-s-m-b-30">
                                                                <label class="gl-label">Mật khẩu mới</label>
                                                                <input class="input-text input-text--primary-style"  name="newPassword" type="password" placeholder="Nhập mật khẩu mới"  required="required">
                                                            </div>
                                                        
                                                        </div>
                                                        <div class="gl-inline">
                                                            <div class="u-s-m-b-30">
                                                                <label class="gl-label">Nhập lại mật khẩu mới</label>
                                                                <input class="input-text input-text--primary-style" name="confirmNewPassword" type="password" placeholder="Nhập lại mật khẩu mới"  required="required">
                                                            </div>
                                                        
                                                        </div>
                                                       
                                                        <button class="btn btn--e-brand-b-2" type="submit">Lưu</button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Content ======-->
            </div>
            <!--====== End - Section 2 ======-->
        </div>

        <!--====== Main Footer ======-->
        <%@ include file="/common/client/footer.jsp" %>
    </div>
    
    
    
    <script>
		function validateForm() {
		    var newPassword = document.forms["myForm"]["newPassword"].value;
		    var confirmPassword = document.forms["myForm"]["confirmNewPassword"].value;
		    if (newPassword != confirmPassword) {
		        alert("Mật khẩu xác nhận không khớp!");
		        return false;
		    }
		}
	</script>
	
    <!--====== End - Main App ======-->
	<!--====== Vendor Js ======-->
    <script src='<c:url value="/js/vendor.js"/>'></script>
    <!--====== jQuery Shopnav plugin ======-->
    <script src='<c:url value="/js/jquery.shopnav.js"/>'></script>
    <!--====== App ======-->
    <script src='<c:url value="/js/app.js"/>'></script>
    
    <!-- Js Plugins -->
    <script src='<c:url value="/js/jquery-3.3.1.min.js"/>'></script>
    <script src='<c:url value="/js/bootstrap.min.js"/>'></script>
    <script src='<c:url value="/js/jquery.nice-select.min.js"/>'></script>
    <script src='<c:url value="/js/jquery-ui.min.js"/>'></script>
    <script src='<c:url value="/js/jquery.slicknav.js"/>'></script>
    <script src='<c:url value="/js/mixitup.min.js"/>'></script>
    <script src='<c:url value="/js/owl.carousel.min.js"/>'></script>
    <script src='<c:url value="/js/main.js"/>'></script>
</body>
</html>