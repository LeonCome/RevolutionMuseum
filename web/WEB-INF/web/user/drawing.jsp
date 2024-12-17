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
<style>
    body {
        font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif;
        background-color: #f5f5f7;
        color: #333;
        margin: 0;
        padding: 0;
    }

    .container {
        max-width: 1200px;
        margin: auto;
        padding: 0 15px;
    }

    .card {
        background-color: #fff;
        border: none;
        border-radius: 12px;
        overflow: hidden;
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }

    .card:hover {
        transform: translateY(-10px);
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
    }

    .card img {
        width: 100%;
        height: auto;
        transition: transform 0.3s ease, opacity 0.3s ease;
    }

    .card:hover img {
        transform: scale(1.05);
        opacity: 0.9;
    }

    .card-body {
        text-align: center;
        padding: 20px;
    }

    .card-title {
        font-size: 1.3rem;
        font-weight: 600;
        margin: 0;
        color: #1d1d1f;
    }

    /* 行间距 */
    .row {
        margin: 0 -15px;
    }

    .col-md-4 {
        padding: 15px;
    }
</style>

<!-- Begin page content -->
<div class="container mt-5">
    <div class="row">
        <!-- Card 1 -->
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="static/img/drawing/museum1.jpg" class="card-img-top" alt="身先士卒">
                <div class="card-body">
                    <h5 class="card-title">身先士卒</h5>
                </div>
            </div>
        </div>
        <!-- Card 2 -->
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="static/img/drawing/museum2.jpg" class="card-img-top" alt="红四五军会师">
                <div class="card-body">
                    <h5 class="card-title">红四五军会师</h5>
                </div>
            </div>
        </div>
        <!-- Card 3 -->
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="static/img/drawing/museum3.jpg" class="card-img-top" alt="消灭尹道一">
                <div class="card-body">
                    <h5 class="card-title">消灭尹道一</h5>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
<!-- Bootstrap core JavaScript -->
<%@include file="script.jsp" %>
</body>
</html>