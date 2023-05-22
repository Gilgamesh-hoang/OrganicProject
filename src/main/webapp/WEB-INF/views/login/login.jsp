<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:if test="${param.success != null}">
	<c:set var="alert" value="success"/>
	<c:set var="msg" value="<strong>Bạn đã đăng kí thành công.</strong> Vui lòng kiểm tra email để kích hoạt tài khoản."/>
</c:if>
<c:if test="${param.incorrectAccount != null}">
	<c:set var="alert" value="danger"/>
	<c:set var="msg" value="<strong>Đăng nhập thất bại.</strong> Tài khoản hoặc mật khẩu không đúng, vui lòng kiểm tra lại."/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>

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
    
    
              <!--====== Section Content ======-->
             <div class="section__content">
                 <div class="container">
                     <div class="row row--center">
                         <div class="col-lg-6 col-md-8 u-s-m-b-30">
                             <div class="l-f-o">
                                 <div class="l-f-o__pad-box">
                                 	<!-- nếu vừa đăng kí thành công thì hiển thị ra thông báo này hoặc đăng nhập thất bại -->
                                 	<c:if test="${param.incorrectAccount != null || param.success != null}">
						                <div class="alert alert-${alert} alert-dismissible fade show" role="alert">
										  ${msg}
										  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
										    <span aria-hidden="true">&times;</span>
										  </button>
										</div>
                                 	</c:if>
                                     <h1 class="gl-h1">Bạn là khách hàng mới?</h1>

                                     <span class="gl-text u-s-m-b-30">Bằng cách tạo tài khoản với cửa hàng của chúng tôi, bạn sẽ có thể chuyển qua quy trình thanh toán nhanh hơn, lưu trữ địa chỉ giao hàng, xem và theo dõi đơn hàng trong tài khoản của bạn.</span>
                                     <div class="u-s-m-b-15">

                                         <a class="l-f-o__create-link btn--e-transparent-brand-b-2" href='<c:url value="/dang-ky" />'>Đăng ký tài khoản</a></div>
                                     <h1 class="gl-h1">ĐĂNG NHẬP</h1>

                                     <span class="gl-text u-s-m-b-30">Nếu bạn đã có tài khoản, vui lòng đăng nhập.</span>
                                     <form class="l-f-o__form" action="j_spring_security_check" method="post">
                                         <div class="gl-s-api">
                                             <div class="u-s-m-b-15">

                                                 <button class="gl-s-api__btn gl-s-api__btn--fb" type="button"><i class="fa fa-facebook"></i>

                                                     <span>Đăng nhập với Facebook</span></button></div>
                                             <div class="u-s-m-b-15">

                                                 <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/Organi/login-google&response_type=code
 															&client_id=962062893818-gvp7bp2rgclufevrqdhhgsppivjouive.apps.googleusercontent.com&approval_prompt=force" class="gl-s-api__btn gl-s-api__btn--gplus"><i class="fa fa-google"></i>

                                                     <span>Đăng nhập với Google</span></a></div>
                                         </div>
                                         <div class="u-s-m-b-30">

                                             <label class="gl-label" for="login-email">Tên đăng nhập *</label>

                                             <input class="input-text input-text--primary-style" name="j_username" type="text" id="login-email" placeholder="Enter E-mail" required="required"></div>
                                         <div class="u-s-m-b-30">

                                             <label class="gl-label" for="login-password">Mật khẩu *</label>

                                             <input class="input-text input-text--primary-style" name="j_password"  type="password" id="login-password" placeholder="Enter Password" required="required"></div>
                                         <div class="gl-inline">
                                             <div class="u-s-m-b-30">

                                                 <button class="btn btn--e-transparent-brand-b-2" type="submit">ĐĂNG NHẬP</button></div>
                                             <div class="u-s-m-b-30">

                                                 <a class="gl-link" href='<c:url value="/lost-password" />'>Quên mật khẩu?</a></div>
                                         </div>
                                         <div class="u-s-m-b-30">

                                             <!--====== Check Box ======-->
                                             <div class="check-box">

                                                 <input type="checkbox" id="remember-me" name="remember-me">
                                                 <div class="check-box__state check-box__state--primary">

                                                     <label class="check-box__label" for="remember-me">Nhớ mật khẩu</label></div>
                                             </div>
                                             <!--====== End - Check Box ======-->
                                         </div>
                                     </form>
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