<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./CheckAccount.jsp"%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">
			<div class="col-lg-8">
						<div class="card-title">Danh sách hóa đơn</div>
						<hr>
						<div class="container">
						<div class="row">
						<div class="col-md-4 col-md-offset-8">
							<form action="/Search" method="post">
								<div class="form-group has-feedback">
								<input type="hidden" value="bill" name="action">
									<label for="search" class="sr-only">Search</label> <input
										type="text"  name="search"  class="form-control"
										placeholder="Tìm kiếm theo username"> 
								</div>
							</form>
						</div>
					</div>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>#</th>
										<th>UserId</th>
										<th>UserName</th>
										<th>Mail</th>
										<th>Số điện thoại</th>
										<th>Tổng tiền</th>
										<th>Ngày bán</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="bill" items="${LISTBILL}">
										<tr>
											<td>${bill.id}</td>
											<td>${bill.userId}</td>
											<td>${bill.userName}</td>
											<th>${bill.userEmail }</th>
											<th>${bill.userPhonel }</th>
											<th>${bill.amount }</th>
											<th><fmt:formatDate pattern="yyyy-MM-dd"
													value="${bill.createDate}" /></th>

											<td><a class="btn btn-danger btn-sm"
												href="${pageContext.request.contextPath}/DetailBill?id=${bill.id}">Chi tiết
												</a></td>
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


