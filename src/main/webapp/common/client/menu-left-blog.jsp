<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-lg-4 col-md-5">
                    <div class="blog__sidebar">
                        <div class="blog__sidebar__search">
                            <form action='<c:url value="/tim-kiem-blog"/>' method="get">
                                <input type="text" placeholder="Tìm kiếm bài viết" name="keyword" value="${keyword}">
                                <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                            </form>
                        </div>
                        <div class="blog__sidebar__item">
                            <h4>Thể loại</h4>
                            <ul>
                                <li><a href='<c:url value="/blog?categoryId=0"/>'>Tất cả (${countAllBlog})</a></li>
                                <c:forEach var="category" items="${categoryBlog}">
	                                <li><a href='<c:url value="/blog?categoryId=${category.id}"/>'>${category.categoryName} (${category.numberBlog})</a></li>
                                </c:forEach>
                                
                            </ul>
                        </div>
                        <div class="blog__sidebar__item">
                            <h4>Bài viết mới</h4>
                            <div class="blog__sidebar__recent">
                            	<c:forEach var="newBlog" items="${newBlog}">
                                	<a href='<c:url value="/blogDetail/${newBlog.id}" />' class="blog__sidebar__recent__item">
	                                    <div class="blog__sidebar__recent__item__pic">
	                                        <img class="pic" src='<c:url value="/img/blog/${newBlog.image}" />' alt="">
	                                    </div>
	                                    <div class="blog__sidebar__recent__item__text">
	                                        <h6>${newBlog.title}</h6>
	                                        <span>${newBlog.createdDate}</span>
	                                    </div>
                                	</a>
                                
                                </c:forEach>
                                
                            </div>
                        </div>
                        
                    </div>
                </div>