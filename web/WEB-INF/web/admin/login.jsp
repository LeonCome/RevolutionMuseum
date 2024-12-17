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
<div class="container">
    <div class="page-header text-center">
        <h1>登录</h1>
    </div>
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/admin/admin_login" method="post">
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon">用户名</span>
                        <input type="text" class="form-control" id="adminName" name="adminName" placeholder="请输入用户名"
                               value="<c:out value='${adminName}' default=''/>">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon">密　码</span>
                        <input type="password" class="form-control" id="adminPassword" name="adminPassword" placeholder="请输入密码"
                               value="<c:out value='${adminPassword}' default=''/>">
                    </div>
                </div>
                <div class="form-group">
                    <div class="checkbox text-right">
                        <label>
                            <input type="checkbox" name="rememberMeAdmin" value="1">记住用户名和密码
                        </label>
                    </div>
                </div>
                <c:if test="${!empty AdminLoginFailMsg}">
                    <div id="alert_div" class="alert alert-danger" role="alert">
                        <strong>错误!</strong> ${AdminLoginFailMsg}
                    </div>
                </c:if>
                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-10">
                        <button id="submit_btn" type="submit" class="btn btn-primary btn-block">登录</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-sm-3"></div>
    </div>
</div>

<!-- Begin Footer -->
<%@include file="footer.jsp" %>
<!-- End Footer -->

<!-- Begin Script -->
<%@include file="script.jsp" %>
<!-- End Script -->

</body>
</html>
