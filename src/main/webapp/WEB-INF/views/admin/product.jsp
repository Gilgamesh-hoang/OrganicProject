<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="productAPI" value="/admin/api/san-pham"/>
<c:url var="home" value="/admin/trang-chu"/>
<!DOCTYPE html>
<html>
<head>
<title>Tables - Ace Admin</title>
</head>

<body class="no-skin">

	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
					</li>

					<li><a href="#">Tables</a></li>
					<li class="active">Simple &amp; Dynamic</li>
				</ul>
				<!-- /.breadcrumb -->

				<div class="nav-search" id="nav-search">
					<form class="form-search">
						<span class="input-icon"> <input type="text"
							placeholder="Search ..." class="nav-search-input"
							id="nav-search-input" autocomplete="off" /> <i
							class="ace-icon fa fa-search nav-search-icon"></i>
						</span>
					</form>
				</div>
				<!-- /.nav-search -->
			</div>

			<div class="page-content">


				<div class="page-header">
					<h1>
						Tables <small> <i
							class="ace-icon fa fa-angle-double-right"></i> Static &amp;
							Dynamic Tables
						</small>
					</h1>
				</div>
				<!-- /.page-header -->

				<div class="row">
					<div class="col-xs-12">
					<c:if test="${not empty message}">
						<div class="alert alert-${alert}">
  							${message}
						</div>
					</c:if>
					
						<div class="widget-box table-filter">
							<div class="table-btn-controls">
								<div class="pull-right tableTools-container">
									<div class="dt-buttons btn-overlap btn-group">
										<a flag="info"
											class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
											data-toggle="tooltip" title='Thêm bài viết' href="<c:url value='/admin/san-pham/them'/>"> <span>
												<i class="fa fa-plus-circle bigger-110 purple"></i>
										</span>
										</a>
										<button id="btnDelete" type="button" onclick="warningBeforeDelete()" 
											class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
											data-toggle="tooltip" title='Xóa bài viết'>
											<span> <i class="fa fa-trash-o bigger-110 pink"></i>
											</span>
										</button>
									</div>
								</div>
							</div>
						</div>
						<!-- PAGE CONTENT BEGINS -->
						<div class="row">
							<div class="col-xs-12">
								<table id="simple-table"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th class="center"  style="width: 90px;"><label class="pos-rel"> <input
													type="checkbox" class="ace" /> <span class="lbl"></span>
											</label></th>
											<th style="width: 110px;">ID</th>
											<th>Tên</th>
											<th  style="width: 190px;">Danh mục</th>
											<th  style="width: 100px;">Đã bán</th>
											<th style="width: 100px;">Còn lại</th>
											<th style="width: 150px;">Giá</th>
											<th  style="width: 150px;">Trạng thái</th>
											<th style="width: 130px;"></th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="product" items="${product.listObject}">
											<c:set var="status" value="Đang kinh doanh"/>
											<c:set var="color" value="success"/>
											<c:if test="${product.status == 0}">
												<c:set var="status" value="Ngừng kinh doanh"/>
												<c:set var="color" value="warning"/>
											</c:if>
											<tr>
												<td class="center"><label class="pos-rel"> <input
														type="checkbox" class="ace" id="checkbox_${product.id}" value="${product.id}"/> <span class="lbl"></span>
												</label></td>
												<td>${product.id}</td>
												<td>${product.productName}</td>
												<td>${product.genre.genreName}</td>
												<td>${product.sold}</td>
												<td>${product.available}</td>
												<td>${product.price}</td>
												<td><span
													class="label label-sm label-${color}">${status}</span></td>
												<td>
													<div class="hidden-sm hidden-xs btn-group">
														<a href="<c:url value='/admin/san-pham/cap-nhat?productId=${product.id}'/>" class="btn btn-xs btn-info">
															<i class="ace-icon fa fa-pencil bigger-120"></i>
														</a>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- /.span -->
						</div>
						<!-- /.row -->
						<!-- paginatation -->
						<nav aria-label="Page navigation example" style="text-align: center;">
						  <ul class="pagination" >
							<c:forEach var="index" begin="1" end="${product.totalPage}">
								<li class="page-item">
									<a class="page-link" href='<c:url value="/admin/trang-chu?page=${index}"/>'
									style='<c:if test="${index == product.page}">background-color: #007bff;color:#fff</c:if>'>${index}</a>
								</li>    
							</c:forEach>
						  </ul>
						</nav>
						<!--hết-->

						<!-- PAGE CONTENT ENDS -->
					</div>
					<!-- /.col -->
				</div>
				
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->

	<script>
	function warningBeforeDelete() {
		swal({
			  title: "Bạn có muốn xóa không?",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
		    	var ids = $('tbody input[type=checkbox]:checked').map(function () {
		            return $(this).val();
		        }).get();
			    deleteProduct(ids);
				if (willDelete) {
				  swal("Sản phẩm đã được xóa", {
				    icon: "success",
				  });
				}
			  
		});
	}
	
	function deleteProduct(ids) {
		$.ajax({
			type:'DELETE',
			url:'${productAPI}',
			contentType:'application/json',
			data: JSON.stringify(ids),
			success: function(result) {
				window.location.href = "${home}?page=1";
			},
			error: function(error) {
				window.location.href = "${home}?page=1";
			}
		});
	}
	
	
	</script>
</body>
</html>