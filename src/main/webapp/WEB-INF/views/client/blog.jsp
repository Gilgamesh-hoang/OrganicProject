<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blog</title>
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
	
	<%@ include file="/common/client/header.jsp" %>

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
                        <h2>Blog</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Blog</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Blog Section Begin -->
    <section class="blog spad">
        <div class="container">
            <div class="row">
            	<!-- menu left -->
            	<%@ include file="/common/client/menu-left-blog.jsp" %>
            	
               
                <div class="col-lg-8 col-md-7">
                    <div class="row">
                    	<c:forEach var="blog" items="${blogs.listObject}">
	                    	<div class="col-lg-6 col-md-6 col-sm-6">
	                            <div class="blog__item">
	                                <div class="blog__item__pic">
	                                    <img src='<c:url value="img/blog/${blog.image}" />' alt="">
	                                </div>
	                                <div class="blog__item__text">
	                                    <ul>
	                                        <li><i class="fa fa-calendar-o"></i> ${blog.createdDate}</li>
	                                        <li><i class="fa fa-comment-o"></i> 5</li>
	                                    </ul>
	                                    <h5><a href='<c:url value="/blogDetail/${blog.id}"/>'>${blog.title}</a></h5>
	                                    <p>${blog.shortDescription}</p>
	                                    <a href='<c:url value="/blogDetail/${blog.id}"/>' class="blog__btn">Đọc thêm <span class="arrow_right"><i class="fa fa-arrow-right" aria-hidden="true"></i></span></a>
	                                </div>
	                            </div>
	                        </div>
                    	</c:forEach>
                        
                        <!-- paginable -->
                        <div class="col-lg-12">
                            <div class="product__pagination blog__pagination">
                            	<c:forEach var="index" begin="1" end="${blogs.totalPage}">
                                	<a href='<c:url value="${url}&page=${index}"/>' style='<c:if test="${index == blogs.page}">background-color: #a6ce38;color:#fff</c:if>'>${index}</a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                
                
            </div>
        </div>
    </section>
    <!-- Blog Section End -->

    <!-- Footer Section Begin -->
    <%@ include file="/common/client/footer.jsp" %>
    <!-- Footer Section End -->


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