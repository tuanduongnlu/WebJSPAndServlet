<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./CheckAccount.jsp"%>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Thêm thể loại</div>
                <hr>
                <form action="${pageContext.request.contextPath}/AddCategory" method="post">
                
                  <div class="form-group">
                    <label for="input-1">Tên thể loại</label>
                    <input type="text" class="form-control" id="input-1" placeholder="Tên thể loại" name="name">
                  </div>
                 <div class="form-footer">
                    <button type="reset" class="btn btn-danger"><i class="fa fa-times"></i> Hủy</button>
                    <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Thêm</button>
                </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="overlay toggle-menu"></div>
      </div>
    </div>
  
    <jsp:include page = "./footer/footer.jsp" flush = "true" />