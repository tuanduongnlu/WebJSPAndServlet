<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="messages.BookstoreMessages" />

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="theme-color" content="#03a6f3">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800,900"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="address">
						<h4>
							<fmt:message key="Address" />
						</h4>
						<h6>The BookStore Theme, 4th Store Beside that building, USA</h6>
						<h6>
							<fmt:message key="Call" />
						</h6>
						<h6>Email : info@bookstore.com</h6>
					</div>
					<div class="timing">
						<h4>
							<fmt:message key="Timing" />
						</h4>
						<h6>Mon - Fri: 7am - 10pm</h6>
						<h6>Saturday: 8am - 10pm</h6>
						<h6>Sunday: 8am - 11pm</h6>
					</div>
				</div>
				<div class="col-md-3">
					<div class="navigation">
						<h4>
							<fmt:message key="Navigation" />
						</h4>
						<ul>
							<li><a href="Home.jsp"><fmt:message key="Home" /></a></li>
							<li><a href="Content.jsp"><fmt:message key="Shop" /></a></li>
						</ul>
					</div>
					<div class="navigation">
						<h4>
							<fmt:message key="Help" />
						</h4>
						<ul>
							<li><a href=""><fmt:message key="ShippingReturn" /></a></li>
							<li><a href="privacy-policy.html"><fmt:message
										key="Privacy" /></a></li>
							<li><a href="faq.html"><fmt:message key="FAQ" /></a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-5">
					<div class="form">
						<h3>
							<fmt:message key="ContactUs" />
						</h3>
						<h6>We are now offering some good discount on selected books
							go and shop them</h6>
						<form>
							<div class="row">
								<div class="col-md-6">
									<input placeholder="Name" required>
								</div>
								<div class="col-md-6">
									<input type="email" placeholder="Email" required>
								</div>
								<div class="col-md-12">
									<textarea placeholder="Messege"></textarea>
								</div>
								<div class="col-md-12">
									<button class="btn black">Alright, Submit</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="copy-right">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<h5>(C) 2017. All Rights Reserved. BookStore Wordpress Theme</h5>
					</div>
					<div class="col-md-6">
						<div class="share align-middle">
							<span class="fb"><i class="fa fa-facebook-official"></i></span> <span
								class="instagram"><i class="fa fa-instagram"></i></span> <span
								class="twitter"><i class="fa fa-twitter"></i></span> <span
								class="pinterest"><i class="fa fa-pinterest"></i></span> <span
								class="google"><i class="fa fa-google-plus"></i></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>