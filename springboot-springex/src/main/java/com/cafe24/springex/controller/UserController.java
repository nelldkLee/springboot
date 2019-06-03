package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value= {"/join","/j"}, method = RequestMethod.POST)
	public String join(UserVo vo) {
		if(!valid(vo)) {
			return "/WEB-INF/views/join.jsp";
		}
		System.out.println(vo);
		return "redirect:/hello";
	}

	private boolean valid(UserVo vo) {
		return true;
	}
	
}
