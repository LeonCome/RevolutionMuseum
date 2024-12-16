<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
<!doctype html>
<html lang="zh-CN">
<%@include file="head.jsp" %>
<body>
<jsp:include page="nav.jsp">
    <jsp:param name="activeNum" value="${activeNum}"/>
</jsp:include>
<div class="container mt-5">
    <div class="news-item mb-4 p-4 border rounded shadow-sm">
        <h2 class="news-title font-weight-bold">井冈山革命博物馆闭馆公告</h2>
        <p class="news-date text-muted">2024-11-22</p>
        <p class="news-summary">
            为进一步提升革命科技传播力，井冈山革命博物馆设备更新项目将启动，依据施工要求，我馆于2024年11月26日暂停对外开放...
        </p>
        <a href="#" class="btn btn-primary">了解详情</a>
    </div>

    <!-- 自定义分割线 -->
    <hr class="custom-hr">

    <div class="news-item mb-4 p-4 border rounded shadow-sm">
        <h2 class="news-title font-weight-bold">青少年教育发展新举措</h2>
        <p class="news-date text-muted">2024-11-22</p>
        <p class="news-summary">
            万里长空有晴朗，八百里豫风好光。近日我馆通过创新教育模式，为少年儿童提供新的教育体验...
        </p>
        <a href="#" class="btn btn-primary">了解详情</a>
    </div>

    <!-- 自定义分割线 -->
    <hr class="custom-hr">

    <div class="news-item mb-4 p-4 border rounded shadow-sm">
        <h2 class="news-title font-weight-bold">井冈山博物馆四普工作进展</h2>
        <p class="news-date text-muted">2024-11-22</p>
        <p class="news-summary">
            为进一步提升四普工作的进度与质量，井冈山博物馆将加强与相关部门的合作，通过高效的团队协作推动工作进展...
        </p>
        <a href="#" class="btn btn-primary">了解详情</a>
    </div>
</div>
<%@include file="footer.jsp" %>
<!-- Bootstrap core JavaScript -->
<%@include file="script.jsp" %>
</body>
</html>
<style>
    .custom-hr {
        border: 0;
        height: 2px;
        background: linear-gradient(to right, #007bff, #00d4ff);
        margin: 20px 0;
    }
</style>