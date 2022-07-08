<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="/WebBaoCao/view/admin/assets/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/WebBaoCao/view/admin/assets/css/all.min.css">
<link rel="stylesheet" href="/WebBaoCao/view/admin/assets/css/dangnhap.css">
  <link href="/WebBaoCao/view/admin/assets/css/dangnhapone.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/Client/Header.jsp"></jsp:include>
<form class="form-signin" id="login" action="LoginClient" method="post">
    <img class="mb-4" src="/WebBaoCao/view/admin/assets/images/icon.png" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Đăng nhập</h1>

    <input type="text" id="" class="form-control" placeholder="username " name="userName"
      >
    
    <input type="password" class="form-control " placeholder="Mật khẩu" name="password"
      >
   
    <div class="checkbox mb-3">
      <a href="${pageContext.request.contextPath}/ForgotPassword" class="mx-2">Quên mật khẩu</a>
      <a href="${pageContext.request.contextPath}/Register" class="mx-2">Đăng kí</a>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Đăng nhập</button>
    </br>
    <p style="color:red; display:block">${MESSAGE }</p>
    <h3 class="h6  font-weight-normal mt-5">Đăng nhập bằng</h3>
    <div class="with-login">
      <a href="#"> <img src="/WebBaoCao/view/admin/assets/images/image/facebook.svg" id="facebook"></i></a>
      <a href="#"> <img src="/WebBaoCao/view/admin/assets/images/image/search.svg" id="google"></i></a>

    </div>

  </form>
  <jsp:include page="/Client/Footer.jsp"></jsp:include>
</body>
</html>