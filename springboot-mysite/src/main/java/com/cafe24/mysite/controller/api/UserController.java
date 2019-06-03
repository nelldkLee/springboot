package com.cafe24.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.mysite.dto.JSONResult;
import com.cafe24.mysite.service.UserService;

@Controller("userAPIController")
@RequestMapping("/user/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping("/checkemail")
	public JSONResult checkEmail(String email){
		Boolean exist = userService.checkEmail(email);
		return JSONResult.success(exist);
	}
}
