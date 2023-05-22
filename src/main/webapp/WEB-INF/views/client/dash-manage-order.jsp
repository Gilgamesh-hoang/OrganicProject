<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đơn hàng</title>
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
                                            <div class="dash-l-r">
                                                <div>
                                                    <div class="manage-o__text-2 u-c-secondary">Mã đơn hàng #${order.id }</div>
                                                    <div class="manage-o__text u-c-silver">Đặt ngày <fmt:formatDate pattern="yyyy-MM-dd" value="${order.orderDate}" /></div>
                                                </div>
                                                <div>
                                                    <div class="manage-o__text-2 u-c-silver">Tổng:
                                                        <span class="manage-o__text-2 u-c-secondary"><fmt:formatNumber type="number" groupingUsed="true" value="${order.totalPrice}"/> ₫</span></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="dash__box dash__box--shadow dash__box--radius dash__box--bg-white u-s-m-b-30">
                                        <div class="dash__pad-2">
                                            <div class="manage-o">
                                                <div class="manage-o__header u-s-m-b-30">
                                                    
                                                </div>
                                                <div class="dash-l-r">
                                                    <div class="manage-o__text u-c-secondary">Delivered on 26 Oct 2016</div>
                                                </div>
                                                <div class="manage-o__timeline">
                                                    <div class="timeline-row">
                                                        <div class="col-lg-4 u-s-m-b-30">
                                                            <div class="timeline-step">
                                                                <div class="timeline-l-i timeline-l-i--finish">

                                                                    <span class="timeline-circle"></span></div>

                                                                <span class="timeline-text">Đang chuẩn bị</span>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-4 u-s-m-b-30">
                                                            <div class="timeline-step">
                                                                <div class="timeline-l-i timeline-l-i--finish">

                                                                    <span class="timeline-circle"></span></div>

                                                                <span class="timeline-text">Đang giao hàng</span>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-4 u-s-m-b-30">
                                                            <div class="timeline-step">
                                                                <div class="timeline-l-i">

                                                                    <span class="timeline-circle"></span></div>

                                                                <span class="timeline-text">Đã giao hàng</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <c:forEach var="item" items="${order.listOrderItem}">
	                                                <div class="manage-o__description">
	                                                    <div class="description__container">
	                                                        <div class="description__img-wrap">
	
	                                                            <img class="u-img-fluid" src='<c:url value="/img/product/${item.product.image}"/>' alt=""></div>
	                                                        <div class="description-title">${item.product.productName}</div>
	                                                    </div>
	                                                    <div class="description__info-wrap">
	                                                        <div>
	
	                                                            <span class="manage-o__text-2 u-c-silver">Số lượng:
	
	                                                                <span class="manage-o__text-2 u-c-secondary">${item.quantity}</span></span></div>
	                                                        <div>
	
	                                                            <span class="manage-o__text-2 u-c-silver">Tổng:
	
	                                                                <span class="manage-o__text-2 u-c-secondary"><fmt:formatNumber type="number" groupingUsed="true" value="${item.totalPrice}"/> ₫</span></span></div>
	                                                    </div>
	                                                </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="dash__box dash__box--bg-white dash__box--shadow u-s-m-b-30">
                                                <div class="dash__pad-3">
                                                    <h2 class="dash__h2 u-s-m-b-8 manage-o__text-2">Địa chỉ giao hàng</h2>
                                                    <h2 class="dash__text-2">Tên: ${user.fullName }</h2>

                                                    <span class="dash__text-2">Địa chỉ: ${user.address.address }</span>

                                                    <span class="dash__text-2">SĐT: ${user.phoneNumber}</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="dash__box dash__box--bg-white dash__box--shadow u-h-100">
                                                <div class="dash__pad-3">
                                                    <h2 class="dash__h2 u-s-m-b-8">Chi tiết thanh toán</h2>
                                                    <div class="dash-l-r u-s-m-b-8">
                                                        <div class="manage-o__text-2 u-c-secondary">Tổng tiền hàng</div>
                                                        <div class="manage-o__text-2 u-c-secondary"><fmt:formatNumber type="number" groupingUsed="true" value="${order.totalPrice}"/> ₫</div>
                                                    </div>
                                                    <div class="dash-l-r u-s-m-b-8">
                                                        <div class="manage-o__text-2 u-c-secondary">Tổng tiền vận chuyển</div>
                                                        <div class="manage-o__text-2 u-c-secondary"><fmt:formatNumber type="number" groupingUsed="true" value="0"/> ₫</div>
                                                    </div>
                                                    <div class="dash-l-r u-s-m-b-8">
                                                        <div class="manage-o__text-2 u-c-secondary">Tổng thanh toán</div>
                                                        <div class="manage-o__text-2 u-c-secondary"><fmt:formatNumber type="number" groupingUsed="true" value="${order.totalPrice}"/> ₫</div>
                                                    </div>
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