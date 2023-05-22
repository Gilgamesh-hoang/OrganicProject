<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="hero__search">
	<div class="hero__search__form">
		<form action='<c:url value="/tim-kiem-san-pham"/>' method="get">
			<input type="text" id="search" placeholder="Bạn đang tìm kiếm gì?" name="keyword" value="${search}">
			<button type="submit" class="site-btn"><i class="fa fa-search" aria-hidden="true"></i></button>
		</form>
	</div>
	<div class="hero__search__phone">
		<div class="hero__search__phone__icon">
			<i class="fa fa-phone"></i>
		</div>
		<div class="hero__search__phone__text">
			<h5>+65 11.188.888</h5>
			<span>support 24/7 time</span>
		</div>
	</div>
</div>