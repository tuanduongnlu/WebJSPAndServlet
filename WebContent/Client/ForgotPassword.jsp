<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link href="/WebBaoCao/view/admin/assets/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/WebBaoCao/view/admin/assets/css/all.min.css">
<link rel="stylesheet" href="/WebBaoCao/view/admin/assets/css/dangnhap.css">
  <link href="/WebBaoCao/view/admin/assets/css/dangnhapone.css" rel="stylesheet">
</head>
<body>
 <jsp:include page="/Client/Header.jsp"></jsp:include>
        <form class="form-signin" id="forget">
            <img class="mb-4" src="/WebBaoCao/view/admin/assets/images/QMK.png" alt="" width="72" height="72">
            <h1 class="h3 mb-3 font-weight-normal">Nhập email đã đăng kí</h1>
            <h6 style="color:blue">Mật khẩu được cấp lại qua mail</h6>
            <input id="inputEmail" class="form-control" placeholder="Nhập email" name="email" autofocus>

            <br />
            <a href="">Gửi lại mật khẩu</a>
            </div>
            <button class="btn btn-lg btn-primary btn-block mt-3" type="submit">OK</button>

        </form>
<jsp:include page="/Client/Footer.jsp"></jsp:include>
</body>
</html>