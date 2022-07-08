<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="vn">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <title>Đăng ký</title>



  <!-- Bootstrap core CSS -->
 <link rel="stylesheet" href="/WebBaoCao/view/admin/assets/css/all.min.css">
  <link href="/WebBaoCao/view/admin/assets/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link rel="stylesheet" href="/WebBaoCao/view/admin/assets/css/dangnhap.css">
  <link href="/WebBaoCao/view/admin/assets/css/dangnhapone.css" rel="stylesheet">
</head>

<body>
<jsp:include page="/Client/Header.jsp"></jsp:include>
  <div class="zalo-chat-widget" data-oaid="20903896506704425" data-welcome-message="Rất vui khi được hỗ trợ bạn!"
    data-autopopup="0" data-width="350" data-height="420"></div>

  <script src="https://sp.zalo.me/plugins/sdk.js"></script>
  <!-- Thanh menu tim kiem -->
 
  <form action="${pageContext.request.contextPath}/Register" class="form-signin"  method="post">
    <img class="mb-4" src="/WebBaoCao/view/admin/assets/images/icon.png" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal"> Đăng kí tài khoản mới</h1>
    <div class="row">
     
      <div class="col-lg-12 col-md-12 col-sm-12">
        <div class="frame-register">
          <div class="form-input"> <i class="fas fa-user"></i> <input type="text" id="inputname" name="username"
							
              placeholder="Tên" onfocusout="check_name2(this.id)"></div>
          <div class="require mt-1 ml-5" id="require-fname"> Tên không được để trống </div>
          <div class="require mt-1 ml-5" id="require-fname2">Tên không bao gồm các ký tự đặc biệt </div>
        </div>
      </div>
      <div class="col-lg-12 col-md-12 col-sm-12">
        <div class="frame-register">
          <div class="form-input">
            <label class="">+84</label>
            <input type="number" name="phone"  id="inputphone" placeholder="Nhập số điện thoại " value="${phone }"
              onfocusout="check_phone(this.id)"></div>
          <div class="require mt-1 ml-5" id="require-phone">Vui lòng nhập đúng số điện thoại</div>
        </div>
      </div>
      <div class="col-lg-12 col-md-12 col-sm-12">
        <div class="frame-register">

          <div class="form-input">
            <i class="fas fa-key"></i>
            <input type="password" id="inputPassword" class="l" placeholder="Mật Khẩu" name="password"
              onfocusout="check_password(this.id)"></div>
          <div class="require mt-1 ml-5" id="require-password"> Mật khẩu tối thiểu 8 ký tự, bao gồm chữ và số </div>
        </div>
      </div>
      <div class="col-lg-12 col-md-12 col-sm-12">
        <div class="frame-register">

          <div class="form-input">
            <i class="fas fa-key"></i>
            <input type="password" id="inputPassword-confirm" class="" placeholder="Nhập lại mật khẩu"
              onfocusout="check_password2(this.id,'inputPassword')">
          </div>
          <div class=" require mt-1 ml-5" id="require-password2">Nhập lại mật khẩu không khớp </div>
        </div>
      </div>
      <div class="col-lg-12 col-md-12 col-sm-12">
        <div class="frame-register">

          <div class="form-input">
            <i class="fas fa-address-book"></i>
            <input type="text" name="adress" value="${adress }"
							" placeholder="Địa chỉ "></div>
          <!-- <div class="require mt-1 ml-5" id="require-name"> Tên không được để trống </div>
          <div class="require mt-1 ml-5" id="require-name2">Không bao gồm các ký tự đặc biệt </div> -->
        </div>
      </div>
      <div class="col-lg-12 col-md-12 col-sm-12">
        <div class="frame-register">

          <div class="form-input">
            <i class="fas fa-mail-bulk"></i>
            <input type="email" id="inputemail" name="email" value="${email }"
							  onfocusout="check_email(this.id)" placeholder="Email">
          </div>

          <div class="require mt-1 ml-5" id="require-email"> Vui lòng nhập đúng định dạng email </div>
        </div>
      </div>

  
    </div>
    <div class="col-lg-12 col-md-12 col-sm-12">
      <div class="mess-register">
        <input type="checkbox">
        <p>Chúng tôi sẽ sử dụng những thông tin trên để liên hệ với quý khách hàng trong vấn đề mua bán cũng như vận
          chuyển, bạn có chấp nhận đăng ký với những thông tin này không?</p>
      </div>
    </div>
    <p style="color:red; display:block">
		            		${messageSigin }  </p>

    </div>
    <div class="checkbox">
      <br />
      <a href="${pageContext.request.contextPath}/LoginClient">Quay lại trang đăng nhập</a>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Đăng kí</button>

  </form>
  <jsp:include page="/Client/Footer.jsp"></jsp:include>
  
  
  <!-- footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white"></p>
    </div>
    <!-- /.container -->
  </footer>

</body>
<script src="/WebBaoCao/view/admin/assets/js/Register.js"></script>

</html>