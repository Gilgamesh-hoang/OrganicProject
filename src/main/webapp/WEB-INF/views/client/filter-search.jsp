<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tìm kiếm</title>

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
	<!-- <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> -->

	<!-- Css Styles -->
    <link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/elegant-icons.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/nice-select.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/jquery-ui.min.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/owl.carousel.min.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/slicknav.min.css"/>' >
    <link rel="stylesheet" href='<c:url value="/css/style.css"/>' >
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Font Awesome 5 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet">
    <!-- Jquery-Ui-Range-Slider -->
    <link rel="stylesheet" href='<c:url value="/css/jquery-ui-range-slider.min.css"/>'> 
    <!-- Main -->
    <link rel="stylesheet" href='<c:url value="/css/bundle.css"/>'>

</head>

<body>
<% 


%>

<!-- app -->
<div id="app">
    <!-- Header -->
    <%@ include file="/common/client/header.jsp" %>
    <!-- Header /- -->
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
    <!-- Shop-Page -->
    <div class="page-shop u-s-p-t-80">
        <div class="container">
            
            <!-- Shop-Intro /- -->
            <div class="row">
                <!-- Shop-Left-Side-Bar-Wrapper -->
                <div class="col-lg-3 col-md-3 col-sm-12">
                    <!-- Fetch-Categories-from-Root-Category  -->
                    <div class="fetch-categories">
                        <h3 class="title-name">Danh mục</h3>
                        
                        <!-- Level 3 -->
                        <ul>
                        	<c:forEach var="genre" items="${genresFilter}">                        	
	                            <li><a href='<c:url value="/danh-muc?genreId=${genre.id}"/>'>${genre.genreName}<span class="total-fetch-items">(${genre.numberProduct})</span></a></li>
                        	</c:forEach>
   
                        </ul>
                        <!-- //end Level 3 -->
                    
                    </div>
       
                    <div class="fetch-categories">
                        <h3 class="title-name">Thương hiệu</h3>
                        
                        <!-- Level 3 -->
                        <ul>
                            <c:forEach var="manufacturer" items="${manufacturersFilter}">                        	
	                            <li><a href='<c:url value="/thuong-hieu?manufacturerId=${manufacturer.id}"/>'>${manufacturer.manufacturerName}<span class="total-fetch-items">(${manufacturer.numberProduct})</span></a></li>
                        	</c:forEach>
                        </ul>
                        <!-- //end Level 3 -->
                    
                    </div>
                    <!-- Filters /- -->
                </div>
                <!-- Shop-Left-Side-Bar-Wrapper /- -->
                <!-- Shop-Right-Wrapper -->
                <div class="col-lg-9 col-md-9 col-sm-12">
                    <!-- Page-Bar -->
                    <div class="page-bar clearfix">
                        <div class="shop-settings">
                             <p>Tìm kiếm theo</p> 
                            
                        </div>
                        <!-- Toolbar Sorter 1  -->
                        <form method="get" action='<c:url value="${url}"/>'>
                         <div class="toolbar-sorter">
                            <div class="select-box-wrapper">
                                <label class="sr-only" for="sort-by">Sắp xếp</label>
                                <select class="select-box" name="sortBy">
                                    <option selected="selected" value="1">Giá tăng dần</option>
                                    <option value="2">Giá giảm dần</option>
                                    <option value="3">Mới nhất</option>
                                    <option value="4">Cũ nhất</option>
                                </select>
                                <button type="submit" class="btn">Lọc</button>
                            </div>
                        </div> 
                        </form>
                        <!-- //end Toolbar Sorter 1  -->
                        
                    </div>
                    <!-- Page-Bar /- -->
                    <!-- Row-of-Product-Container -->
                    <div class="row product-container list-style">
                        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-md-2 justify-content-left"> 
                        	<c:forEach var="product" items="${productsFilter.listObject}">
                        		<div class="col mb-5">
	                                <div class="card h-100">
	                                    <!-- Sale badge-->
	                                    <!-- <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div> -->
	                                    <!-- Product image-->
	                                    <a href='<c:url value="/san-pham?id=${product.id}"/>'><img class="card-img-top" src='<c:url value="/img/product/${product.image}"/>' alt="Ảnh sản phẩm" /></a>
	                                    <!-- Product details-->
	                                    <div class="card-body p-4">
	                                        <div class="text-center">
	                                            <!-- Product name-->
	                                            <a href='<c:url value="/san-pham?id=${product.id}"/>' class="fw-bolder">${product.productName}</a>
	                                            <!-- Product reviews-->
	                                            <div class="d-flex justify-content-center small text-warning mb-2">
	                                                <div class="bi-star-fill"></div>
	                                                <div class="bi-star-fill"></div>
	                                                <div class="bi-star-fill"></div>
	                                                <div class="bi-star-fill"></div>
	                                                <div class="bi-star-fill"></div>
	                                            </div>
	                                            <!-- Product price-->
	                                            <span class="text-muted text-decoration-line-through"><fmt:formatNumber type="number" groupingUsed="true" value="${product.price}"/> ₫</span>
	                                           
	                                        </div>
	                                    </div>
	                                    <!-- Product actions-->
	                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href='<c:url value="/gio-hang/them?productId=${product.id}"/>'>Thêm vào giỏ</a></div>
	                                    </div>
	                                </div>
                            	</div>
                        	</c:forEach>
                            
                        </div>
                    </div>
                    <!-- Row-of-Product-Container /- -->
               		<!-- paginatation -->
                    <nav aria-label="Page navigation example">
				  		<ul class="pagination justify-content-center">
				  			<c:if test="${search != null}">
				  				<c:forEach var="index" begin="1" end="${productsFilter.totalPage}">
									<li class="page-item">
										<a class="page-link" href='<c:url value="${url}&page=${index}"/>' 
										style='<c:if test="${index == productsFilter.page}">background-color: #a6ce38;color:#fff</c:if>'>${index}</a>
									</li>
								</c:forEach>
				  			</c:if>
				  			<c:if test="${search == null}">
				  				<c:forEach var="index" begin="1" end="${productsFilter.totalPage}">
									<li class="page-item">
										<a class="page-link" href='<c:url value="${url}&page=${index}"/>' 
										style='<c:if test="${index == productsFilter.page}">background-color: #a6ce38;color:#fff</c:if>'>${index}</a>
									</li>
								</c:forEach>	
				  			</c:if>
						
				  		</ul>
					</nav>               
                    
                </div>
                <!-- Shop-Right-Wrapper /- -->
		      
            </div>
        </div>
              
    </div>
    
    <!-- Shop-Page /- -->
    <!-- Footer -->
    <%@ include file="/common/client/footer.jsp" %>
    <!-- Footer /- -->
</div>




	<!-- jQuery -->
	<script type="text/javascript" src='<c:url value="/js/jquery.min.js"/>'></script>
	<!-- jquery-ui-range-slider -->
	<script type="text/javascript" src='<c:url value="/js/jquery-ui.range-slider.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/js/app.js"/>'></script>
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