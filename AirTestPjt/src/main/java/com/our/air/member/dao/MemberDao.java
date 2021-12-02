package com.our.air.member.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.our.air.member.vo.MemberVo;

@Component
public class MemberDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int loginMember(MemberVo memberVo) {
		System.out.println("[MemberDao]::::::loginMember() INIT!!");

		int result = 0;
		
		String sql = "SELECT COUNT(*) FROM tbl_member WHERE m_mail=? and m_pw=?";
		result = jdbcTemplate.queryForObject(sql, Integer.class, 
				memberVo.getM_mail(), 
				memberVo.getM_pw());
		
		return result;
	}

	public int insertMember(MemberVo memberVo) {
		String sql = "INSERT INTO tbl_member(m_mail, m_pw, m_reg_date, m_mod_date) "
				+ "VALUES(?, ?, NOW(), NOW())";
		
		int result = jdbcTemplate.update(sql, 
				memberVo.getM_mail(), 
				memberVo.getM_pw());
		
		return result;
	}

}
