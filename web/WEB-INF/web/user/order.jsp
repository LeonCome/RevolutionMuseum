<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- 引入fmt标签库 -->
<% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>

<!doctype html>
<html lang="zh-CN">
<%@include file="head.jsp" %>
<body>
<jsp:include page="nav.jsp"/>
<div class="container mt-5">
    <h2>订单</h2>
    <c:if test="${not empty requestScope.orderItems}">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>订单状态</th>
                <th>订单总价</th>
                <th>商品数量</th>
                <th>商品名称</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="orderItem" items="${requestScope.orderItems}">

                    <tr data-order-item-id="${orderItem.id}" data-order-itme-total-price="${orderItem.totalPrice}">
                            <%--订单状态--%>
                        <td>${orderItem.orderStatus.orderStatus}</td>
                            <%--订单总价--%>
                        <td>
                            <!-- 格式化为2位小数 -->
                            <fmt:formatNumber value="${orderItem.totalPrice}" maxFractionDigits="2"
                                              minFractionDigits="2"/>

                        </td>
                            <%--商品数量--%>
                        <td>${orderItem.count}</td>
                            <%--商品名称--%>
                        <td>${orderItem.goods.name}</td>
                        <td class="operation-cell">
<%--                    <button class="btn btn-danger" onclick="removeOrderItem(${orderItem.id})">删除</button>--%>
                        </td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty requestScope.orderItems}">
        <p>您的订单是空的。</p>
    </c:if>
</div>

<%@include file="footer.jsp" %>
<!-- Bootstrap core JavaScript -->
<%@include file="script.jsp" %>
</body>
</html>
