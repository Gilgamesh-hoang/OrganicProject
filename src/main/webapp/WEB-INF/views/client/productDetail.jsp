<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.laptrinhweb.util.SecurityUtils" %>
<%@include file="/common/taglib.jsp"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Chi tiết sản phẩm</title>

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
    <section class="breadcrumb-section set-bg" data-setbg='<c:url value="/img/breadcrumb.jpg"/>'>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Vegetable’s Package</h2>
                        <div class="breadcrumb__option">
                            <a href="#">Home</a>
                            <a href="#">Vegetables</a>
                            <span>Vegetable’s Package</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Product Details Section Begin -->
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                            <img class="product__details__pic__item--large"
                                src='<c:url value="/img/product/${productDetail.image}"/>' alt="Ảnh sản phẩm">
                        </div>
                         
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3>${productDetail.productName}</h3>
                        <div class="product__details__rating">
                     	<!-- in ra rate người dùng đã đánh giá -->
							<c:forEach begin="1" end="${productDetail.rate}">
								<i class="fa fa-star"></i>
							</c:forEach>
							<!-- in ra sao rỗng -->
							<c:forEach begin="${productDetail.rate}" end="4">
								<i class="fa fa-star-o"></i>
							</c:forEach>
                            <span>(${productDetail.totalComment} bình luận)</span>
                        </div>
                        <div class="product__details__price"><fmt:formatNumber type="number" groupingUsed="true" value="${productDetail.price}"/> ₫</div>
						<form action='<c:url value="/gio-hang/them"/>' method="get">
	                        <div class="input-counter">
	                             <span class="input-counter__minus fa fa-minus"></span>
	                             <input class="input-counter__text input-counter--text-primary-style" type="text" 
	                                    value="1" data-min="1" data-max="1000" name="quantity">
	                             <span class="input-counter__plus fa fa-plus"></span>
	                        </div>
	                        <input type="hidden" name="productId" value="${productDetail.id}">
	                        <button style="border: none;" type="submit" class="primary-btn product-detail-add">Thêm vào giỏ</button>
	                        <a href='<c:url value="/danh-sach-yeu-thich/them?productId=${productDetail.id}"/>' class="heart-icon"><i class="fa fa-heart"></i></a>
						</form>
                        <ul>
                            <li><b>Số lượng có sẵn</b> <span>${productDetail.available}</span></li>
                            <li><b>Giao hàng</b><samp>Nhận hàng miễn phí ngay hôm nay </samp></li>
                            <li><b>Trọng lượng</b> <span>${productDetail.weight} kg</span></li>
                            <li><b>Share on</b>
		                    <div class="footer__widget social">
		                        
		                        <div class="footer__widget__social">
		                            <a href="#"><i class="fa fa-facebook"></i></a>
		                            <a href="#"><i class="fa fa-instagram"></i></a>
		                            <a href="#"><i class="fa fa-twitter"></i></a>
		                            <a href="#"><i class="fa fa-pinterest"></i></a>
		                        </div>
		                    </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                                    aria-selected="true">Mô tả</a>
                            </li>
                             <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab"
                                    aria-selected="false">Thương hiệu</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                                    aria-selected="false">Bình luận <span>(${productDetail.totalComment})</span></a>
                            </li> 
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h6>Thông tin sản phẩm</h6>
                                    ${productDetail.description}
                                </div>
                            </div>
                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h6>Tên thương hiệu: ${productDetail.manufacturer.manufacturerName}</h6>
                                    <img class="img_manufacturer" src='<c:url value="/img/manufacturer/${productDetail.manufacturer.image}"/>' alt="Ảnh thương hiệu">
                                    ${productDetail.manufacturer.description}
                                </div>
                            </div>
                            <div class="tab-pane" id="tabs-3" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <div class="pd-tab__rev">
                                        <div class="u-s-m-b-30">
                                            <div class="pd-tab__rev-score">
                                                <div class="u-s-m-b-8">
                                                    <h2>${productDetail.totalComment} Bình luận - ${productDetail.rate} (Tổng quan)</h2>
                                                </div>
                                                <div class="gl-rating-style-2 u-s-m-b-8">
                                                	<c:forEach begin="1" end="${productDetail.rate}">
	                                                     <i class="fa fa-star"></i>
	                                                </c:forEach>
                                                </div>
                                                <div class="u-s-m-b-8">
                                                    <h4>Chúng tôi muốn nghe từ bạn!</h4>
                                                </div>

                                                <span class="gl-text">Hãy cho chúng tôi biết những gì bạn nghĩ về sản phẩm này</span>
                                            </div>
                                        </div>
                                        <div class="u-s-m-b-30">
                                                <div class="rev-f1__group">
                                                    <div class="u-s-m-b-15">
                                                        <label for="sort-review"></label><select class="select-box select-box--primary-style" id="sort-review">
                                                            <option selected>Sort by: Best Rating</option>
                                                            <option>Sort by: Worst Rating</option>
                                                        </select></div>
                                                </div>
                                                <div class="rev-f1__review">
                                                	<c:forEach var="comment" items="${productDetail.listComment }">
	                                                    <div class="review-o u-s-m-b-15">
	                                                        <div class="review-o__info u-s-m-b-8">
	                                                            <span class="review-o__name">${comment.user.fullName }</span>
	                                                            <span class="review-o__date"><fmt:formatDate type="both" value="${comment.createdDate}" /></span></div>
	                                                        <div class="review-o__rating gl-rating-style u-s-m-b-8">
	                                                        	<!-- in ra rate người dùng đã đánh giá -->
	                                                        	<c:forEach begin="1" end="${comment.rate}">
	                                                        		<i class="fa fa-star"></i>
	                                                        	</c:forEach>
	                                                        	<!-- in ra sao rỗng -->
	                                                        	<c:forEach begin="${comment.rate}" end="4">
	                                                        		<i class="fa fa-star-o"></i>
	                                                        	</c:forEach>
	                                                        
	                                                        </div>
	                                                        <p class="review-o__text">${comment.content}</p>
	                                                    </div>
                                                	</c:forEach>
                                                </div>
											<!-- paginatation -->
											<nav aria-label="Page navigation example">
												<ul class="pagination justify-content-center mt-20">
													<c:forEach var="index" begin="1" end="${totalPage}">
														<li class="page-item"><a class="page-link" href='<c:url value="${url}&page=${index}"/>' 
															style='<c:if test="${index == page}">background-color: #a6ce38;color:#fff</c:if>'>${index}</a>
														</li>
													</c:forEach>

												</ul>
											</nav> 
										</div>
                                        <c:if test="${SecurityUtils.getPrincipal() != null}">
	                                        <div class="u-s-m-b-30">
	                                            <form action='<c:url value="/binh-luan-san-pham"/>' class="pd-tab__rev-f2" method="post">
	                                                <div class="u-s-m-b-30">
	                                                    <div class="rev-f2__table-wrap gl-scroll">
	                                                        <table class="rev-f2__table">
	                                                            <thead>
	                                                                <tr>
	                                                                	<c:forEach begin="1" end="5" var="i">
	                                                                		<th>
			                                                                    <div class="gl-rating-style-2">
			                                                                		<c:forEach begin="1" end="${i}" var="j">
			                                                                			<i class="fa fa-star"></i>
			                                                                		</c:forEach>
	                                                                			<span>${i}</span></div>
			                                                                </th>
	                                                                	</c:forEach>
	                                                                </tr>
	                                                            </thead>
	                                                            <tbody>
	                                                                <tr>
	                                                                	<c:forEach begin="1" end="5" var="index">
		                                                                    <td>
		                                                                        <!--====== Radio Box ======-->
		                                                                        <div class="radio-box">
		                                                                            <input type="radio" id="star-${index }" name="rating" value="${index }">
		                                                                            <div class="radio-box__state radio-box__state--primary">
		                                                                                <label class="radio-box__label" for="star-${index }"></label></div>
		                                                                        </div>
		                                                                        <!--====== End - Radio Box ======-->
		                                                                    </td>
	                                                                	
	                                                                	</c:forEach>
	                                                                </tr>
	                                                            </tbody>
	                                                        </table>
	                                                    </div>
	                                                </div>
	                                                <div class="rev-f2__group">
	                                                    <div class="u-s-m-b-15">
	                                                        <label class="gl-label" for="reviewer-text">Bình luận của bạn *</label>
	                                                        <textarea name="comment" class="text-area text-area--primary-style" id="reviewer-text" required="required"></textarea></div>
	                                                </div>
	                                                <div>
	                                                	<input type="hidden" name="rate" value="">
	                                                	<input type="hidden" name="productId" value="${productDetail.id}">
	                                                    <button class="btn btn--e-brand-shadow" type="submit">Bình luận</button></div>
	                                            </form>
	                                        </div>
                                    	</c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Details Section End -->

    <!-- Related Product Section Begin -->
    <section class="related-product">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title related__product__title">
                        <h2>Sản phẩm liên quan</h2>
                    </div>
                </div>
            </div>
            <div class="row">
            	<c:forEach var="productRelated" items="${productDetail.listObject}">
	            	<div class="col-lg-3 col-md-4 col-sm-6">
	                    <div class="product__item">
	                        <div class="product__item__pic set-bg" data-setbg='<c:url value="/img/product/${productRelated.image}"/>'>
	                            <ul class="product__item__pic__hover">
	                                <li><a href='<c:url value="/danh-sach-yeu-thich/them?productId=${productDetail.id}"/>'><i class="fa fa-heart"></i></a></li>
	                                <li><a href='<c:url value="/gio-hang/them?productId=${productDetail.id}"/>'><i class="fa fa-shopping-cart"></i></a></li>
	                            </ul>
	                        </div>
	                        <div class="featured__item__text">
	                            <h6><a href='<c:url value="/san-pham/${productRelated.id}"/>'>${productRelated.productName}</a></h6>
	                            <h5><fmt:formatNumber type="number" groupingUsed="true" value="${productRelated.price}"/> ₫</h5>
	                        </div>
	                    </div>
	                </div>
            	</c:forEach>
                
       
            </div>
        </div>
    </section>
    <!-- Related Product Section End -->

    <!-- Footer Section Begin -->
    <%@ include file="/common/client/footer.jsp" %>
    <!-- Footer Section End -->
	<script>
        // Lấy ra thẻ form
        const form = document.querySelector('.pd-tab__rev-f2');
    
        // Bắt sự kiện submit form
        form.addEventListener('submit', function(event) {
            event.preventDefault(); // Ngăn chặn hành động mặc định của form
    
            // Lấy ra giá trị được chọn của input có name="rating"
            const ratingValue = document.querySelector('input[name="rating"]:checked');
    
            // Kiểm tra xem người dùng đã chọn hay chưa
            if (ratingValue) {
                // Người dùng đã chọn, lấy giá trị rating
                const rating = ratingValue.value;
             	// Lấy ra thẻ input có name="rate"
                const rateInput = document.querySelector('input[name="rate"]');
                // Gán giá trị của biến rating cho thuộc tính value của thẻ input
                rateInput.value = rating;
                form.submit();
            } else {
                // Người dùng chưa chọn, hiển thị thông báo
                alert('Vui lòng chọn một đánh giá');
            }
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
	<!--====== Vendor Js ======-->
    <script src='<c:url value="/js/vendor.js"/>'></script>

    <!--====== jQuery Shopnav plugin ======-->
    <script src='<c:url value="/js/jquery.shopnav.js"/>'></script>

    <!--====== App ======-->
    <script src='<c:url value="/js/app.js"/>'></script>
</body>
</html>