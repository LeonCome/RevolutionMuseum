<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/static/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/smoothproducts.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/globle.js"></script>

<%
    String serverName = request.getServerName(); // 域名
    int serverPort = request.getServerPort(); // 端口号
    String contextPath = request.getContextPath(); // 项目上下文路径
    String appPath =  "/"+serverName + (serverPort != 80 && serverPort != 443 ? ":" + serverPort : "") + contextPath;
    pageContext.setAttribute("HOST_APP_PATH", appPath);
%>

<script>
    // 更新商品数量
    function updateItem(itemId) {
        const newCount = document.getElementById("item_" + itemId).value;
        const row = $("tr[data-item-id='" + itemId + "']");
        const price = parseFloat(row.attr("data-item-price"));
        const totalPriceCell = row.find(".item-total-price");
        const confirmButton = row.find(".confirm-btn");

        // 计算新的总价并更新
        const newTotalPrice = price * newCount;
        totalPriceCell.text(newTotalPrice.toFixed(2));

        // 显示“确定”按钮
        confirmButton.show();

        // 重新计算总金额
        calculateTotalPrice();
    }

    // 确认更新操作
    function confirmUpdate(itemId) {
        const row = $("tr[data-item-id='" + itemId + "']");
        const newCount = document.getElementById("item_" + itemId).value;
        const confirmButton = row.find(".confirm-btn");

        // 发起AJAX请求更新购物车
        $.ajax({
            type: "POST",
            url: "/${HOST_APP_PATH}/cart/update_cart_item", // 更新购物车的URL
            data: {
                "itemId": itemId,
                "count": newCount
            },
            success: function(response) {
                // 成功后，隐藏“确定”按钮
                confirmButton.hide();

                // 检查 loginFailMsg 是否存在
                <c:if test="${!empty requestScope.SqlFailMsg}">
                // 显示登录模态框
                alert(${requestScope.SqlFailMsg})
                </c:if>
            }
        });
    }

    // 删除购物车中的商品
    function removeItem(itemId) {
        if (confirm("确定要删除该商品吗？")) {
            const row = $("tr[data-item-id='" + itemId + "']");
            row.remove();  // 删除该行
            calculateTotalPrice();  // 更新总金额

            // 发起AJAX请求删除购物车商品
            $.ajax({
                type: "POST",
                url: "/${HOST_APP_PATH}/cart/remove_cart_item", // 删除购物车商品的URL
                data: { "itemId": itemId },
                success: function(response) {
                    // 成功后，页面可以根据需要做进一步处理

                }
            });
        }
    }

    // 计算并更新总金额
    function calculateTotalPrice() {
        let total = 0;
        $(".item-total-price").each(function() {
            total += parseFloat($(this).text());
        });
        $("#totalPrice").text(total.toFixed(2)); // 更新页面中的总金额
    }

    // 页面加载时计算初始总金额
    $(document).ready(function() {
        calculateTotalPrice();

        // 检查 failMsg 是否存在
        <c:if test="${!empty requestScope.failMsg}">
        // 显示注册模态框
        $('#registerModal').modal('show');
        </c:if>

        // 检查 loginFailMsg 是否存在
        <c:if test="${!empty requestScope.loginFailMsg}">
        // 显示登录模态框
        $('#loginModal').modal('show');
        </c:if>

        // 检查 loginFailMsg 是否存在
        <c:if test="${!empty requestScope.noLoginFailMsg}">
        // 显示登录模态框
        $('#loginModal').modal('show');
        </c:if>
    });
</script>