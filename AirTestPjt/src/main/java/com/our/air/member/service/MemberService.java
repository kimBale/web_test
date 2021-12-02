package com.our.air.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.our.air.member.dao.MemberDao;
import com.our.air.member.vo.MemberVo;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;

	public int loginConfirm(MemberVo memberVo) {
		
		int result = memberDao.loginMember(memberVo);
		System.out.println("[MemberService]::::loginMember() INIT!!");

		return result;
	}

	public int joinMember(MemberVo memberVo) {
		System.out.println("[MemberService]::::joinMember() INIT!!");
		
		int result = memberDao.insertMember(memberVo);
		return result;
	}

}
