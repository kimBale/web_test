package com.our.air.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.our.air.admin.vo.AdminVo;
import com.our.air.member.vo.MemberVo;
import com.our.air.reservation.vo.ReservationVo;

@Component
public class AdminDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<ReservationVo> selectAllReservations() {
		System.out.println("[AdminDao]::::::selectAllReservations() INIT");
		
		List<ReservationVo> adminReservationVos = null;
		
		String sql = "SELECT * FROM tbl_reservation";
		
		adminReservationVos = jdbcTemplate.query(sql, new RowMapper<ReservationVo>() {

			@Override
			public ReservationVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				ReservationVo reservationVo = new ReservationVo();
				reservationVo.setR_no(rs.getInt("r_no"));
				reservationVo.setR_name(rs.getString("r_name"));
				reservationVo.setR_mail(rs.getString("r_mail"));
				reservationVo.setR_start_location(rs.getString("r_start_location"));
				reservationVo.setR_end_location(rs.getString("r_end_location"));
				reservationVo.setR_start_date(rs.getString("r_start_date"));
				reservationVo.setR_end_date(rs.getString("r_end_date"));
				reservationVo.setR_adult_cnt(rs.getInt("r_adult_cnt"));
				reservationVo.setR_infant_cnt(rs.getInt("r_infant_cnt"));
				reservationVo.setR_child_cnt(rs.getInt("r_child_cnt"));
				reservationVo.setR_seat_type(rs.getString("r_seat_type"));
				reservationVo.setR_reg_date(rs.getString("r_reg_date"));
				reservationVo.setR_mod_date(rs.getString("r_mod_date"));
				
				return reservationVo;
			}
			
		});
		
		return adminReservationVos;
	}

	public int checkLoginInfo(AdminVo adminVo) {
		System.out.println("[AdminDao]::::::checkLoginInfo() INIT");
		
		int result = 0;
		
		String sql = "SELECT COUNT(*) FROM tbl_admin where a_mail= ? and a_pw= ?";
		
		result = jdbcTemplate.queryForObject(sql, Integer.class, 
				adminVo.getA_mail(),
				adminVo.getA_pw());
		return result;
	}

	public List<MemberVo> selectAllMembers() {
		System.out.println("[AdminDao]::::::selectAllMembers() INIT");
		
		List<MemberVo> adminMemberVos = null;
		
		String sql = "SELECT * FROM tbl_member";
		
		adminMemberVos = jdbcTemplate.query(sql, new RowMapper<MemberVo>() {

			@Override
			public MemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVo memberVo = new MemberVo();
				memberVo.setM_no(rs.getInt("m_no"));
				memberVo.setM_mail(rs.getString("m_mail"));
				memberVo.setM_pw(rs.getString("m_pw"));
				memberVo.setM_reg_date(rs.getString("m_reg_date"));
				memberVo.setM_mod_date(rs.getString("m_mod_date"));
				
				return memberVo;
			}
			
		});
		
		return adminMemberVos;
	}

}
