<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Đăng ký tài khoản</title>
	<!-- Google Font -->
     <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
     <!--====== Utility-Spacing ======-->
     <link rel="stylesheet" href='<c:url value="/css/utility.css"/>'>
     <!--====== App ======-->
     <link rel="stylesheet" href='<c:url value="/css/app.css"/>'>
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
<body class="config">
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!--====== Main App ======-->
    <div id="app">

        <!--====== Main Header ======-->
        <%@ include file="/common/client/header.jsp" %>

        <!--====== End - Main Header ======-->
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


        <!--====== App Content ======-->
        <div class="app-content">

            <!--====== Section 2 ======-->
            <div class="u-s-p-b-60">

                <!--====== Section Intro ======-->
                <div class="section__intro u-s-m-b-60">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="section__text-wrap">
                                    <h1 class="section__heading u-c-secondary">TẠO TÀI KHOẢN</h1>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Intro ======-->

                <!--====== Section Content ======-->
                <div class="section__content">
                    <div class="container">
                        <div class="row row--center">
                            <div class="col-lg-6 col-md-8 u-s-m-b-30">
                                <div class="l-f-o">
                                    <div class="l-f-o__pad-box">
	                                    <!-- nếu đăng kí thất bại thì hiển thị ra thông báo này -->
	                                 	<c:if test="${param.accountExisted != null}">
	                                       <div class="alert alert-danger alert-dismissible fade show" role="alert">
											  <strong>Đăng ký thất bại</strong>. Tên đăng nhập đã tồn tại, vui lòng dùng tên đăng nhập khác.
											  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
											    <span aria-hidden="true">&times;</span>
											  </button>
											</div>
							             </c:if>            
                                        <form:form method="POST" action="dang-ky" modelAttribute="user" cssClass="form-l-f-o__form" onsubmit="return validateForm()" name="myForm">
                                            <div class="gl-s-api">
                                                <div class="u-s-m-b-15">

                                                    <button class="gl-s-api__btn gl-s-api__btn--fb" type="button"><i class="fa fa-facebook" ></i>

                                                        <span>Đăng kí với Facebook</span></button></div>
                                                <div class="u-s-m-b-30">

                                                    <button class="gl-s-api__btn gl-s-api__btn--gplus" type="button"><i class="fa fa-google"></i>
                                                        <span>Đăng kí với Google</span></button></div>
                                            </div>
                                            <div class="u-s-m-b-30">

                                                <label class="gl-label" >Họ tên *</label>

                                                <form:input class="input-text input-text--primary-style" path="fullName" type="text"  placeholder="Nhập vào họ và tên" required="required"/></div>
                                            <div class="u-s-m-b-30">

                                                <label class="gl-label" >Số điện thoại</label>

                                                <form:input class="input-text input-text--primary-style" path="phoneNumber" type="text"  placeholder="Nhập vào số điện thoại"  required="required"/></div>
                                            <div class="u-s-m-b-30">

                                                <label class="gl-label" >Địa chỉ</label>
    
                                                 <form:input class="input-text input-text--primary-style" path="address" type="text"  placeholder="Nhập vào địa chỉ"  required="required"/></div>
                                                
                                            <div class="u-s-m-b-30">

                                                <label class="gl-label" >E-mail *</label>

                                                <form:input class="input-text input-text--primary-style" path="email" type="email"  placeholder="Nhập vào e-mail" required="required"/></div>
                                            <div class="u-s-m-b-30">

                                                <label class="gl-label" >Tên đăng nhập *</label>
    
                                                <form:input class="input-text input-text--primary-style" path="userName" type="text"  placeholder="Nhập vào tên đăng nhập" required="required"/></div>
                                                
                                            <div class="u-s-m-b-30">

                                                <label class="gl-label" >Mật khẩu *</label>

                                                <form:input class="input-text input-text--primary-style" path="password" type="password" placeholder="Nhập vào mật khẩu" required="required"/></div>
                                            <div class="u-s-m-b-30">

                                                <label class="gl-label" >Nhập lại mật khẩu *</label>
    
                                                <form:input class="input-text input-text--primary-style" path="confirmPassword" type="password"  placeholder="Nhập lại mật khẩu bên trên" required="required"/></div>
                                                
                                            <div class="u-s-m-b-15">

                                                <button class="btn btn--e-transparent-brand-b-2" type="submit">Đăng ký</button></div>

                                            <a class="gl-link" href="#">Quay lại cửa hàng</a>
                                        </form:form>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====== End - Section Content ======-->
            </div>
            <!--====== End - Section 2 ======-->
        </div>
        <!--====== End - App Content ======-->


        <!--====== Main Footer ======-->
        <%@ include file="/common/client/footer.jsp" %>
    </div>
    <!--====== End - Main App ======-->

	
	<script>
		function validateForm() {
		    var password = document.forms["myForm"]["password"].value;
		    var confirmPassword = document.forms["myForm"]["confirmPassword"].value;
		    if (password != confirmPassword) {
		        alert("Mật khẩu xác nhận không khớp!");
		        return false;
		    }
		}
	</script>



    <!--====== Vendor Js ======-->
    <script src='<c:url value="/js/vendor.js"/>'></script>
    <!--====== jQuery Shopnav plugin ======-->
    <script src='<c:url value="/js/jquery.shopnav.js"/>'></script>
    <!--====== App ======-->
    <script src='<c:url value="/js/app.js"/>'></script>
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