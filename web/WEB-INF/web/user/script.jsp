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
    String appPath = "/" + serverName + (serverPort != 80 && serverPort != 443 ? ":" + serverPort : "") + contextPath;
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
            success: function (response) {
                // 成功后，隐藏“确定”按钮
                confirmButton.hide();
                window.location.href = "/${HOST_APP_PATH}/cart";
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
                data: {"itemId": itemId},
                success: function () {
                    window.location.href = "/${HOST_APP_PATH}/cart";
                },
            });
        }
    }


    // 结算购物车
    function settle() {
        if (confirm("确定要结算购物车吗？")) {
            // 构建购物车数据
            const cartItems = [];
            $("tbody tr").each(function () {
                const row = $(this);
                const id = row.data("item-id"); // 购物车项 ID
                const goods = row.data("goods");
                // const goods = JSON.parse(goodsData);
                const count = row.find(".item-count").val(); // 商品数量
                const user = row.data("user");
                //const user = JSON.parse(user); // 用户信息应该是对象
                const totalPrice = row.data("total-price"); // 商品总价

                console.log("id" + id)
                console.log("count" + count)
                console.log("totalPrice" + totalPrice)
                console.log("user" + user)
                console.log("goods" + goods)

                if (id && goods && count && user && totalPrice) {
                    cartItems.push({
                        id: id,           // 购物车项 ID
                        goods: goods,     // 商品信息
                        count: count,     // 商品数量
                        user: user,       // 用户信息
                        totalPrice: totalPrice // 商品总价
                    });
                }
            });

            if (cartItems.length === 0) {
                alert("购物车为空，无法结算！");
                return;
            }

            // 发起 AJAX 请求提交结算信息
            $.ajax({
                type: "POST",
                url: "/${HOST_APP_PATH}/cart/add_order", // 结算购物车的 URL
                contentType: "application/json", // 数据格式为 JSON
                data: JSON.stringify(cartItems), // 转换为 JSON 字符串
                success: function () {
                    window.location.href = "/${HOST_APP_PATH}/cart";
                },
                error: function () {
                    alert("网络错误，请稍后再试！");
                }
            });
        }
    }

    function signFor(orderId) {
        if (confirm("确定签收该订单吗？")) {
            // 发起 AJAX 请求更新订单状态为已签收
            $.ajax({
                type: "POST",
                url: "/${HOST_APP_PATH}/order/update", // 签收的 URL
                data: {"orderId": orderId},
                success: function () {
                    window.location.href = "/${HOST_APP_PATH}/order";
                },
                error: function () {
                    alert("网络错误，请稍后重试！");
                }
            });
        }
    }

    function deleteOrder(orderId) {
        if (confirm("确定删除该订单吗？")) {
            // 发起 AJAX 请求删除订单
            $.ajax({
                type: "POST",
                url: "/${HOST_APP_PATH}/order/delete", // 删除订单的 URL
                data: {"orderId": orderId},
                success: function () {
                    window.location.href = "/${HOST_APP_PATH}/order";
                },
                error: function () {
                    alert("网络错误，请稍后重试！");
                }
            });
        }
    }

    // 计算并更新总金额
    function calculateTotalPrice() {
        let total = 0;
        $(".item-total-price").each(function () {
            total += parseFloat($(this).text());
        });
        $("#total-price").text(total.toFixed(2)); // 更新页面中的总金额
    }

    // 页面加载时计算初始总金额
    $(document).ready(function () {
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