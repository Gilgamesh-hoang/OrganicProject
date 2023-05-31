<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<c:url var="cartAPI" value="/gio-hang"/>
<c:url var="homeURL" value="/trang-chu"/>
<!DOCTYPE html>
<html>
<head>
    <title>Trang chủ</title>
    
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
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
    <section class="hero">
        <div class="container">
            <div class="row">
                <!-- menu left -->
			   	<%@ include file="/common/client/menu_left.jsp" %>
			    
                <div class="col-lg-9">
                
                    <!-- search bar -->
    				<%@ include file="/common/client/search_bar.jsp" %>

                    <div class="hero__item set-bg" data-setbg="img/hero/banner.jpg">
                        <div class="hero__text">
                            <span>FRUIT FRESH</span>
                            <h2>Vegetable <br />100% Organic</h2>
                            <p>Free Pickup and Delivery Available</p>
                            <a href="#" class="primary-btn">SHOP NOW</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Categories Section Begin -->
    <section class="categories">
        <div class="container">
            <div class="row">
                <div class="categories__slider owl-carousel">
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="img/categories/cat-1.jpg">
                            <h5><a href="#">Fresh Fruit</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="img/categories/cat-2.jpg">
                            <h5><a href="#">Dried Fruit</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="img/categories/cat-3.jpg">
                            <h5><a href="#">Vegetables</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="img/categories/cat-4.jpg">
                            <h5><a href="#">drink fruits</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="img/categories/cat-5.jpg">
                            <h5><a href="#">drink fruits</a></h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Categories Section End -->

    <!-- Featured Section Begin -->
    <section class="featured spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>Sản phẩm</h2>
                    </div>
                </div>
            </div>
            <div class="row featured__filter">
                <c:forEach var="product" items="${products.listObject}">
                	<div class="col-lg-3 col-md-4 col-sm-6 mix fastfood vegetables">
	                    <div class="featured__item">
	                        <div class="featured__item__pic set-bg" data-setbg="img/product/${product.image}">
	                            <ul class="featured__item__pic__hover">
	                                <li><a href='<c:url value="/danh-sach-yeu-thich/them?productId=${product.id}"/>'><i class="fa fa-heart"></i></a></li>
	                                <%-- <li><button id="addCart" type="button" onclick="addToCart(${product.id})"  data-toggle="tooltip" title='Thêm vào giỏ hàng'><i class="fa fa-shopping-cart"></i></button></li> --%>
	                                <li><a href='<c:url value="/gio-hang/them?productId=${product.id}"/>'><i class="fa fa-shopping-cart"></i></a></li>
	                            </ul>
	                        </div>
	                        <div class="featured__item__text">
	                            <h6><a href='<c:url value="/san-pham?id=${product.id}"/>'>${product.productName}</a></h6>
	                            <h5><fmt:formatNumber type="number" groupingUsed="true" value="${product.price}"/> ₫</h5>
	                        </div>
	                    </div>
                	</div>
                </c:forEach>
            </div>
	            <!-- paginatation -->
		        <nav aria-label="Page navigation example">
				  <ul class="pagination justify-content-center">
					<c:forEach var="index" begin="1" end="${products.totalPage}">
						<li class="page-item">
							<a class="page-link" href='<c:url value="/trang-chu?page=${index}"/>'
							style='<c:if test="${index == products.page}">background-color: #a6ce38;color:#fff</c:if>'>${index}</a>
						</li>    
					</c:forEach>

				  </ul>
				</nav>
			
        </div>
        
	
    </section>
    <!-- Featured Section End -->
    <!-- Banner Begin -->
    <div class="banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        <img src="img/banner/banner-1.jpg" alt="">
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        <img src="img/banner/banner-2.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Banner End -->

    <!-- Blog Section Begin -->
    <section class="from-blog spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title from-blog__title">
                        <h2>Bài viết</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <c:forEach var="blog" items="${blog}">
            		<div class="col-lg-4 col-md-4 col-sm-6">
	                    <div class="blog__item">
	                        <a href='<c:url value="/blogDetail/${blog.id}"/>' class="blog__item__pic"> 
	                            <img src='<c:url value="/img/blog/${blog.image}"/>' alt="">
	                        </a>
	                        <div class="blog__item__text">
	                            <ul>
	                                <li><i class="fa fa-calendar-o"></i>${blog.createdDate}</li>
	                                <li><i class="fa fa-comment-o"></i> 5</li>
	                            </ul>
	                            <h5><a href='<c:url value="/blogDetail/${blog.id}"/>'>${blog.title}</a></h5>
	                            <p>${blog.shortDescription}</p>
	                        </div>
	                    </div>
                	</div>
            	</c:forEach>
            </div>
        </div>
    </section>
    <!-- Blog Section End -->
	
    <!-- Footer Section Begin -->
    <%@ include file="/common/client/footer.jsp" %>
    <!-- Footer Section End -->

	<!-- <script>
		function addToCart(data) {
			$.ajax({
				url: '${cartAPI}',
				type: 'POST',
				data: { productId: data },
				success: function(result) {
					alert('Sản phẩm đã được thêm vào giỏ hàng');
				},
				error: function(result) {
					/* window.location.href = "${newURL}?page=1&limit=6&message=error_system"; */
					alert("loi");
				}
				
			});
		}
	
	</script> -->
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