
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${not empty sessionScope.lang ? sessionScope.lang : 'en'}" />
<fmt:setBundle basename="messages.BookstoreMessages" />

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<head>
<meta charset="UTF-8">
<title>Web bán truyện</title>

</head>
<body>
	<!-- Phần header cho trang Web -->
	<jsp:include page="/Client/Header.jsp"></jsp:include>


	<section class="slider">
		<div class="container">
			<div id="owl-demo" class="owl-carousel owl-theme">
				<div class="item">
					<div class="slide">
						<img src="image/slide1.jpg" alt="slide1">
						<div class="content">
							<div class="title">
								<h3>welcome to bookstore</h3>
								<h5>Discover the best books online with us</h5>



								<a href="${pageContext.request.contextPath}/Content"
									class="btn">shop books</a>


							</div>
						</div>
					</div>
				</div>
				<div class="item">
					<div class="slide">
						<img src="image/slide2.jpg" alt="slide1">
						<div class="content">
							<div class="title">
								<h3>welcome to bookstore</h3>
								<h5>Discover the best books online with us</h5>
								<c:url var="url" value="/Content.jsp">

								</c:url>
								<a href="${pageContext.request.contextPath}/Content"
									class="btn">shop books</a>
							</div>
						</div>
					</div>
				</div>
				<div class="item">
					<div class="slide">
						<img src="image/slide3.jpg" alt="slide1">
						<div class="content">
							<div class="title">
								<h3>welcome to bookstore</h3>
								<h5>Discover the best books online with us</h5>
								<c:url var="url" value="/Content.jsp">
									<c:param name="action" value="shop" />
								</c:url>
								<a href="${url}" class="btn">shop books</a>
							</div>
						</div>
					</div>
				</div>
				<div class="item">
					<div class="slide">
						<img src="image/slide4.jpg" alt="slide1">
						<div class="content">
							<div class="title">
								<h3>welcome to bookstore</h3>
								<h5>Discover the best books online with us</h5>
								<a href="${url}?Add=" class="btn">shop books</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>



	<!-- Phần footer cho trang Web -->
	<jsp:include page="/Client/Footer.jsp"></jsp:include>

</body>
</html>