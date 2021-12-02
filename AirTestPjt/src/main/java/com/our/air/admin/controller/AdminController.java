package com.our.air.admin.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.our.air.admin.service.AdminService;
import com.our.air.admin.vo.AdminVo;
import com.our.air.member.vo.MemberVo;
import com.our.air.reservation.service.ReservationService;
import com.our.air.reservation.vo.ReservationVo;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String admin() {
		System.out.println("[AdminController]::admin() INIT");

		return "redirect:/admin/";
		
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String adminHome() {
		System.out.println("[AdminController]::adminHome() INIT");

		return "admin/loginForm";
		
	}
	
	@RequestMapping(value="/loginForm",method=RequestMethod.GET)
	public String adminLoginForm() {
		System.out.println("[AdminController]::adminLoginForm() INIT");

		return "admin/loginForm";
		
	}
	
	@RequestMapping(value="/loginConfirm",method=RequestMethod.POST)
	public String loginConfirm(AdminVo adminVo, Model model, HttpServletRequest request) {
		System.out.println("[AdminController]::loginConfirm() INIT");

		int result = adminService.loginConfirm(adminVo);
		
		model.addAttribute("a_mail", adminVo.getA_mail());
		
		if (result == 0) {
			return "admin/loginFail";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("admin", adminVo.getA_mail());
			
			return "redirect:/admin/";
		}
		
	}
	
	@RequestMapping(value="/reservationList",method=RequestMethod.GET)
	public String reservationList(Model model) {
		System.out.println("[AdminController]::reservationList() INIT");

		List<ReservationVo> adminReservationVos = adminService.getReservationList();
		
		model.addAttribute("adminReservationVos", adminReservationVos);
		
		return "/admin/reservationList";
		
	}
	
	@RequestMapping(value="/memberList",method=RequestMethod.GET)
	public String memberList(Model model) {
		System.out.println("[AdminController]::memberList() INIT");
		
		List<MemberVo> adminmemberVos = adminService.getMemberList();
		
		model.addAttribute("adminMemberVos", adminmemberVos);
		
		return "/admin/memberList";
		
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		System.out.println("[AdminController]::logout() INIT");
		
		session.invalidate();
		
		return "redirect:/admin/";
		
	}
	
	@RequestMapping(value="/reservationModifyForm",method=RequestMethod.GET)
	public String reservationModifyForm(ReservationVo reservationVo, Model model) {
		System.out.println("[AdminController]::reservationModifyForm() INIT");
		
		ReservationVo reserveVo = reservationService.getReservation(reservationVo.getR_no());
		model.addAttribute("reservationVo", reserveVo);

		return "/admin/reservationModifyForm";
		
	}
	
	@RequestMapping(value="/reservationModifyConfirm",method=RequestMethod.POST)
	public String reservationModifyConfirm(ReservationVo reservationVo) {
		System.out.println("[AdminController]::reservationModifyConfirm() INIT");

		int result = reservationService.reservationModifyConfirm(reservationVo);
		
		if (result == 0) {
			System.out.println("admin Reservation modify failed..");
		} else {
			System.out.println("admin Reservation modify success..");
		}
		
		return "redirect:/admin/reservationList";
		
	}
	
	@RequestMapping(value="/reservationCancel",method=RequestMethod.GET)
	public String reservationCancel(ReservationVo reservationVo) {
		System.out.println("[AdminController]::reservationCancel() INIT");
		
		int result = reservationService.cancelReservation(reservationVo.getR_no());
		
		if (result == 0) {
			System.out.println("admin Reservation cancel failed..");
		} else {
			System.out.println("admin Reservation cancel success..");
		}
		
		return "redirect:/admin/reservationList";
		
	}
	
	
	
}
