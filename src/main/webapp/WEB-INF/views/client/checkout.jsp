<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đặt hàng</title>
 <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
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

    <!-- Header Section Begin -->
    <%@ include file="/common/client/header.jsp" %>
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
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
    <!-- Hero Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Checkout</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Checkout</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            
            <div class="checkout__form">
                <h4>Chi tiết đơn hàng</h4>
                <form:form method="POST" action="thanh-toan" modelAttribute="adrress">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <div class="checkout__input">
                                <p>Họ tên<span>*</span></p>
                                <form:input type="text" required="required" path="fullName"/>
                            </div>
                            
                            <div class="checkout__input">
                                <p>Địa chỉ<span>*</span></p>
                                <form:input type="text" path="address" placeholder="Street Address" class="checkout__input__add" required="required"/>
                            </div>
                            
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Số điện thoại<span>*</span></p>
                                        <form:input type="text" path="phoneNumber" required="required"/>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Email<span>*</span></p>
                                        <form:input type="text" path="email" required="required"/>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="checkout__input">
                                <p>Ghi chú</p>
                                <textarea name="note" placeholder="Ghi chú về đơn đặt hàng của bạn, ví dụ: ghi chú đặc biệt cho giao hàng." rows="4" cols="50"></textarea>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="checkout__order">
                                <h4>Đơn hàng</h4>
                                <div class="checkout__order__products">Sản phẩm <span>Giá</span></div>
                                <ul>
	                                <c:forEach var="cartItem" items="${cart.items}">
	                                    <li>${cartItem.product.productName}<span><fmt:formatNumber type="number" groupingUsed="true" value="${cartItem.product.price}"/> ₫</span></li>	                                
	                                </c:forEach>
                                </ul>
                                <div class="checkout__order__total">Tổng  <span><fmt:formatNumber type="number" groupingUsed="true" value="${cart.totalPrice}"/> ₫</span></div>
                                
                                <button type="submit" class="site-btn">Đặt hàng</button>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </section>
    <!-- Checkout Section End -->

    
    <!-- Footer Section Begin -->
    <%@ include file="/common/client/footer.jsp" %>
    <!-- Footer Section End -->

	<!-- disable các trường thông tin trừ note -->
	<script>
		window.addEventListener('DOMContentLoaded', (event) => {
		  var inputFields = document.querySelectorAll('input:not([type="hidden"],[id="search"]), select');
		  inputFields.forEach(function(inputField) {
		    inputField.disabled = true;
		  });
		});
	</script>
	
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