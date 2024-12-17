package com.museum.servlet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.museum.bean.CartItem;
import com.museum.bean.OrderItem;
import com.museum.bean.OrderStatus;
import com.museum.service.CartItemService;
import com.museum.service.OrderItemService;
import com.museum.service.impl.CartItemServiceImpl;
import com.museum.service.impl.OrderItemServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UserCartAddToOrderServlet", urlPatterns = "/cart/add_order")
public class UserCartAddToOrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=================== UserCartAddToOrderServlet ====================");

		// 确保用户已登录
		if (req.getSession().getAttribute("loggedInUser") == null) {
			req.setAttribute("noLoginFailMsg", "请先登录");
			req.getRequestDispatcher("/goods").forward(req, resp);
			return;
		}

		// 读取 JSON 数据
		StringBuilder jsonBuilder = new StringBuilder();
		try (BufferedReader reader = req.getReader()) {
			String line;
			while ((line = reader.readLine()) != null) {
				jsonBuilder.append(line);
			}
		}

		String cartDataJson = jsonBuilder.toString();
		System.out.println(cartDataJson);
		if (cartDataJson.isEmpty()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "购物车数据为空！");
			return;
		}

		// 使用 Jackson 解析 JSON 数据
		ObjectMapper objectMapper = new ObjectMapper();
		List<CartItem> cartItemList;
		try {
			cartItemList = objectMapper.readValue(cartDataJson, new TypeReference<>() {});
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "解析购物车数据失败：" + e.getMessage());
			return;
		}

		// 获取服务类
		OrderItemService orderItemService = new OrderItemServiceImpl();
		CartItemService cartItemService = new CartItemServiceImpl();

		// 处理每个 CartItem
		for (CartItem cartItem : cartItemList) {
			Integer cartId = cartItem.getId();
			var user = cartItem.getUser(); // 用户信息
			var goods = cartItem.getGoods(); // 商品信息
			Integer count = cartItem.getCount(); // 商品数量
			Double totalPrice = cartItem.getTotalPrice(); // 总价

			// 创建订单状态（默认 "未发货"）
			OrderStatus orderStatus = new OrderStatus("未发货", 1);


			// 保存订单项到数据库
			boolean result1 = orderItemService.saveOrderItem(new OrderItem(null, user, goods, orderStatus, count, totalPrice));
			// 从购物车中移除该项
			boolean result2 = cartItemService.removeCartItemCount(cartId);

			// 如果保存订单或移除购物车项失败
			if (!result1 || !result2) {
				req.setAttribute("SqlFailMsg", "无法更新订单或删除购物车项，请联系管理员!");
				req.getRequestDispatcher("/order").forward(req, resp);
				return;
			}
		}
		// 全部处理成功后，跳转到订单页面
		req.getRequestDispatcher("/order").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
