package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

	@ResponseBody
	@RequestMapping("/board/update")
	public String update(String name) {
		System.out.println("------" + name + "-------");
		return "BoardController:update()";
	}
	@ResponseBody
	@RequestMapping("/board/write")
	public String write(@RequestParam(value="n",required =true, defaultValue = "이동규") String name) {
		System.out.println(name);
		return "BoardController:write()";
	}
	
	@ResponseBody
	@RequestMapping("/board/{no}")
	public String write(@PathVariable("no")Long no) {
		System.out.println(no);
		return "BoardController:write()";
	}
	
}
