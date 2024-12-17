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
<!-- Begin page content -->
<div class="container" style="margin-top: 60px;">
    <div class="row">
        <!-- Left column (轮播图) -->
        <div class="col-md-6">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="${APP_PATH}/static/img/drawing/museum1.jpg" alt="First slide">
                    </div>
                    <div class="item">
                        <img src="${APP_PATH}/static/img/drawing/museum2.jpg" alt="Second slide">
                    </div>
                    <div class="item">
                        <img src="${APP_PATH}/static/img/drawing/museum3.jpg" alt="Third slide">
                    </div>
                </div>
                <a class="left carousel-control" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>

        <!-- Right column (公告和进馆须知) -->
        <div class="col-md-6">
            <!-- 公告模块 -->
            <div class="panel panel-default panel-entry-guide"
                 style="margin-top: 30px; background-image: url('${APP_PATH}/static/img/public/version_1_2_top.png');">
                <div class="panel-heading">
                    <h3 class="panel-title">公告</h3>
                </div>
                <div class="panel-body">
                    <ul>
                        <li><a href="#">我馆视频微课入选全国“大思政课”优质资源精品项目单</a> <span class="text-muted">[11-28]</span>
                        </li>
                        <li><a href="#">青青校园里那一抹红——井冈山革命博物馆百校千校活动精彩回馈</a> <span
                                class="text-muted">[11-22]</span></li>
                        <li><a href="#">省、市“四厅”业务指导专家来井冈山指引“四童”工作</a> <span class="text-muted">[11-22]</span>
                        </li>
                    </ul>
                </div>
            </div>

            <!-- 进馆须知模块 -->
            <div class="panel panel-default panel-entry-guide"
                 style="background-image: url('${APP_PATH}/static/img/public/version_1_2_top.png')">
                <div class="panel-heading">
                    <h3 class="panel-title">进馆须知</h3>
                </div>
                <div class="panel-body">
                    <ul>
                        <li>开放时间: 每星期三至星期日8:00-17:00，每周一闭馆（国家法定节假日除外）</li>
                        <li>地址: 杭州下沙高教园区学源街68号</li>
                        <li>电话: 0571-56700055</li>
                        <li>提醒：参观者请携带有效身份证件，遵守馆内相关规定。</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
<!-- Bootstrap core JavaScript -->
<%@include file="script.jsp" %>
<style>
    /* 全局字体与背景优化 */
    body {
        font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
        background-color: #f9f9f9;
        color: #333;
    }



    /* 轮播图样式 */
    .carousel {
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 8px 15px rgba(0, 0, 0, 0.1);
    }

    .carousel-inner img {
        border-radius: 10px;
        height: auto;
        max-height: 400px; /* 保证图片不会超高 */
        object-fit: cover;
    }

    .carousel-control {
        color: #333 !important;
    }

    /* 公告与进馆须知样式 */
    .panel {
        border-radius: 10px;
        box-shadow: 0 8px 15px rgba(0, 0, 0, 0.1);
        background-color: #ffffff;
        overflow: hidden;
    }

    .panel-heading {
        background-color: #f7f7f7;
        font-size: 18px;
        font-weight: 600;
        padding: 10px 20px;
        border-bottom: 1px solid #e0e0e0;
    }

    .panel-body {
        padding: 20px;
        line-height: 1.6;
        font-size: 14px;
        color: #555;
    }

    .panel-body ul {
        list-style: none;
        padding: 0;
    }

    .panel-body ul li {
        margin-bottom: 10px;
    }

    .panel-body ul li a {
        color: #007aff;
        text-decoration: none;
    }

    .panel-body ul li a:hover {
        text-decoration: underline;
    }

    /* 公告日期颜色 */
    .text-muted {
        color: #999 !important;
        font-size: 12px;
        margin-left: 5px;
    }

    /* 左右列间距 */
    .row > [class^="col-"] {
        margin-bottom: 20px;
    }
</style>

</body>
</html>