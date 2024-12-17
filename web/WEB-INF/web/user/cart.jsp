<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- 引入fmt标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>


<!doctype html>
<html lang="zh-CN">
<%@include file="head.jsp" %>
<body>
<jsp:include page="nav.jsp"/>
<!-- Begin page content -->
<!-- right block Start  -->
<div class="container mt-5">
    <h2>购物车</h2>
    <c:if test="${not empty requestScope.cartItems}">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>商品图片</th>
                <th>商品名称</th>
                <th>单价</th>
                <th>数量</th>
                <th>总价</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${requestScope.cartItems}">
                <tr data-item-id="${item.id}"
                    data-item-price="${item.goods.price}"
                    data-count="${item.count}"
                    data-total-price="${item.totalPrice}"
                    data-goods='${fn:escapeXml(item.goods)}'
                    data-user='${fn:escapeXml(item.user)}'>

                    <td><img src="${item.goods.image}" alt="${item.goods.name}" class="img-thumbnail" width="100"></td>
                    <td>${item.goods.name}</td>
                    <td class="item-price">${item.goods.price}</td>
                    <td>
                        <input type="number" class="form-control item-count" value="${item.count}" min="1" max="99"
                               id="item_${item.id}" onchange="updateItem(${item.id})">
                    </td>
                    <td class="item-total-price">
                        <fmt:formatNumber value="${item.totalPrice}" maxFractionDigits="2" minFractionDigits="2"/>
                        <!-- 格式化为2位小数 -->
                    </td>
                    <td class="operation-cell">
                        <button class="btn btn-danger" onclick="removeItem(${item.id})">删除</button>
                        <button class="btn btn-primary confirm-btn"
                                style="display: none; position: absolute; margin-left: 50px"
                                onclick="confirmUpdate(${item.id})">确定
                        </button> <!-- 添加“确定”按钮，初始隐藏 -->
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="text-right">
            <h4>总金额: <span id="total-price"></span></h4>
            <button class="btn btn-success" onclick="settle()">结算</button>
        </div>
    </c:if>
    <c:if test="${empty requestScope.cartItems}">
        <p>您的购物车是空的。</p>
    </c:if>
</div>

<%@include file="footer.jsp" %>
<!-- Bootstrap core JavaScript -->
<%@include file="script.jsp" %>
</body>
</html>
