package com.cafe24.mysite.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.mysite.vo.UserVo;
import com.cafe24.security.Authentication;
import com.cafe24.security.Authorization;

public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("handler : " + handler);
		if( handler instanceof HandlerMethod == false) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		
		Authorization authorizationClass = handlerMethod.getBean().getClass().getAnnotation(Authorization.class);
		Authorization authorizationMethod = handlerMethod.getMethodAnnotation(Authorization.class);
		
		if(authorizationClass == null && authorizationMethod == null) {
			return true;
		}
		String userRole = ((UserVo) request.getSession().getAttribute("authUser")).getRole();
		
		if(authorizationClass != null && authorizationClass.role().equals(userRole)) {
			return true;
		}
		if(authorizationMethod != null && authorizationClass.role().equals(userRole)) {
			return true;
		}
		response.sendRedirect(request.getContextPath() + "/");
		return false;
		
	}

}
