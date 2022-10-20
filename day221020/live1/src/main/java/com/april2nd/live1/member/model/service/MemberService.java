package com.april2nd.live1.member.model.service;

import java.util.Map;

import com.april2nd.live1.member.model.MemberDto;

public interface MemberService {

	int idCheck(String userId) throws Exception;
	void joinMember(MemberDto memberDto) throws Exception;
	MemberDto loginMember(Map<String, String> map) throws Exception;
	
}
