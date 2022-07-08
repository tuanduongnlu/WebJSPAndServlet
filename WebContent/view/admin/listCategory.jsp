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
            <button class="add-catalog"><a href="${pageContext.request.contextPath}/AddCategory">Thêm thể loại</a></button>
          </div>
			<div class="col-lg-8">
				<div class="card-title">Danh sách thể loại</div>
				<hr>
				
				<div class="container">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>#</th>
								<th>Thể loại</th>
								<th>Tác vụ</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="cate" items="${LISTCATE}">
								<tr>
									<td>${cate.id}</td>
									<td>${cate.name}</td>
									<td><a class="btn btn-primary btn-sm"
										href="${pageContext.request.contextPath}/DeleteCategory?id=${cate.id}">Delete</a>
										| <a class="btn btn-danger btn-sm"
										href="${pageContext.request.contextPath}/EditCategory?id=${cate.id}">Edit</a></td>
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








