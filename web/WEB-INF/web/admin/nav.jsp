<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>

<nav class="navbar navbar-inverse navbar-fixed-top" style="background-image: url('${APP_PATH}/static/img/public/toubu.png');">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">革命博物馆</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li<c:if test="${param.activeNum eq 0}">
                    class="active"
                </c:if>>
                    <a href="${APP_PATH}/client">首页</a>
                </li>
                <li<c:if test="${param.activeNum eq 1}">
                    class="active"
                </c:if>><a href="${APP_PATH}/drawing">数字博物馆</a></li>
                <li<c:if test="${param.activeNum eq 2}">
                    class="active"
                </c:if>><a href="${APP_PATH}/goods">纪念品购买</a></li>
                <li<c:if test="${param.activeNum eq 3}">
                    class="active"
                </c:if>><a href="${APP_PATH}/post">快讯速递</a></li>
            </ul>
        </div>
    </div>
</nav>