<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.laptrinhweb.util.SecurityUtils" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết blog</title>
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

    <!-- Header Section  -->
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
    <!-- Blog Details Section Begin -->
    <section class="blog-details spad">
        <div class="container">
            <div class="row">
            	<!-- menu left -->
            	<%@ include file="/common/client/menu-left-blog.jsp" %>
                
                <div class="col-lg-8 col-md-7 order-md-1 order-1">
                    <div class="blog__details__text">
                        <img src='<c:url value="/img/blog/${blog.image}"/>' alt="">
                        <h3>${blog.title}</h3>
                        ${blog.content}
                        
                    </div>
                    <div class="blog__details__content">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="blog__details__author">
                                    <div class="blog__details__author__pic">
                                        <img src='<c:url value="/img/blog/details/details-author.jpg"/>' alt="">
                                    </div>
                                    <div class="blog__details__author__text">
                                        <h6>Michael Scofield</h6>
                                        <span>Admin</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="blog__details__widget">
                                    <ul>
                                        <li><span>Categories:</span> Food</li>
                                        <li><span>Tags:</span> All, Trending, Cooking, Healthy Food, Life Style</li>
                                    </ul>
                                    <div class="blog__details__social">
                                        <a href="#"><i class="fa fa-facebook"></i></a>
                                        <a href="#"><i class="fa fa-twitter"></i></a>
                                        <a href="#"><i class="fa fa-google-plus"></i></a>
                                        <a href="#"><i class="fa fa-linkedin"></i></a>
                                        <a href="#"><i class="fa fa-envelope"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

		    <!-- Post-Comments -->
		    <div class="blog-detail-comment u-s-m-b-50">
		        <h3 class="comment-title u-s-m-b-30">6 Comments on “Your Life is an extraordinary Adventure”</h3>
		        <ol class="comment-list">
		        	<c:forEach var="comment" items="${blog.listComment}">
		        		<li>
			                <div class="comment-body">
			                    <div class="comment-author-image">
			                        <img src='<c:url value="/img/blog/details/details-author.jpg"/>' alt="avatar image">
			                    </div>
			                    <div class="comment-content">
			                        <h3>${comment.user.fullName }</h3>
			                        <h6><fmt:formatDate type="both" value="${comment.createdDate}" /></h6>
			                        <p>${comment.content}</p>
			                        <a href="#">Phản hồi</a>
			                    </div>
			                </div>
		            	</li>
		        	</c:forEach>
		            
		        </ol>
		    </div>
		    <!-- Post-Comments /- -->
		    <!-- Post-Comment-Form -->
		    <c:if test="${SecurityUtils.getPrincipal() != null}">
			    <div class="blog-detail-post-comment u-s-m-b-25">
			        <form action='<c:url value="/binh-luan/blog"/>' method="post">
			            <div class="u-s-m-b-30">
			                <label for="your-comment">Bình luận</label>
			                <textarea class="text-area" id="your-comment" name="comment" required="required"></textarea>
			            </div>
			            <input type="hidden" name="blogId" value="${blog.id}">
			            <div class="u-s-m-b-30" style="text-align: center;">
			                <button type="submit" class="button button-outline-secondary w-50" >Gửi</button>
			            </div>
			        </form>
			    </div>
		    </c:if>
    <!-- Post-Comment-Form /- -->
       </div>
    </section>
    <!-- Blog Details Section End -->

    <!-- Related Blog Section Begin -->
    <section class="related-blog spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title related-blog-title">
                        <h2>Có thể bạn sẽ thích</h2>
                    </div>
                </div>
            </div>
            <div class="row">
            	<c:forEach var="blogMayLike" items="${blogMayLike }">
            		<div class="col-lg-4 col-md-4 col-sm-6">
	                    <div class="blog__item">
	                        <a href='<c:url value="/blogDetail/${blogMayLike.id}"/>' class="blog__item__pic"> 
	                            <img src='<c:url value="/img/blog/${blogMayLike.image}"/>' alt="">
	                        </a>
	                        <div class="blog__item__text">
	                            <ul>
	                                <li><i class="fa fa-calendar-o"></i>${blogMayLike.createdDate}</li>
	                                <li><i class="fa fa-comment-o"></i> 5</li>
	                            </ul>
	                            <h5><a href='<c:url value="/blogDetail/${blogMayLike.id}"/>'>${blogMayLike.title}</a></h5>
	                            <p>${blogMayLike.shortDescription}</p>
	                        </div>
	                    </div>
                	</div>
            	</c:forEach>
                
            </div>
        </div>
    </section>
    <!-- Related Blog Section End -->

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