package com.cafe24.mysite.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.mysite.service.BoardService;
import com.cafe24.mysite.vo.BoardVo;
import com.cafe24.mysite.vo.UserVo;
import com.cafe24.security.Authentication;
import com.cafe24.security.Authorization;
import com.cafe24.security.Authorization.Role;

@Controller
@RequestMapping("/board")
@Authentication
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	private static final Log LOG = LogFactory.getLog( BoardController.class );

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", boardService.getList());
		return "board/list";
	}
	
	@Authorization(role=Role.USER)
	@GetMapping("/register")
	public String register(@ModelAttribute("boardVo") BoardVo boardVo) {
		return "board/register";
	}
	@PostMapping("/register")
	public String registerPost(BoardVo vo) {
		LOG.debug("register Post");
		LOG.debug("vo 체크 " + vo);
		boardService.register(vo);
		return "redirect:/board/list";
	}
	
	@GetMapping("/read")
	public String read(Integer no, Model model) {
		BoardVo boardVo = boardService.read(no);
		model.addAttribute(boardVo);
		return "board/view";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(required = true, defaultValue = "0") Integer no, HttpSession session) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser != null && permissionCheck(no, authUser, null)) {
			boardService.delete(no);
		}
		return "redirect:/board/list";
	}
	
	@GetMapping("/modify")
	public String modify(@RequestParam(required = true) Integer no, HttpSession session, Model model) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser != null && permissionCheck(no, authUser, model)) {
			return "/board/modify";
		}
		return "redirect:/board/read?no="+no;
	}
	
	@PostMapping("/modify")
	public String modify(BoardVo vo, HttpSession session) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser != null && permissionCheck(vo.getNo(), authUser, null)) {
			boardService.modify(vo);
		}
		return "redirect:/board/read?no="+vo.getNo();
	}
	
	
	
	private boolean permissionCheck(Integer no, UserVo authUser, Model model) {
		BoardVo vo = boardService.read(no);
		if(vo == null) {
			return false;
		}
		if(model != null) {
			model.addAttribute("boardVo", vo);
		}
		return vo.getUserNo() == authUser.getNo();
	}
}
