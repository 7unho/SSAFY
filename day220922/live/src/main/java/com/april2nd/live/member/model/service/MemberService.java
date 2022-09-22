package com.april2nd.live.member.model.service;

import com.april2nd.live.member.model.MemberDto;

public interface MemberService {

	int idCheck(String userId) throws Exception;
	void joinMember(MemberDto memberDto) throws Exception;
	MemberDto loginMember(String userId, String password) throws Exception;
	
}
