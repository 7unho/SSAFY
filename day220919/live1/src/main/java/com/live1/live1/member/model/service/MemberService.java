package com.live1.live1.member.model.service;

import com.live1.live1.member.model.MemberDto;

public interface MemberService {

	int idCheck(String userId) throws Exception;
	void joinMember(MemberDto memberDto) throws Exception;
	MemberDto loginMember(String userId, String password) throws Exception;
	
}
