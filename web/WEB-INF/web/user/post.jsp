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
    <!-- 新闻卡片 -->
    <div class="news-item mb-4 p-4 border rounded shadow-sm bg-white">
        <h2 class="news-title font-weight-bold text-dark">井冈山革命博物馆闭馆公告</h2>
        <p class="news-date text-muted">2024-11-22</p>
        <p class="news-summary text-secondary">
            为进一步提升革命科技传播力，井冈山革命博物馆设备更新项目将启动，依据施工要求，我馆于2024年11月26日暂停对外开放...
        </p>
        <a href="#" class="btn btn-custom">了解详情</a>
    </div>

    <!-- 自定义分割线 -->
    <hr class="custom-hr">

    <div class="news-item mb-4 p-4 border rounded shadow-sm bg-white">
        <h2 class="news-title font-weight-bold text-dark">青少年教育发展新举措</h2>
        <p class="news-date text-muted">2024-11-22</p>
        <p class="news-summary text-secondary">
            万里长空有晴朗，八百里豫风好光。近日我馆通过创新教育模式，为少年儿童提供新的教育体验...
        </p>
        <a href="#" class="btn btn-custom">了解详情</a>
    </div>

    <!-- 自定义分割线 -->
    <hr class="custom-hr">

    <div class="news-item mb-4 p-4 border rounded shadow-sm bg-white">
        <h2 class="news-title font-weight-bold text-dark">井冈山博物馆四普工作进展</h2>
        <p class="news-date text-muted">2024-11-22</p>
        <p class="news-summary text-secondary">
            为进一步提升四普工作的进度与质量，井冈山博物馆将加强与相关部门的合作，通过高效的团队协作推动工作进展...
        </p>
        <a href="#" class="btn btn-custom">了解详情</a>
    </div>
</div>
<%@include file="footer.jsp" %>
<!-- Bootstrap core JavaScript -->
<%@include file="script.jsp" %>
</body>
</html>

<style>
    /* 自定义分割线 */
    .custom-hr {
        border: 0;
        height: 2px;
        background: linear-gradient(to right, #007aff, #00d4ff);
        margin: 40px 0;
    }

    /* 新闻卡片背景和阴影 */
    .news-item {
        background-color: #fff;
        border: 1px solid #ddd;
        border-radius: 10px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        transition: all 0.3s ease;
    }

    .news-item:hover {
        transform: translateY(-3px);
        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
    }

    /* 新闻标题和文本 */
    .news-title {
        font-size: 1.5rem;
    }

    .news-summary {
        font-size: 1rem;
        line-height: 1.6;
    }

    /* 自定义按钮 */
    .btn-custom {
        background-color: #007aff;
        color: #fff;
        border: none;
        border-radius: 50px;
        padding: 10px 20px;
        font-size: 1rem;
        transition: all 0.3s ease;
        text-transform: uppercase;
        font-weight: bold;
    }

    .btn-custom:hover {
        background-color: #0056b3;
        color: #fff;
    }

    /* 全局调整 */
    body {
        font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
        background-color: #f9f9f9;
        color: #333;
    }
</style>
