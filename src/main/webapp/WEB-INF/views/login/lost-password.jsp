<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:if test="${param.incorrect != null}">
	<c:set var="alert" value="danger"/>
	<c:set var="msg" value="<strong>Đặt lại mật khẩu không thành công.</strong> Email hoặc tên đăng nhập không đúng, vui lòng kiểm tra lại."/>
</c:if>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Quên mật khẩu</title>
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
                              <h1 class="section__heading u-c-secondary">QUÊN MẬT KHẨU?</h1>
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
									<h1 class="gl-h1">ĐẶT LẠI MẬT KHẨU</h1>
									<c:if test="${param.incorrect != null}">
										<div class="alert alert-${alert} alert-dismissible fade show"
											role="alert">
											${msg}
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
									</c:if>
									<span class="gl-text u-s-m-b-30">Nhập vào tên đăng nhập
										và email của bạn vào bên dưới, chúng tôi sẽ gửi cho bạn mật
										khẩu đã được đặt lại!</span>
									<form class="l-f-o__form" method="post" action='<c:url value="/quen-mat-khau" />'>
                                      <div class="u-s-m-b-30">
                                          <label class="gl-label" for="reset-username">Tên đăng nhập *</label>
                                          <input name="username" class="input-text input-text--primary-style" type="text" id="reset-username" placeholder="Nhập tên đăng nhập" required="required"></div>
                                      <div class="u-s-m-b-30">
                                          <label class="gl-label" for="reset-email">E-Mail *</label>
                                          <input name="email" class="input-text input-text--primary-style" type="email" id="reset-email" placeholder="Nhập E-mail" required="required"></div>
                                      <div class="u-s-m-b-30">
                                          <button class="btn btn--e-transparent-brand-b-2" type="submit">Gửi</button></div>
                                      <div class="u-s-m-b-30">
                                          <a class="gl-link" href='<c:url value="/dang-nhap" />'>Quay lại đăng nhập</a></div>
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