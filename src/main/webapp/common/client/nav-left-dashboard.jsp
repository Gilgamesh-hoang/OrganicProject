<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-lg-3 col-md-12">

	<!--====== Dashboard Features ======-->
	<div class="dash__box dash__box--bg-white dash__box--shadow u-s-m-b-30">
		<div class="dash__pad-1">

			
			<ul class="dash__f-list">
				<li><a class="dash-active" href='<c:url value="/thong-tin-tai-khoan"/>'>Quản lý tài khoản</a></li>
				<li><a href='<c:url value="/thong-tin-cua-toi"/>'>Thông tin của tôi</a></li>
				<li><a href='<c:url value="/dia-chi"/>'>Sổ địa chỉ</a></li>

			</ul>
		</div>
	</div>
	<div
		class="dash__box dash__box--bg-white dash__box--shadow dash__box--w">
		<div class="dash__pad-1">
			<ul class="dash__w-list">
				<li>
					<div class="dash__w-wrap">

						<span class="dash__w-icon dash__w-icon-style-1"><i
							class="fa fa-cart-arrow-down"></i></span> <span class="dash__w-text">${listOrder.size()}</span>

						<span class="dash__w-name">Đơn mua</span>
					</div>
				</li>
				<li>
					<div class="dash__w-wrap">

						<span class="dash__w-icon dash__w-icon-style-2"><i
							class="fa fa-times"></i></span> <span class="dash__w-text">0</span> <span
							class="dash__w-name">Hủy đơn hàng</span>
					</div>
				</li>
				<li>
					<div class="dash__w-wrap">

						<span class="dash__w-icon dash__w-icon-style-3"><i
							class="fa fa-heart"></i></span> <span class="dash__w-text">${numberProductLike}</span> <span
							class="dash__w-name">Đã thích</span>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<!--====== End - Dashboard Features ======-->
</div>