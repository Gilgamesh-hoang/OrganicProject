<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.laptrinhweb.util.OrderUtil" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tài khoản</title>

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
                                            <h1 class="dash__h1 u-s-m-b-14">Quản lý tài khoản</h1>

                                            <span class="dash__text u-s-m-b-30">Từ Trang tổng quan tài khoản, bạn có thể xem hoạt động 
                                            	tài khoản gần đây của mình và cập nhật thông tin tài khoản của mình. Chọn một liên kết bên dưới để xem hoặc chỉnh sửa thông tin.</span>
                                            <div class="row">
                                                <div class="col-lg-4 u-s-m-b-30">
                                                    <div class="dash__box dash__box--bg-grey dash__box--shadow-2 u-h-100">
                                                        <div class="dash__pad-3">
                                                            <h2 class="dash__h2 u-s-m-b-8">THÔNG TIN CỦA TÔI</h2>
                                                            <div class="dash__link dash__link--secondary u-s-m-b-8">
                                                                <a href='<c:url value="/thong-tin-cua-toi"/>'>Chỉnh sửa</a></div>
                                                            <span class="dash__text">${user.fullName}</span>
                                                            <span class="dash__text">${user.email}</span>
                                                            <span class="dash__text">${user.phoneNumber}</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-4 u-s-m-b-30">
                                                    <div class="dash__box dash__box--bg-grey dash__box--shadow-2 u-h-100">
                                                        <div class="dash__pad-3">
                                                            <h2 class="dash__h2 u-s-m-b-8">ĐỊA CHỈ ĐẶT HÀNG</h2>
                                                            <div class="dash__link dash__link--secondary u-s-m-b-8">
                                                                <a href='<c:url value="/dia-chi"/>'>Chỉnh sửa</a></div>
                                                            <span class="dash__text">${user.address.address}</span>
                                                            <span class="dash__text">${user.address.phoneNumber}</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="dash__box dash__box--shadow dash__box--bg-white dash__box--radius">
                                        <h2 class="dash__h2 u-s-p-xy-20">ĐƠN HÀNG GẦN ĐÂY</h2>
                                        <div class="dash__table-wrap gl-scroll">
                                            <table class="dash__table">
                                                <thead>
                                                    <tr>
                                                        <th>Mã đơn hàng #</th>
                                                        <th>Ngày</th>
                                                        <th>Trạng thái</th>
                                                        <th>Tổng</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                	<c:forEach var="order" items="${listOrder}">
	                                                    <tr>
	                                                        <td>${order.id }</td>
	                                                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${order.orderDate}" /></td>
	                                                        <td>${OrderUtil.map(order.status)}</td>
	                                                        <td>
	                                                            <div class="dash__table-total">
	
	                                                                <span><fmt:formatNumber type="number" groupingUsed="true" value="${order.totalPrice}"/> ₫</span>
	                                                                <div class="dash__link dash__link--brand">
	
	                                                                    <a href='<c:url value="/don-hang/${order.id}"/>'>XEM</a></div>
	                                                            </div>
	                                                        </td>
	                                                    </tr>
                                                	</c:forEach>
                                                    
                                                </tbody>
                                            </table>
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