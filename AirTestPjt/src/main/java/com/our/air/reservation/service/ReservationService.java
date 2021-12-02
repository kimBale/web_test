package com.our.air.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.air.reservation.dao.ReservationDao;
import com.our.air.reservation.vo.ReservationVo;

@Service
public class ReservationService {

	@Autowired
	ReservationDao reservationDao;

	public int reservationConfirm(ReservationVo reservationVo) {
		System.out.println("[ReservatoinService]::::reservationConfirm() INIT");

		int result = reservationDao.insertReservation(reservationVo);
		
		return result;
	}

	public List<ReservationVo> getReservationList(String m_mail) {
		System.out.println("[ReservatoinService]::::getReservationList() INIT");

		List<ReservationVo> reservationVos = reservationDao.selectReservationsByMail(m_mail);
		return reservationVos;
	}

	public ReservationVo getReservation(int r_no) {
		System.out.println("[ReservatoinService]::::getReservation() INIT");
		
		ReservationVo reservationVo = reservationDao.selectReservationsByNo(r_no);
		
		return reservationVo;
	}

	public int reservationModifyConfirm(ReservationVo reservationVo) {
		System.out.println("[ReservatoinService]::::getReservation() INIT");

		int result = reservationDao.updateReservation(reservationVo);
		return result;
	}

	public int cancelReservation(int r_no) {
		System.out.println("[ReservatoinService]::::cancelReservation() INIT");
		
		int result = reservationDao.deleteReservation(r_no);
		
		return result;
	}
	
	
}
