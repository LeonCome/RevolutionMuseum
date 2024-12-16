package com.museum.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppPathListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 设置 APP_PATH 为全局属性
		sce.getServletContext().setAttribute("APP_PATH", sce.getServletContext().getContextPath());
	}
}
