<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách yêu thích</title>
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

                <!--====== Section Intro ======-->
                <div class="section__intro u-s-m-b-60">
                    <div class="container">
                        <div class="row">
                        	
                            <div class="col-lg-12">
                                <div class="section__text-wrap">
                                    <h1 class="section__heading u-c-secondary">Danh sách yêu thích</h1>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Intro ======-->


                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">
                        <div class="row">
                            	<div class="col-lg-12 col-md-12 col-sm-12">

                                <!--====== Wishlist Product ======-->
                                <c:forEach var="item" items="${wishlist.products}">
	                                <div class="w-r u-s-m-b-30">
	                                    <div class="w-r__container">
	                                        <div class="w-r__wrap-1">
	                                            <div class="w-r__img-wrap">
	
	                                                <img class="u-img-fluid" src='<c:url value="/img/product/${item.product.image}"/>'></div>
	                                            <div class="w-r__info">
	
	                                                <span class="w-r__name">
	
	                                                    <a href='<c:url value="/san-pham?id=${item.product.id}"/>'>${item.product.productName}</a></span>
	
	                                                <span class="w-r__category">
	
	                                                    <a href='<c:url value="/danh-muc?genreId=${item.product.genre.id}"/>'>${item.product.genre.genreName}</a></span>
	
	                                                <span class="w-r__price"><fmt:formatNumber type="number" groupingUsed="true" value="${item.product.price}"/> ₫</span></div>
	                                        </div>
	                                        <div class="w-r__wrap-2">
	
	                                            <a href='<c:url value="/gio-hang/them?productId=${item.product.id}"/>' class="w-r__link btn--e-brand-b-2" >THÊM VÀO GIỎ HÀNG</a>
	
	                                            <a class="w-r__link btn--e-transparent-platinum-b-2" href='<c:url value="/danh-sach-yeu-thich/xoa/${item.id}"/>'>XÓA</a></div>
	                                    </div>
	                                </div>
                                
                                </c:forEach>
                                <!--====== End - Wishlist Product ======-->

                            </div>
                            <div class="col-lg-12">
                                <div class="route-box">
                                    <div class="route-box__g">

                                        <a class="route-box__link" href='<c:url value="/trang-chu"/>'><i class="fas fa-long-arrow-alt-left"></i>

                                            <span>TIẾP TỤC MUA SẮM</span></a></div>
                                    <div class="route-box__g">

                                        <a class="route-box__link" href="#"><i class="fa fa-trash"></i>

                                            <span>XÓA DANH SÁCH</span></a></div>
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