package com.cafe24.mysite.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.mysite.vo.UserVo;
import com.cafe24.security.Authentication;
/*
 * ---------- 로그인 인증 체크 ----------
 * 	1. 인증(Authentication) 부분을 확인한다. 
 * 	2. 인가(Authorization) 부분 또한 인증이 되어있지 않으면 의미가 없으므로
 *     인증 인터셉터를 통과하게 url을 구성. 인가는 사용자의 권한(ADMIN, USER) 체크.
 * 	3. URL 중 /login,/join 부분만 배제 되어있다.
 * 	4. 기본적으로 return false로 해두고 통과되는 경우 true를 리턴하는 흐름으로 정리함. 
 * */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("handler : " + handler);
		if( handler instanceof HandlerMethod == false) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		
		Authentication authenticationClass = handlerMethod.getBean().getClass().getAnnotation(Authentication.class);
		Authentication authenticationMethod = handlerMethod.getMethodAnnotation(Authentication.class);
		
		if(authenticationClass == null && authenticationMethod == null) {
			return true;
		}
		UserVo authUser = (UserVo) request.getSession().getAttribute("authUser");
		
		if(authUser != null) {
			return true;
		}
		response.sendRedirect(request.getContextPath() + "/user/login");
		return false;
	}
}
