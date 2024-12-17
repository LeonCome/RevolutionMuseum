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
<!-- 商品展示区域 -->
<div id="product-category" class="container" style="margin-top: 60px;">
    <div class="row">
        <c:forEach items="${goods}" var="g">
            <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mb-4">
                <div class="item shadow-sm rounded overflow-hidden bg-white">
                    <div class="product-block">
                        <!-- 商品图片 -->
                        <div class="image">
                            <img
                                    class="img-fluid rounded-top"
                                    title="${g.name}" alt="${g.name}"
                                    src="${pageContext.request.contextPath}/static/img/goods/images.jpg"
                                    style="width: 100%; height: auto;">
                        </div>
                        <!-- 商品详情 -->
                        <div class="product-details p-3 text-left">
                            <h4 class="product-title text-dark font-weight-bold mb-2">${g.name}</h4>
                            <div class="price text-danger font-weight-bold mb-2">￥${g.price}</div>
                            <!-- 操作按钮 -->
                            <div class="d-flex justify-content-between align-items-center">
                                <a href="${pageContext.request.contextPath}/goods/add_cart?id=${g.id}"
                                   class="btn btn-primary btn-block text-white">
                                    加入购物车
                                </a>
                            </div>
                            <!-- 评分 -->
                            <div class="review mt-3 text-center">
                                <span class="rate text-warning">
                                    <i class="fa fa-star rated"></i>
                                    <i class="fa fa-star rated"></i>
                                    <i class="fa fa-star rated"></i>
                                    <i class="fa fa-star rated"></i>
                                    <i class="fa fa-star"></i>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<%@include file="footer.jsp" %>
<!-- Bootstrap core JavaScript -->
<%@include file="script.jsp" %>
</body>
</html>

<style>
    body {
        font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
        background-color: #f9f9f9;
        color: #333;
    }


    .item {
        border: 1px solid #e0e0e0;
        border-radius: 10px;
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }

    .item:hover {
        transform: translateY(-5px);
        box-shadow: 0 10px 15px rgba(0, 0, 0, 0.1);
    }
    .image img {
        border-bottom-left-radius: 0;
        border-bottom-right-radius: 0;
    }

    .rate .fa-star {
        color: #ffd700;
        font-size: 16px;
    }

    .rate .fa-star.rated {
        color: #ffb400;
    }

    .btn-primary {
        background-color: #007aff;
        border-color: #007aff;
        border-radius: 5px;
        font-size: 14px;
        padding: 8px 16px;
    }

    .btn-primary:hover {
        background-color: #0056b3;
        border-color: #0056b3;
    }

    .mb-4 {
        margin-bottom: 1.5rem !important;
    }
    
    #product-category {
        padding-top: 20px;
    }
</style>
