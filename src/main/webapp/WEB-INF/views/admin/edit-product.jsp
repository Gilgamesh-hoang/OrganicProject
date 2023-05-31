<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="home" value="/admin/trang-chu" />
<c:url var="editProductURL" value="/admin/san-pham/cap-nhat" />
<c:url var="productAPI" value="/admin/api/san-pham" />
<html>
<head>
<title>Chỉnh sửa bài viết</title>
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

          <li><a href="#">Forms</a></li>
          <li class="active">Form Elements</li>
        </ul>
        <!-- /.breadcrumb -->
      </div>
      <div class="page-content">
        <div class="row">
          <div class="col-xs-12">
          	<c:if test="${not empty message}">
				<div class="alert alert-${alert}">${message}</div>
			</c:if>
            <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="product">
              <div class="form-group">
					<label class="col-sm-3 control-label no-padding-right">Danh mục:</label>
					<div class="col-sm-9">
						<form:select path="genre.id" id="genre">
						    <form:options items="${genres}" itemValue="id" itemLabel="genreName" />
						</form:select>
					</div>
			  </div>
			<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right">Nhà sản xuất:</label>
					<div class="col-sm-9">
						<form:select path="manufacturer.id" id="manufacturer">
						    <form:options items="${manufacturers}" itemValue="id" itemLabel="manufacturerName" />
						</form:select>
					</div>
			  </div>
              <div class="form-group">
					<label class="col-sm-3 control-label no-padding-right">Trạng thái:</label>
					<div class="col-sm-9">
						<form:select path="status" id="status">
							<form:option value="1" label="Đang kinh doanh"/>
							<form:option value="0" label="Ngừng kinh doanh"/>
						</form:select>
					</div>
			  </div>
              <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tên sản phẩm</label>
                <div class="col-sm-9">
                  	<form:input path="productName" cssClass="col-xs-10 col-sm-5"  required="required"/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Ảnh</label>
                <div class="col-sm-9">
                 <form:input path="image" cssClass="col-xs-10 col-sm-5"  required="required"/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Số lượng</label>
                <div class="col-sm-9">
                  <form:input path="available" cssClass="col-xs-10 col-sm-5"  required="required"/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Giảm giá</label>
                <div class="col-sm-9">
                  <form:input path="discount" cssClass="col-xs-10 col-sm-5"  required="required"/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Giá bán (VNĐ)</label>
                <div class="col-sm-9">
                  <form:input path="price" cssClass="col-xs-10 col-sm-5"  required="required"/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Trọng lượng (Kg)</label>
                <div class="col-sm-9">
                  <form:input path="weight" cssClass="col-xs-10 col-sm-5" required="required" />
                </div>
              </div>
             
              <div class="form-group">
                <label for="content" class="col-sm-3 control-label no-padding-right">Mô tả:</label>
                <div class="col-sm-9">
                  	<form:textarea  path="description" id="description"  cssClass="form-control"  required="required"/>
                </div>
              </div>
             	<form:hidden path="id" id="productId" />	
              <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                  <c:if test="${product.id != 0}">
                    <button class="btn btn-info" type="button" id="btnAddOrUpdateProduct">
                      <i class="ace-icon fa fa-check bigger-110"></i> Cập nhật sản phẩm
                    </button>
                  </c:if>
                  <c:if test="${product.id == 0}">
                    <button class="btn btn-info" type="button" id="btnAddOrUpdateProduct">
                      <i class="ace-icon fa fa-check bigger-110"></i> Thêm sản phẩm
                    </button>
                  </c:if>

                  &nbsp; &nbsp; &nbsp;
                  <button class="btn" type="reset">
                    <i class="ace-icon fa fa-undo bigger-110"></i> Hủy
                  </button>
                </div>
              </div>
            </form:form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script>
	  /* ClassicEditor
		  .create( document.querySelector( '#editor' ) )
		  .catch( error => {
		      console.error( error );
	  } ); */
	 var editor = '';
		$(document).ready(function(){
			editor = CKEDITOR.replace( 'description');
	});
  
	$("#btnAddOrUpdateProduct").click(function (e) {
		e.preventDefault();
		var id = $("#productId").val();
	    var genreId = $("#genre").val();
	    var manufacturerId = $("#manufacturer").val();
		var data = {};
		var formData = $("#formSubmit").serializeArray();
		$.each(formData, function(i,v) {
			data[""+v.name+""]= v.value;
		});
	    data["genre"] = { "id": genreId };
	    data["manufacturer"] = { "id": manufacturerId };
	    data["description"] = editor.getData();
		 if(id == 0) {
			 addProduct(data);
		}else {
			updateProduct(data, id);
		} 
		
	});
	function addProduct(data) {
		$.ajax({
			type: 'POST',
			url: '${productAPI}',
			contentType: "application/json",
			data: JSON.stringify(data),
			dataType: 'json',
			success: function (result) {
				window.location.href="${home}?page=1&message=insert_success";
			},
			error: function(error) {
				window.location.href="${home}?page=1&message=error_system";
			}
		});
	}
  	function updateProduct(data, id) {
		$.ajax({
			type: 'PUT',
			url: '${productAPI}',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function (result) {
				window.location.href="${home}?page=1&message=update_success";
			},
			error: function(error) {
				window.location.href="${editProductURL}?id="+id+"&message=error_system";
			}
		});
	}
  	
  </script>


  
</body>
</html>