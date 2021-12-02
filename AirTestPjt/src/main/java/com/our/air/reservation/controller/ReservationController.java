package com.our.air.reservation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.our.air.reservation.service.ReservationService;
import com.our.air.reservation.vo.ReservationVo;

@Controller
@RequestMapping(value="/reservation")
public class ReservationController {

	@Autowired
	ReservationService reservationService;
	
	@RequestMapping(value="/reservationForm", method=RequestMethod.GET)
	public String reservationForm() {
		System.out.println("[ReservationController]::reservationForm() INIT");

		return "reservation/reservationForm";
	}
	
	@RequestMapping(value="/reservationConfirm", method=RequestMethod.POST)
	public String reservationConfirm(ReservationVo reservationVo) {
		System.out.println("[ReservationController]::reservationConfirm() INIT");
		
		int result = reservationService.reservationConfirm(reservationVo);
		
		if (result == 0) {
			System.out.println("Reservation Failed..");
		} else {
			System.out.println("Reservation Success..");
		}

		return "redirect:/reservation/reservationList";
	}
	
	@RequestMapping(value="/reservationList",method=RequestMethod.GET)
	public String reservationList(HttpSession httpSession, Model model) {
		System.out.println("[ReservationController]::reservationList() INIT");

		String m_mail = String.valueOf(httpSession.getAttribute("loginMember"));
		
		List<ReservationVo> reservationVos = reservationService.getReservationList(m_mail);
		
		model.addAttribute("reservationVos", reservationVos);
		
		return "reservation/reservationList";
	}
	
	@RequestMapping(value="/reservationModifyForm", method=RequestMethod.GET)
	public String reservationModifyForm(ReservationVo reservationVo, Model model) {
		System.out.println("[ReservationController]::reservationModifyForm() INIT");

		ReservationVo reserVo = reservationService.getReservation(reservationVo.getR_no());
		model.addAttribute("reservationVo", reserVo);
		
		return "reservation/reservationModifyForm";
	}
	
	@RequestMapping(value="/reservationModifyConfirm", method=RequestMethod.POST)
	public String reservationModifyConfirm(ReservationVo reservationVo, Model model) {
		System.out.println("[ReservationController]::reservationModifyConfirm() INIT");

		int result = reservationService.reservationModifyConfirm(reservationVo);
		
		if (result == 0) {
			System.out.println("Reservation modify failed..");
		} else {
			System.out.println("Reservation modify success..");
		}
		
		return "redirect:/reservation/reservationList";
	}
	
	@RequestMapping(value="/reservationCancel", method=RequestMethod.GET)
	public String reservationCancel(ReservationVo reservationVo) {
		System.out.println("[ReservationController]::reservationCancel() INIT");

		int result = reservationService.cancelReservation(reservationVo.getR_no());
		
		if (result == 0) {
			System.out.println("Reservation cancel failed..");
		} else {
			System.out.println("Reservation cancel success..");
		}
		
		return "redirect:/reservation/reservationList";
	}
	
}
