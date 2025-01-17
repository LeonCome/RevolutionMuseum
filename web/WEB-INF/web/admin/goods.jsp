<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="zh-CN">
<%@include file="head.jsp" %>
<body>

<!-- Begin Navbar -->
<jsp:include page="nav.jsp"/>
<!-- End Navbar -->

<!-- Begin page content -->
<div class="container mt-5">
    <h2>订单管理</h2>
    <c:if test="${not empty requestScope.orderItems}">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>用户ID</th>
                <th>用户名</th>
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
                    <td>${orderItem.user.id}</td>
                    <td>${orderItem.user.username}</td>
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
                        <c:if test="${orderItem.orderStatus.id != null && orderItem.orderStatus.id == 1}">
                            <button class="btn btn-danger" onclick="deliver(${orderItem.id})">发货</button>
                        </c:if>
                        <c:if test="${orderItem.orderStatus.id != null && orderItem.orderStatus.id == 3}">
                            <button class="btn btn-default" onclick="accomplish(${orderItem.id})">完成</button>
                        </c:if>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty requestScope.orderItems}">
        <p>没有订单。</p>
    </c:if>
</div>
<!-- End page content -->

<!-- Begin Footer -->
<%@include file="footer.jsp" %>
<!-- End Footer -->

<!-- Begin Script -->
<%@include file="script.jsp" %>
<!-- End Script -->

</body>
</html>
