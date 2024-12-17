<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
<script src="${APP_PATH}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<%
    String serverName = request.getServerName(); // 域名
    int serverPort = request.getServerPort(); // 端口号
    String contextPath = request.getContextPath(); // 项目上下文路径
    String appPath = "/" + serverName + (serverPort != 80 && serverPort != 443 ? ":" + serverPort : "") + contextPath;
    pageContext.setAttribute("HOST_APP_PATH", appPath);
%>

<script>
    function deliver(orderId) {
        if (confirm("确定要发货该订单吗？")) {
            // 发起 AJAX 请求更新订单状态为发货
            $.ajax({
                type: "POST",
                url: "/${HOST_APP_PATH}/admin/update_order", // 发货的 URL
                data: {"orderId": orderId},
                success: function () {
                    location.reload();
                },
                error: function () {
                    alert("网络错误，请稍后重试！");
                }
            });
        }
    }

    function accomplish(orderId) {
        if (confirm("确定完成该订单吗？")) {
            // 发起 AJAX 请求更新订单状态为已完成
            $.ajax({
                type: "POST",
                url: "/${HOST_APP_PATH}/admin/update_order", // 完成订单的 URL
                data: {"orderId": orderId},
                success: function () {
                    location.reload();
                },
                error: function () {
                    alert("网络错误，请稍后重试！");
                }
            });
        }
    }

</script>