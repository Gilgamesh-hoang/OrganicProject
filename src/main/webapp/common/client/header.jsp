<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.laptrinhweb.util.SecurityUtils" %>
 <%@include file="/common/taglib.jsp"%>
 <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                                <li>Free Shipping for all Order of $99</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                            <div class="header__top__right__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                <a href="#"><i class="fa fa-pinterest-p"></i></a>
                            </div>
                            
                            <security:authorize access = "isAnonymous()">
                            	<div class="header__top__right__auth">
	                                <a href='<c:url value="/dang-nhap"/>'><i class="fa fa-user"></i>Đăng nhập</a>
	                            </div>
                            </security:authorize>
                            <security:authorize access = "isAuthenticated()">
                            	<div class="header__top__right__auth mt-right-20">
                                	<a href='<c:url value="/thong-tin-tai-khoan"/>'><i class="fa fa-user-circle-o"></i>${SecurityUtils.getPrincipal().fullName}</a>
	                            </div>
	                            <div class="header__top__right__auth">
	                                <a href='<c:url value="/dang-xuat"/>'><i class="fa fa-sign-out"></i>Đăng xuất</a>
	                            </div>
                            </security:authorize>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href='<c:url value="/trang-chu"/>'><img src="img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href='<c:url value="/trang-chu"/>'>Trang chủ</a></li>
                            <li><a href='<c:url value="/blog?categoryId=0"/>'>Blog</a></li>
                            <li><a href='<c:url value="/lien-he"/>'>Liên hệ</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href='<c:url value="/danh-sach-yeu-thich"/>'><i class="fa fa-heart"></i> <span>${wishlist.products.size()}</span></a></li>
                            <li><a href='<c:url value="/gio-hang"/>'><i class="fa fa-shopping-bag"></i> <span>${cart.totalQuantity}</span></a></li>
                        </ul>
                        <div class="header__cart__price">item: <span><fmt:formatNumber type="number" groupingUsed="true" value="${cart.totalPrice}"/> ₫</span></div>
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header> 
    
    