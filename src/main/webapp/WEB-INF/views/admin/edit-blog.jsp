<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="blogPage" value="/admin/blog" />
<c:url var="editBlogURL" value="/admin/blog/cap-nhat" />
<c:url var="blogAPI" value="/admin/api/blog" />
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
            <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="blog">
			<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right">Thể loại:</label>
					<div class="col-sm-9">
						<form:select path="category.id" id="category">
						    <form:options items="${categories}" itemValue="id" itemLabel="categoryName" />
						</form:select>
					</div>
			  </div>
              <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tiêu đề</label>
                <div class="col-sm-9">
                  	<form:input path="title" cssClass="col-xs-10 col-sm-5"  required="required"/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1">Ảnh</label>
                <div class="col-sm-9">
                  <form:input path="image" cssClass="col-xs-10 col-sm-5"  required="required"/>
                </div>
              </div>
              <div class="form-group">
                <label for="content" class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                <div class="col-sm-9">
                  	<form:textarea  path="shortDescription" id="shortDescription"  cssClass="form-control"  required="required"/>
                </div>
              </div>
              <div class="form-group">
                <label for="content" class="col-sm-3 control-label no-padding-right">Nội dung:</label>
                <div class="col-sm-9">
                  	<form:textarea  path="content" id="content"  cssClass="form-control"  required="required"/>
                </div>
              </div>
             	<form:hidden path="id" id="blogId" />	
              <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                	<c:if test="${blog.id != 0}">
	                	<button class="btn btn-info" type="button" id="btnAddOrUpdateBlog">
	                      <i class="ace-icon fa fa-check bigger-110"></i> Cập nhật sản phẩm
	                    </button>
                	</c:if>
                  <c:if test="${blog.id == 0}">
                    <button class="btn btn-info" type="button" id="btnAddOrUpdateBlog">
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
	 var editor1 = '';
		$(document).ready(function(){
			editor1 = CKEDITOR.replace( 'content');
	});
	 var editor2 = '';
		$(document).ready(function(){
			editor2 = CKEDITOR.replace( 'shortDescription');
	});

	$("#btnAddOrUpdateBlog").click(function (e) {
		e.preventDefault();
		var blogId = $("#blogId").val();
	    var categoryId = $("#category").val();
		var data = {};
		var formData = $("#formSubmit").serializeArray();
		$.each(formData, function(i,v) {
			data[""+v.name+""]= v.value;
		});
	    data["category"] = { "id": categoryId };
	    data["content"] = editor1.getData();
	    data["shortDescription"] = editor2.getData();
		 if(blogId == 0) {
			 addBlog(data);
		}else {
			updateBlog(data, blogId);
		} 
		
	});
	function addBlog(data) {
		$.ajax({
			type: 'POST',
			url: '${blogAPI}',
			contentType: "application/json",
			data: JSON.stringify(data),
			dataType: 'json',
			success: function (result) {
				window.location.href="${blogPage}?message=insert_success";
			},
			error: function(error) {
				window.location.href="${blogPage}?message=error_system";
			}
		});
	}
	function updateBlog(data, blogId) {
		$.ajax({
			type: 'PUT',
			url: '${blogAPI}',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function (result) {
				window.location.href="${blogPage}?message=update_success";
			},
			error: function(error) {
				window.location.href="${editBlogURL}?blogId="+blogId+"&message=error_system";
			}
		});
	}
	
</script>
</body>
</html>