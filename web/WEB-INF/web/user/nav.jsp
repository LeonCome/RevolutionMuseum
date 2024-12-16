<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>

<nav class="navbar navbar-inverse navbar-fixed-top"
     style="background-image: url('${APP_PATH}/static/img/public/toubu.png');">
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
            <ul class="nav navbar-nav navbar-right">
                <!-- 登录状态判断 -->
                <c:if test="${empty sessionScope.loggedInUser}">
                    <li><a href="#" data-toggle="modal" data-target="#loginModal">点击登录</a></li>
                </c:if>
                <c:if test="${!empty sessionScope.loggedInUser}">
                    <li>
                        <a href="${APP_PATH}/order">
                            <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" class="bi bi-check2-square" viewBox="0 0 16 16">
                                <path d="M3 14.5A1.5 1.5 0 0 1 1.5 13V3A1.5 1.5 0 0 1 3 1.5h8a.5.5 0 0 1 0 1H3a.5.5 0 0 0-.5.5v10a.5.5 0 0 0 .5.5h10a.5.5 0 0 0 .5-.5V8a.5.5 0 0 1 1 0v5a1.5 1.5 0 0 1-1.5 1.5z"></path>
                                <path d="m8.354 10.354 7-7a.5.5 0 0 0-.708-.708L8 9.293 5.354 6.646a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0"></path>
                            </svg>
                            订单
                        </a>
                    </li>

                    <li>
                        <a href="${APP_PATH}/cart">
                            <svg class="bi bi-cart4" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"></path>
                            </svg>
                            购物车
                        </a>
                    </li>
                    <li>
                        <a href="#"><img class="avatar" src="${APP_PATH}/static/img/public/avatar.jpg"
                                         alt="User Avatar">
                            <span>${sessionScope.loggedInUser.name}</span>
                        </a>
                    </li>
                    <li><a href="#" data-toggle="modal" data-target="#logoutModal">登出</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

<!-- 登录模态框 -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="loginModalLabel">登录</h4>
            </div>
            <div class="modal-body">
                <!-- 错误提示 -->
                <div id="failMsgContainer" class="alert alert-danger" style="display: none;">
                    <strong>错误!</strong> <span id="failMsg"></span>
                </div>
                <form action="${APP_PATH}/client/user_login" method="post">
                    <div class="form-group">
                        <label for="username">用户名</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名"
                               value="${cookie.username.value}">
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="请输入密码"
                               value="${cookie.password.value}">
                    </div>
                    <div class="form-group">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="rememberMe" id="rememberMe"> 记住账号和密码
                            </label>
                        </div>
                    </div>
                    <c:if test="${!empty requestScope.loginFailMsg}">
                        <div id="alert_div" class="alert alert-danger" role="alert">
                            <strong>错误!</strong> ${requestScope.loginFailMsg}
                        </div>
                    </c:if>
                    <c:if test="${!empty requestScope.noLoginFailMsg}">
                        <div id="alert_div" class="alert alert-danger" role="alert">
                            <strong>错误!</strong> ${requestScope.noLoginFailMsg}
                        </div>
                    </c:if>
                    <button type="submit" class="btn btn-primary btn-block">登录</button>
                    <button type="button" class="btn btn-default btn-block" data-dismiss="modal" data-toggle="modal"
                            data-target="#registerModal">注册
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 注册模态框 -->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="registerModalLabel">注册</h4>
            </div>
            <div class="modal-body">
                <form action="${APP_PATH}/client/user_register" method="post">
                    <%--用户名--%>
                    <div class="form-group">
                        <label for="regUsername">用户名</label>
                        <input type="text" class="form-control" id="regUsername" name="regUsername"
                               placeholder="请输入用户名">
                    </div>
                    <%--密码--%>
                    <div class="form-group">
                        <label for="regPassword">密码</label>
                        <input type="password" class="form-control" id="regPassword" name="regPassword"
                               placeholder="请输入密码">
                    </div>
                    <%--确认密码--%>
                    <div class="form-group">
                        <label for="regConfirmPassword">确认密码</label>
                        <input type="password" class="form-control" id="regConfirmPassword" name="regConfirmPassword"
                               placeholder="请再次输入密码">
                    </div>
                    <%--姓名--%>
                    <div class="form-group">
                        <label for="regName">姓名</label>
                        <input type="text" class="form-control" id="regName" name="regName"
                               placeholder="请输入姓名">
                    </div>
                    <%--邮箱--%>
                    <div class="form-group">
                        <label for="regEmail">电子邮箱</label>
                        <input type="email" class="form-control" id="regEmail" name="regEmail"
                               placeholder="请输入电子邮箱">
                    </div>
                    <%--手机号--%>
                    <div class="form-group">
                        <label for="regPhone">手机号</label>
                        <input type="text" class="form-control" id="regPhone" name="regPhone"
                               placeholder="请输入手机号">
                    </div>
                    <%--地址--%>
                    <div class="form-group">
                        <label for="regAddress">地址</label>
                        <input type="text" class="form-control" id="regAddress" name="regAddress"
                               placeholder="请输入地址">
                    </div>
                    <c:if test="${!empty failMsg}">
                        <div id="alert_div" class="alert alert-danger" role="alert">
                            <strong>错误!</strong> ${failMsg}
                        </div>
                    </c:if>
                    <button type="submit" class="btn btn-primary btn-block">注册</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 登出模态框 -->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="logoutModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="logoutModalLabel">确认登出</h4>
            </div>
            <div class="modal-body">
                <form action="${APP_PATH}/client/user_logout" method="post">
                    <div class="form-group">
                        <span>是否要登出账号</span>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">登出</button>
                    <button type="button" class="btn btn-default btn-block" data-dismiss="modal">取消</button>
                </form>
            </div>
        </div>
    </div>
</div>

