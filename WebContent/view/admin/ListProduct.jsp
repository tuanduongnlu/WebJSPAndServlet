<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./CheckAccount.jsp"%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">
		<div class="col-lg-12">
            <button class="add-catalog"><a href="${pageContext.request.contextPath}/AddProduct">Thêm sản phẩm</a></button>
          </div>
			<div class="col-lg-8">
				<div class="card-title">Danh sách sản phẩm</div>
				<hr>
				<div class="container">
				<div class="row">
						<div class="col-md-4 col-md-offset-8">
							<form action="/Search" method="post">
								<div class="form-group has-feedback">
								<input type="hidden" value="product" name="action">
									<label for="search" class="sr-only">Search</label> <input
										type="text"  name="search"  class="form-control"
										placeholder="Tìm kiếm theo tên"> 
								</div>
							</form>
						</div>
					</div>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th>Tên sản phẩm</th>
								<th>Tác Giả</th>
								<th>Nhà xuất bản</th>
								<th>Thể loại</th>
								<th>Số lượng</th>
								<th>Giá</th>
								<th>Giảm giá</th>
								<th>Hình ảnh</th>
								<th>Tác vụ</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${LIST}">
								<tr>
									<td>${product.id}</td>
									<td>${product.name}</td>
									<td>${product.author}</td>
									<td>${product.publisher }</td>
									<td>${product.category }</td>
									<td>${product.quantity }</td>
									<td>${product.price }</td>
									<td>${product.sale}</td>
									<td><img style="    width: 110px;height: 67px; object-fit: cover;border: 1px solid #fff;" 
									src="../WebBaoCao/imageProduct/${product.image}" ></td>

									<td><a class="btn btn-primary btn-sm"
										href="${pageContext.request.contextPath}/EditProduct?id=${product.id}">Edit</a>
										| <a class="btn btn-danger btn-sm"
										href="${pageContext.request.contextPath}/DeleteProduct?id=${product.id}">Del</a></td>
								</tr>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
		</div>
		<div class="overlay toggle-menu"></div>
	</div>
</div>

<jsp:include page="./footer/footer.jsp" flush="true" />



