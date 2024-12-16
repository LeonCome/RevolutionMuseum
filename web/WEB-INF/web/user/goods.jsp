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
<!-- Begin page content -->
<!-- right block Start  -->

<div id="product-category" class="container text" style="margin-top: 60px; text-align: center;">
    <div class="row">
        <c:forEach items="${goods}" var="g">
            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12" style="margin-bottom: 20px;">
                <div class="item" style="border: 1px solid #ddd; border-radius: 10px; overflow: hidden; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);">
                    <div class="product-block">
                        <div class="image" style="padding: 10px;">
                            <img
                                    class="img-responsive" style="width: 100%; height: auto; border-radius: 10px;"
                                    title="${g.name}" alt="${g.name}"
                                    src="${pageContext.request.contextPath}/static/img/goods/images.jpg">
                        </div>
                        <div class="product-details" style="padding: 15px; text-align: left;">
                            <h4 style="font-size: 18px; color: #333; font-weight: bold; margin: 0;">${g.name}</h4>
                            <div class="price" style="font-size: 16px; color: #e63946; margin: 10px 0;"><span class="price-new">￥${g.price}</span></div>
                            <div class="product-hov" style="text-align: center;">
                                <ul style="display: flex; justify-content: space-between; padding: 0; list-style: none; margin: 0;">
                                    <li id="addtocart" class="addtocart" style="flex: 1; margin: 0 5px;">
                                        <a href="${pageContext.request.contextPath}/goods/add_cart?id=${g.id}"
                                           style="display: block; padding: 10px; background-color: #007bff; color: #fff; text-align: center; border-radius: 5px; text-decoration: none; font-size: 14px;">
                                            加入购物车
                                        </a>
                                    </li>
                                </ul>
                                <div class="review" style="margin-top: 10px;">
                                    <span class="rate">
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
            </div>
        </c:forEach>
    </div>
</div>


<%@include file="footer.jsp" %>
<!-- Bootstrap core JavaScript -->
<%@include file="script.jsp" %>
</body>
</html>