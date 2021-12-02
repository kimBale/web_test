package com.our.air.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.our.air.member.service.MemberService;
import com.our.air.member.vo.MemberVo;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;

	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public String loginForm() {
		System.out.println("[MemberController]::loginForm() INIT");
		
		return "member/loginForm";
		
	}
	
	@RequestMapping(value="/loginConfirm", method=RequestMethod.POST)
	public String loginConfirm(MemberVo memberVo, Model model, HttpServletRequest request) {
		System.out.println("[MemberController]::loginConfirm() INIT");

		int result = memberService.loginConfirm(memberVo);
		
		model.addAttribute("m_mail", memberVo.getM_mail());
		
		if (result == 0) {
			return "member/loginFail";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", memberVo.getM_mail());
			
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		System.out.println("[MemberController]::logout() INIT");

		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/joinForm", method=RequestMethod.GET)
	public String joinForm() {
		System.out.println("[MemberController]::joinForm() INIT");
		
		return "member/joinForm";
		
	}
	
	@RequestMapping(value="/joinConfirm", method=RequestMethod.POST)
	public String joinConfirm(MemberVo memberVo, Model model) {
		System.out.println("[MemberController]::joinConfirm() INIT");

		int result = memberService.joinMember(memberVo);
		
		model.addAttribute("m_mail", memberVo.getM_mail());
		
		if (result == 0) {
			return "member/joinForm";
		} else {
			
			return "redirect:/";
		}
	}
	
	
}
