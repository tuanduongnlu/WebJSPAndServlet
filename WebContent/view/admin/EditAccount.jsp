<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />

<div class="content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<article class="col-sm-9">
				<div class="card" style="margin-top: 5px;">
					<div class="card-header" style="font-size: 25px;">Chỉnh sửa
						tài khoản</div>
					<form action="${pageContext.request.contextPath}/EditAccout"
						method="post">
						<input type="hidden" name="id" value=${USER.id } >
						<div class="">
							<input placeholder="User Name" type="text" name="username"
								class="form-control" value="${USER.userName }" required="">
						</div>
						<div class="">
							<input placeholder="Password" type="password" name="password"
								class="form-control" value="" required="" minlength="6">
						</div>
						<div class="">
							<input placeholder="Email"  type="email" name="email"
								class="form-control" value="${USER.email }" required="">
						</div>
						<div class="">
							<input placeholder="phone" type="text" name="phone"
								class="form-control" pattern="(\+84|0)\d{9,10}"
								value="${USER.phone }" required=""
								title="10 or 11-digit numbers, starting with 0 or 84">
						</div>
						<div class="">
							<input placeholder="Address" type="text" name="adress"
								class="form-control" value="${USER.adress }" required="">
						</div>
						<div class="login-check">
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked="">I Accept Terms & Conditions</label>
						</div>
						<div class="">
							<input type="submit" value="Submit">
						</div>
						<p style="color: red; display: block">${messageSigin }</p>
					</form>
				</div>
			</article>
		</div>
	</div>
</div>
<div class="overlay toggle-menu"></div>
</div>
</div>

<jsp:include page="./footer/footer.jsp" flush="true" />



