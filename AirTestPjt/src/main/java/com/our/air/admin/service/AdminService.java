package com.our.air.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.air.admin.dao.AdminDao;
import com.our.air.admin.vo.AdminVo;
import com.our.air.member.vo.MemberVo;
import com.our.air.reservation.vo.ReservationVo;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;
	
	public List<ReservationVo> getReservationList() {
		System.out.println("[AdminService]::::getReservationList() INIT");

		List<ReservationVo> adminReservationVos = adminDao.selectAllReservations();
		
		return adminReservationVos;
	}

	public int loginConfirm(AdminVo adminVo) {
		System.out.println("[AdminService]::::loginConfirm() INIT");
		
		int result = adminDao.checkLoginInfo(adminVo);

		return result;
	}

	public List<MemberVo> getMemberList() {
		System.out.println("[AdminService]::::getMemberList() INIT");

		List<MemberVo> adminMemberVos = adminDao.selectAllMembers();
		
		return adminMemberVos;
	}

}
