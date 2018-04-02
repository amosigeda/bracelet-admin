package com.jadmin.util;

import org.springframework.context.ApplicationContext;

/**
 * 静态属性配置
 */
public class Const {
	public static final String SALT = "jadmin_KEY";
	public static final String CURR_USER = "currUser";
	public static final String CURR_ROLES = "currRoles";
	public static final String SESSION_SECURITY_CODE = "sessionSecCode";
	public static ApplicationContext WEB_APP_CONTEXT = null; //该值会在web容器启动时由WebAppContextListener初始化	
}
