<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/gio-hang/cap-nhat" var="update"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
	<!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
    <!-- Icon -->
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> 
	
    <!-- Css Styles -->
    <link rel="stylesheet" href='<c:url value="/css/app.css"/>'>
    <link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>' > 
    <link rel="stylesheet" href='<c:url value="/css/elegant-icons.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/nice-select.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/jquery-ui.min.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/owl.carousel.min.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/slicknav.min.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/style.css"/>' >
    <script src='<c:url value="/js/jquery-3.3.1.min.js"/>'></script>
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
                        <h2>Shopping Cart</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Shopping Cart</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shoping Cart Section Begin -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th class="shoping__product">Sản phẩm</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
                                    <th>Cập nhật</th>
                                    <th>Tổng</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="cartItem" items="${cart.items}">
                            	<tr>
                                    <td class="shoping__cart__item">
                                        <a href='<c:url value="/san-pham?id=${cartItem.product.id}"/>'><img src='<c:url value="/img/product/${cartItem.product.image}"/>'>
                                        <h5>${cartItem.product.productName}</h5></a>
                                    </td>
                                    <td class="shoping__cart__price">
                                        <fmt:formatNumber type="number" groupingUsed="true" value="${cartItem.product.price}"/> ₫
                                    </td>
                                    <td>
                                        <div class="input-counter">
                                            <span class="input-counter__minus fa fa-minus"></span>
                                            <input class="input-counter__text input-counter--text-primary-style" type="text" 
                                            	value="${cartItem.quantity}" data-min="1" data-max="1000" id="quantity-cart-${cartItem.id}">
                                            <span class="input-counter__plus fa fa-plus"></span>
                                        </div>
                                    </td>
                                    <td class="shoping__cart__total">
                                        <button data-id="${cartItem.id}" class="primary-btn cart-btn editCart" type="button">
					                  		<span><i class="fa fa-pencil"></i></span>
					                  	</button>
                                    </td>
                                    <td class="shoping__cart__total">
                                       <fmt:formatNumber type="number" groupingUsed="true" value="${cartItem.totalPrice}"/> ₫
                                    </td>
                                    <td class="shoping__cart__item__close">
                                        <a href='<c:url value="/gio-hang/xoa/${cartItem.id}"/>' ><span class="icon_close"><i class="fa fa-times"></i></span></a>
                                    </td>
                                </tr>
                            </c:forEach>
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__btns">
                        <a href='<c:url value="/trang-chu"/>' class="primary-btn cart-btn">Tiếp tục mua sắm</a>
                        <a href="#" class="primary-btn cart-btn cart-btn-right"><span ><i class="fa fa-refresh"></i></span>
                            Cập nhật giỏ hàng</a>
                    </div>
                </div>
               
                <div class="col-lg-6">
				    <div class="shoping__checkout">
				        <h5>Tổng giá trị giỏ hàng</h5>
				        <ul>
				            <li>Số lượng <span>${cart.totalQuantity}</span></li>
				            <li>Giá trị <span><fmt:formatNumber type="number" groupingUsed="true" value="${cart.totalPrice}"/> ₫</span></li>
				        </ul>
				        <c:set var="disabled" value=""/>
				        <c:if test="${cart.totalQuantity == 0}"><c:set var="disabled" value="disabled"/></c:if>
				        <a href='<c:url value="/thanh-toan"/>' class="primary-btn ${disabled}" >Thanh toán</a>
				    </div>
				</div>
                
            </div>
        </div>
    </section>
    <!-- Shoping Cart Section End -->

    <!-- Footer Section Begin -->
   	<%@ include file="/common/client/footer.jsp" %>
    <!-- Footer Section End -->
	
	
	<script >
		$(".editCart").on("click" , function() {
			var id = $(this).data("id");
			var quantity = $("#quantity-cart-"+id).val();
			window.location = "${update}?id="+id+"&quantity="+quantity; 
		});
		
		<!-- disabled nút thanh toán khi giỏ hàng trống -->
		/* window.addEventListener('DOMContentLoaded', () => {
	        const checkoutBtn = document.getElementById('checkoutBtn');
	        const totalQuantity = ${cart.totalQuantity};
	        
	        if (totalQuantity === 0) {
	            checkoutBtn.disabled = true;
	        }
	    }); */
	</script>

	
    <!-- Js Plugins -->
    <script src='<c:url value="/js/bootstrap.min.js"/>'></script>
    <script src='<c:url value="/js/jquery.nice-select.min.js"/>'></script>
    <script src='<c:url value="/js/jquery-ui.min.js"/>'></script>
    <script src='<c:url value="/js/jquery.slicknav.js"/>'></script>
    <script src='<c:url value="/js/mixitup.min.js"/>'></script>
    <script src='<c:url value="/js/owl.carousel.min.js"/>'></script>
    <script src='<c:url value="/js/main.js"/>'></script>
	<!--====== Vendor Js ======-->
    <script src='<c:url value="/js/vendor.js"/>'></script>

    <!--====== jQuery Shopnav plugin ======-->
    <script src='<c:url value="/js/jquery.shopnav.js"/>'></script>

    <!--====== App ======-->
    <script src='<c:url value="/js/app.js"/>'></script>

</body>
</html>