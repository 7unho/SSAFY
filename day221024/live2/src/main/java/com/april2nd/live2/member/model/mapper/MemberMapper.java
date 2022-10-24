package com.april2nd.live2.member.model.mapper;

import com.april2nd.live2.member.model.MemberDto;

import java.sql.SQLException;
import java.util.Map;

public interface MemberMapper {

	int idCheck(String userId) throws SQLException;
	void joinMember(MemberDto memberDto) throws SQLException;
	MemberDto loginMember(Map<String, String> map) throws SQLException;
	
}
