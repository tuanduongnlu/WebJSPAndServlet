
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./CheckAccount.jsp"%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">

			<div class="col-lg-13">
				<div class="card-title">Danh sách Account</div>
				<hr>
				<div class="container">
					<div class="row">
						<div class="col-md-4 col-md-offset-8">
							<form action="/Search" method="post">
								<div class="form-group has-feedback">
								<input type="hidden" value="user" name="action">
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
								<th>#</th>
								<th>Tài khoảng</th>
								<th>Mật khẩu</th>
								<th>Số điện thoại</th>
								<th>Địa chỉ</th>
								<th>Email</th>
								<th>Quyền</th>
								<th>Ngày tạo</th>
								<th>Tác vụ</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${LISTUSER}">
								<tr>
									<td>${user.id}</td>
									<td>${user.userName}</td>
									<td>${user.password}</td>
									<td>${user.phone}</td>
									<td>${user.adress}</td>
									<td>${user.email }</td>
									<td>${user.activity }</td>
									<td>${user.createDate }</td>
									<td><c:if test="${user.activity eq 'user'}">
											<a class="btn btn-primary btn-sm"
												href="${pageContext.request.contextPath}/LockAccout?id=${user.id}">lock</a>
										</c:if> <c:if test="${user.activity eq 'lock'}">
											<a class="btn btn-primary btn-sm"
												href="${pageContext.request.contextPath}/UnLockAccout?id=${user.id}">unlock</a>
										</c:if> <c:if test="${user.activity eq 'user'}">
											<a class="btn btn-primary btn-sm"
												href="${pageContext.request.contextPath}/authorizationAdmin?id=${user.id}&action=up">cấp
												quyền</a>
										</c:if> <c:if test="${user.activity eq 'admin'}">
											<a class="btn btn-primary btn-sm"
												href="${pageContext.request.contextPath}/authorizationAdmin?id=${user.id}&action=down">thu
												quyền</a>
										</c:if> <c:if
											test="${user.activity eq 'user' or user.activity eq 'admin' }">
											<a class="btn btn-primary btn-sm"
												href="${pageContext.request.contextPath}/DeleteAccout?id=${user.id}">xóa</a>
										</c:if></td>

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







