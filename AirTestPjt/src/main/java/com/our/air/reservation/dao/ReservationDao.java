package com.our.air.reservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.our.air.reservation.vo.ReservationVo;

@Component
public class ReservationDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int insertReservation(ReservationVo reservationVo) {
		System.out.println("[ReservationDao]::::::insertReservation() INIT");
		int result = 0;
		
		String sql = "INSERT INTO tbl_reservation(r_name, r_mail, r_start_location, r_end_location, "
				+ "r_start_date, r_end_date, r_adult_cnt, r_infant_cnt, r_child_cnt, r_seat_type, "
				+ "r_reg_date, r_mod_date) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
		result = jdbcTemplate.update(sql, 
							reservationVo.getR_name(), 
							reservationVo.getR_mail(), 
							reservationVo.getR_start_location(), 
							reservationVo.getR_end_location(), 
							reservationVo.getR_start_date(), 
							reservationVo.getR_end_date(), 
							reservationVo.getR_adult_cnt(), 
							reservationVo.getR_infant_cnt(), 
							reservationVo.getR_child_cnt(), 
							reservationVo.getR_seat_type());

		return result;
	}

	public List<ReservationVo> selectReservationsByMail(String r_mail) {
		System.out.println("[ReservationDao]::::::selectReservationsByMail() INIT");
		
		List<ReservationVo> ReservationVos = null;
		
		String sql = "SELECT * FROM tbl_reservation WHERE r_mail = ?";
		ReservationVos = jdbcTemplate.query(sql, new RowMapper<ReservationVo>() {

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
			
		}, r_mail);
		
		
		return ReservationVos;
	}

	public ReservationVo selectReservationsByNo(int r_no) {
		System.out.println("[ReservationDao]::::::selectReservationsByNo() INIT");

ReservationVo ReservationVo = null;
		
		String sql = "SELECT * FROM tbl_reservation WHERE r_no = ?";
		ReservationVo = jdbcTemplate.queryForObject(sql, new RowMapper<ReservationVo>() {

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
			
		}, r_no);
		
		return ReservationVo;
	}

	public int updateReservation(ReservationVo reservationVo) {
		System.out.println("[ReservationDao]::::::updateReservation() INIT");
		int result = 0;
		
		String sql = "UPDATE tbl_reservation SET r_name=?, r_mail=?, r_start_location=?, r_end_location=?, r_start_date=?, r_end_date=?, r_adult_cnt=?, r_infant_cnt=?, r_child_cnt=?, r_seat_type=?, r_mod_date=NOW() WHERE r_no=?";
		result = jdbcTemplate.update(sql, 
							reservationVo.getR_name(), 
							reservationVo.getR_mail(), 
							reservationVo.getR_start_location(), 
							reservationVo.getR_end_location(), 
							reservationVo.getR_start_date(), 
							reservationVo.getR_end_date(), 
							reservationVo.getR_adult_cnt(), 
							reservationVo.getR_infant_cnt(), 
							reservationVo.getR_child_cnt(), 
							reservationVo.getR_seat_type(),
							reservationVo.getR_no());

		return result;
	}

	public int deleteReservation(int r_no) {
		System.out.println("[ReservationDao]::::::updateReservation() INIT");
		
		int result = 0;
		
		String sql = "DELETE FROM tbl_reservation WHERE r_no=?";
		result = jdbcTemplate.update(sql, r_no);
		
		return result;
	}
	
	
}
