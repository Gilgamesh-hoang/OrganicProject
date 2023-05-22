<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
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
                                    <div class="dash__box dash__box--shadow dash__box--radius dash__box--bg-white u-s-m-b-30">
                                        <div class="dash__pad-2">
                                            <h1 class="dash__h1 u-s-m-b-14">Thông tin của tôi</h1>

                                            <span class="dash__text u-s-m-b-30">Xem tất cả thông tin của bạn, bạn có thể tùy chỉnh hồ sơ của mình.</span>
                                            <div class="row">
                                                <div class="col-lg-4 u-s-m-b-30">
                                                    <h2 class="dash__h2 u-s-m-b-8">Họ tên</h2>

                                                    <span class="dash__text">${user.fullName}</span>
                                                </div>
                                                <div class="col-lg-4 u-s-m-b-30">
                                                    <h2 class="dash__h2 u-s-m-b-8">E-mail</h2>

                                                    <span class="dash__text">${user.email}</span>
                                                    
                                                </div>
                                                <div class="col-lg-4 u-s-m-b-30">
                                                    <h2 class="dash__h2 u-s-m-b-8">Số điện thoại</h2>

                                                    <span class="dash__text">${user.phoneNumber}</span>
                                                    
                                                </div>
                                                <div class="col-lg-4 u-s-m-b-30">
                                                    <h2 class="dash__h2 u-s-m-b-8">Tên đăng nhập</h2>

                                                    <span class="dash__text">${user.username}</span>
                                                </div>
                                                <%-- <div class="col-lg-4 u-s-m-b-30">
                                                    <h2 class="dash__h2 u-s-m-b-8">Địa chỉ</h2>
                                                    <span class="dash__text">${user.address}</span>
                                                </div> --%>
                                            </div>
                                            <div class="row">
                                                <div class="col-lg-12">
                                                    
                                                    <div class="u-s-m-b-16">

                                                        <a class="dash__custom-link btn--e-transparent-brand-b-2" href='<c:url value="/chinh-sua-thong-tin"/>'>Thay đổi thông tin</a></div>
                                                    <div>

                                                        <a class="dash__custom-link btn--e-brand-b-2" href='<c:url value="/thay-doi-mat-khau"/>'>Thay đổi mật khẩu</a></div>
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
        <!--====== End - App Content ======-->


        <!--====== Main Footer ======-->
        <%@ include file="/common/client/footer.jsp" %>
    </div>
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