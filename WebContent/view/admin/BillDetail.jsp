
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
				<div class="card">
					<div class="card-body">
						<div class="card-title">Chi tiết hóa đơn</div>
						<hr>
						<div class="container">
							<p>Tên khách hàng :${BILL.userName }
							<p>
							<p>Email khách hàng :${BILL.userEmail }
							<p>
							<p>Số điện thoại khách hàng :${BILL.userPhonel }
							<p>
							<p>Tổng giá trị :${BILL.amount } vnd
							<p>
							<p>
								Ngày tạo :
								<fmt:formatDate pattern="yyyy-MM-dd" value="${BILL.createDate }" />
							<p>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>ID</th>
										<th>Tên truyện</th>
										<th>Số lượng</th>
										<th>Giá tiền</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="bill" items="${BILLDETAIL}">
										<tr>
											<td>${bill.billId}</td>
											<td>${bill.nameProduct}</td>
											<td>${bill.quantity}</td>
											<td>${bill.amount}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>


					</div>
				</div>
			</div>
		</div>
		<div class="overlay toggle-menu"></div>
	</div>
</div>

<jsp:include page="./footer/footer.jsp" flush="true" />
