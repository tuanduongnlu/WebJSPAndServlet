<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${sessionScope.lang}_VN" />
<fmt:setBundle basename="messages.BookstoreMessages" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web bán truyện</title>
</head>
<body>

	<jsp:include page="/Client/Header.jsp"></jsp:include>
	<form action="/Receipt" method="post">
		<h3>
			<fmt:message key="ThankYou" />
			${param.cardname}.
		</h3>
		<jsp:useBean id="now" class="java.util.Date" />
		<jsp:setProperty name="now" property="time"
			value="${now.time + 432000000}" />

		<fmt:message key="ShipDate" />
		<fmt:formatDate value="${now}" type="date" dateStyle="full" />

	</form>



	<c:url var="url" value="/Home.jsp">
		<c:remove var="cart" scope="session" />
	</c:url>
	<strong><a href="${url}"><fmt:message
				key="ContinueShopping" /></a></strong>


	<jsp:include page="/Client/Footer.jsp"></jsp:include>
</body>
</html>