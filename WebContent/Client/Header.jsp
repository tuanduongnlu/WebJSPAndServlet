
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="messages.BookstoreMessages" />

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<head>
<meta charset="UTF-8">

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
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/owl.carousel.min.js"></script>
<script src="js/custom.js"></script>

</head>
<body>


	<header>
		<div class="main-menu">
			<div class="container">
				<nav class="navbar navbar-expand-lg navbar-light">
					<a class="navbar-brand" href="Home.jsp"><img
						src="image/logo.png" alt="logo"></a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav ml-auto">
							<c:url var="url" value="/Home.jsp">
								<c:param name="sessionLocale"
									value="${not empty sessionScope.lang ? sessionScope.lang : 'en'}" />
							</c:url>
							<li class="navbar-item active"><a href="${url}"
								class="nav-link"><fmt:message key="Home" /></a></li>

							<c:url var="url" value="/Content">
								<c:param name="Add" value="" />
								<c:param name="sessionLocale"
									value="${not empty sessionScope.lang ? sessionScope.lang : 'en'}" />
							</c:url>
							<li class="navbar-item"><a href="${url}" class="nav-link"><fmt:message
										key="Shop" /></a></li>

							<c:url var="url" value="/Introduction.jsp">
								<c:param name="sessionLocale"
									value="${not empty sessionScope.lang ? sessionScope.lang : 'en'}" />
							</c:url>
							<li class="navbar-item"><a href="${url}" class="nav-link"><fmt:message
										key="Introduction" /></a></li>

							<c:url var="url" value="/Contact.jsp">
								<c:param name="sessionLocale"
									value="${not empty sessionScope.lang ? sessionScope.lang : 'en'}" />
							</c:url>
							<li class="navbar-item"><a href="${url}" class="nav-link"><fmt:message
										key="ContactUs" /></a></li>

						</ul>

						<form class="form-inline my-2 my-lg-0" action="SearchServlet"
							method="get">
							<input class="form-control mr-sm-2" type="search" name="search"
								placeholder="Search here..." aria-label="Search"> <span
								class="fa fa-search"></span>
							<div>
								<p>${searchError}</p>
							</div>

						</form>
						<div class="navbar-item">
							<a href="Login.jsp" class="nav-link"><fmt:message key="Login" /></a>
						</div>
						<div class="cart my-2 my-lg-0">
							<c:url var="url" value="/Cart">
								<c:param name="sessionLocale"
									value="${not empty sessionScope.lang ? sessionScope.lang : 'en'}" />
							</c:url>
							<span><a href="${url}" class="fa fa-shopping-cart"
								aria-hidden="true"></a></span> <span class="quntity">${sessionScope.cart.numberOfItems}</span>
						</div>
						<ul>

							<c:if test="${ path eq '/Content'}">
								<li><a href="?sessionLocale=en&Add=">EN</a></li>
								<li><a href="?sessionLocale=vi&Add=">VN</a></li>
							</c:if>

							<c:if test="${ path eq '/CategoryList'}">
								<li><a href="?sessionLocale=en&cateId=${param.cateId}">EN</a></li>
								<li><a href="?sessionLocale=vi&cateId=${param.cateId}">VN</a></li>
							</c:if>


							<c:if test="${ path eq '/Detail'}">
								<li><a href="?sessionLocale=en&bookId=${param.bookId}">EN</a></li>
								<li><a href="?sessionLocale=vi&bookId=${param.bookId}">VN</a></li>
							</c:if>

							<c:if test="${ path eq '/SearchServlet'}">
								<li><a href="?sessionLocale=en&search=${param.search}">EN</a></li>
								<li><a href="?sessionLocale=vi&search=${param.search}">VN</a></li>
							</c:if>

							<c:if
								test="${fn:endsWith(path, '.jsp') or path eq '/Cart' or path eq '/Cashier' or path eq '/Receipt' }">
								<li><a href="?sessionLocale=en">EN</a></li>
								<li><a href="?sessionLocale=vi">VN</a></li>
							</c:if>



						</ul>
					</div>
				</nav>
			</div>
		</div>
	</header>



</body>
</html>