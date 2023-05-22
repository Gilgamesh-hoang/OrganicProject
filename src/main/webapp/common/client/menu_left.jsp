<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<div class="col-lg-3">
	<div class="hero__categories">
		<div class="hero__categories__all">
			<i class="fa fa-bars"></i> <span>Danh mục</span>  <i
				class="fa fa-caret-down caret-down"></i> 
		</div>
		<ul>
			<c:forEach var="genre" items="${genres}">
				<li><a href='<c:url value="/danh-muc?genreId=${genre.id}"/>'>${genre.genreName}</a></li>		
			</c:forEach>
			
		</ul>
	</div>
</div>