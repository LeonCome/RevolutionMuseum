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
    <c:if test="${not empty requestScope.orders}">
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
            <c:forEach var="order" items="${requestScope.orders}">
                <c:forEach var="orderItem" items="${order.orderItems}">

<%--                    <tr data-orderi-id="${orderItem.id}" data-orderi-price="${orderItem.total}">--%>
<%--                            &lt;%&ndash;订单状态&ndash;%&gt;--%>
<%--                        <td>${order.status}</td>--%>
<%--                            &lt;%&ndash;订单总价&ndash;%&gt;--%>
<%--                        <td>--%>
<%--                            <!-- 格式化为2位小数 -->--%>
<%--                            <fmt:formatNumber value="${orderItem.goods.price * orderItem.amount}" maxFractionDigits="2"--%>
<%--                                              minFractionDigits="2"/>--%>

<%--                        </td>--%>
<%--                            &lt;%&ndash;商品数量&ndash;%&gt;--%>
<%--                        <td>${orderItem.amount}</td>--%>
<%--                            &lt;%&ndash;商品名称&ndash;%&gt;--%>
<%--                        <td>${orderItem.goods.name}</td>--%>
<%--                        <td class="operation-cell">--%>
<%--                            <button class="btn btn-danger" onclick="removeOrderItem(${orderItem.id})">删除</button>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
                </c:forEach>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty requestScope.orders}">
        <p>您的订单是空的。</p>
    </c:if>
</div>

<%@include file="footer.jsp" %>
<!-- Bootstrap core JavaScript -->
<%@include file="script.jsp" %>
</body>
</html>
