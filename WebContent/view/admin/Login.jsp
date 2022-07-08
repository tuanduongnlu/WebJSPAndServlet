<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--

-->

<!DOCTYPE html>
<html>

<!-- Head -->
<head>

<title>login</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/WebBaoCao/view/admin/assets/css/popuo_box.css" rel="stylesheet" type="text/css"
	media="all" />
	<link href="/WebBaoCao/view/admin/assets/css/Login.css" rel="stylesheet" type="text/css"
	media="all" />
<link rel="stylesheet" href="/WebBaoCao/view/admin/assets/css/style.css" type="text/css"
	media="all">
<link href="//fonts.googleapis.com/css?family=Quicksand:300,400,500,700"
	rel="stylesheet">
</head>
<body>

	<h1>LOGIN FORM</h1>

	<div class="w3layoutscontaineragileits">
		<h2>Login here</h2>
		<form action="${pageContext.request.contextPath}/Login" method="post">

			<input type="text" placeholder="USERNAME" required=""
				name="usernamel" value="${usernamel }"> <input
				type="password" placeholder="PASSWORD" required="" name="passwordl">
			<ul class="agileinfotickwthree">
				<li><input type="checkbox" id="brand1" value=""> <label
					for="brand1"><span></span>Remember me</label> <a href="#">Forgot
						password?</a></li>
			</ul>
			<div class="aitssendbuttonw3ls">
				<input type="submit" value="LOGIN">
				<p style="color: white; display: block">${MESSAGEL }</p>
				<p>
					To register new account <span>→</span> <a class="w3_play_icon1"
						href="#small-dialog1"> Click Here</a>
				</p>
				<div class="clear"></div>
			</div>
		</form>
	</div>
</body>
</html>