<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="./CheckAccount.jsp"%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />

<div class="content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<article class="col-sm-9">
				<div class="card" style="margin-top: 5px;">
					<div class="card-header" style="font-size: 25px;">Chỉnh sửa
						sản phẩm</div>
					<form action="${pageContext.request.contextPath}/EditProduct"
						method="post" enctype="multipart/form-data">
						<input type="hidden" name="id" value=${PRODUCT.id }>
						<div class="row" style="margin: 5px;">
							<div class="form-group col-sm-6">
								<label style="font-size: 16px;" for="">Tên Truyện</label> <input
									type="text" class="form-control" placeholder="Tên Truyện"
									name="name" required="required" style="font-size: 16px;"
									value="${PRODUCT.name }">
							</div>
							<div class="form-group col-sm-6">
								<label for="" style="font-size: 16px;">Tác Giả</label> <input
									type="text" name="author" style="font-size: 16px;"
									value="${PRODUCT.author }" class="form-control"
									placeholder="Tác Giả" required="required">
							</div>
						</div>
						<div class="row" style="margin: 5px;">
							<div class="form-group col-sm-6">
								<label for="" style="font-size: 16px;">Thể Loại</label> <select
									name="category" id="" class="form-control">
									<c:forEach var="cate" items="${LIST_CATE }">
										<option value="${cate.id }">${cate.name }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-sm-6">
								<label for="" style="font-size: 16px;">Nhà Xuất Bản</label> <input
									type="text" name="publisher" style="font-size: 16px;"
									class="form-control" placeholder="Nhà Xuất Bản"
									value="${PRODUCT.publisher }" required="required">
							</div>
						</div>
						<div class="row" style="margin: 5px;">
							<div class="form-group col-sm-6">
								<label for="" style="font-size: 16px;">Số lượng</label> <input
									type="number" name="quantity" style="font-size: 16px;"
									class="form-control" placeholder="Số lượng" required="required"
									value="${PRODUCT.quantity }">
							</div>
							<div class="form-group col-sm-6">
								<label for="" style="font-size: 16px;">Giá </label> <input
									type="number" style="font-size: 16px;" name="price"
									value="${PRODUCT.price }" class="form-control"
									placeholder="Giá" required="required">
							</div>
						</div>
						<div class="row" style="margin: 5px;">
							<div class="form-group col-sm-6">
								<label for="" style="font-size: 16px;">Sale</label> <input
									type="number" style="font-size: 16px;" name="sale"
									value="${PRODUCT.sale }" class="form-control"
									placeholder="Sale" required="required">
							</div>
							<div class="form-group col-sm-6">
								<label style="font-size: 16px;" for="">Hình Ảnh </label> <input
									type="file" style="font-size: 16px;" name="image"
									value="${PRODUCT.image }" class="form-control"
									placeholder="Hình Ảnh" required="required">
							</div>
						</div>
						<div class="row" style="margin: 5px;">

							<div class="form-group col-sm-12">
								<label for="" style="font-size: 16px;">Miêu tả</label>
								<textarea class="form-control" name="status" id="editor"
									rows="4" value="${PRODUCT.status }"></textarea>

							</div>
						</div>
						<div class="row" style="margin: 5px;">
							<div class="form-group col-sm-12">
								<div class="form-footer">
									<button class="btn btn-danger">
										<i class="fa fa-times"></i><a
											href="${pageContext.request.contextPath}/admin/product/list">Hủy</a>
									</button>
									<button type="submit" class="btn btn-success">
										<i class="fa fa-check-square-o"></i> Thêm
									</button>

								</div>

							</div>
					</form>
					<div class="card-footer" style="font-size: 25px;">${MESSAGE}</div>
				</div>


			</article>
		</div>
	</div>
</div>
<div class="overlay toggle-menu"></div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script src="/WebBaoCao/view/admin/assets/ckeditor/ckeditor.js"></script>
<script src="/WebBaoCao/view/admin/assets/ckeditor/samples/js/sample.js"></script>
<script>
	initSample();
</script>
<script type="text/javascript">
	CKEDITOR.replace('editor');
	CKEDITOR.add
</script>

<jsp:include page="./footer/footer.jsp" flush="true" />



