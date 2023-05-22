<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="url" value="/dia-chi/mac-dinh"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Địa chỉ mặc định</title>

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
                                    <!-- <form class="dash__address-make"> -->
                                        <div class="dash__box dash__box--shadow dash__box--bg-white dash__box--radius u-s-m-b-30">
                                            <h2 class="dash__h2 u-s-p-xy-20">Chọn địa chỉ mặc định</h2>
                                            <div class="dash__table-2-wrap gl-scroll">
                                                <table class="dash__table-2">
                                                    <thead>
                                                        <tr>
                                                            <th>Chọn</th>
                                                            <th>Họ tên</th>
	                                                        <th>Địa chỉ</th>
	                                                        <th>Email</th>
	                                                        <th>Số điện thoại</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach var="address" items="${listAddress}">
	                                                    <tr>
                                                            <td>
                                                            	<c:set var="checked" value=""/>
                                                            	<c:if test="${address.defaultAddress == true}"><c:set var="checked" value="checked"/></c:if>
                                                                <!--====== Radio Box ======-->
                                                                <div class="radio-box">
                                                                    <input type="radio" name="default-address" value="${address.id}" ${checked}>
                                                                    <div class="radio-box__state radio-box__state--primary">
                                                                        <label class="radio-box__label" ></label></div>
                                                                </div>
                                                                <!--====== End - Radio Box ======-->
                                                            </td>
                                                            <td>${address.fullName}</td>
	                                                        <td>${address.address}</td>
	                                                        <td>${address.email}</td>
	                                                        <td>${address.phoneNumber}</td>
	                                                    </tr>
	                                                </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <div>

                                            <button class="btn btn--e-brand-b-2" type="submit">Lưu</button></div>
                                    <!-- </form> -->
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

	<script>
	    document.querySelector('.btn--e-brand-b-2').addEventListener('click', function() {
	        // Lấy giá trị của radio box được chọn
	        var addressId = document.querySelector('input[name="default-address"]:checked').value;
	        // Thực hiện xử lý theo giá trị đã chọn
	        window.location.href = '${url}/' + addressId;
	    });
	</script>
	
	
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