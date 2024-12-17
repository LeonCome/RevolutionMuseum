<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<%@include file="head.jsp" %>
<body>

<!-- Begin Navbar -->
<jsp:include page="nav.jsp"/>
<!-- End Navbar -->

<!-- Begin page content -->
<div class="container mt-5">
  <h2 class="text-center mb-4">后台管理系统</h2>
  <div class="row">
    <!-- 数字博物馆管理模块 -->
    <div class="col-md-4 mb-4">
      <div class="card shadow-sm text-center">
        <div class="card-body">
          <h5 class="card-title">数字博物馆管理</h5>
          <p class="card-text">管理展览图片：上传、修改、删除和查看。</p>
          <a href="${pageContext.request.contextPath}/admin/drawing_control" class="btn btn-primary">进入管理</a>
        </div>
      </div>
    </div>

    <!-- 纪念品购买管理模块 -->
    <div class="col-md-4 mb-4">
      <div class="card shadow-sm text-center">
        <div class="card-body">
          <h5 class="card-title">纪念品购买管理</h5>
          <p class="card-text">管理订单：查看订单、发货处理。</p>
          <a href="${pageContext.request.contextPath}/admin/goods_control" class="btn btn-success">进入管理</a>
        </div>
      </div>
    </div>

    <!-- 快讯速递管理模块 -->
    <div class="col-md-4 mb-4">
      <div class="card shadow-sm text-center">
        <div class="card-body">
          <h5 class="card-title">快讯速递管理</h5>
          <p class="card-text">管理快讯和留言：发布、删除帖子和留言。</p>
          <a href="${pageContext.request.contextPath}/admin/post_control" class="btn btn-info">进入管理</a>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End page content -->

<!-- Begin Footer -->
<%@include file="footer.jsp" %>
<!-- End Footer -->

<!-- Begin Script -->
<%@include file="script.jsp" %>
<!-- End Script -->

</body>
</html>
