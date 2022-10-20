package com.april2nd.live1.member.model.dao;

import java.sql.SQLException;
import java.util.Map;

import com.april2nd.live1.member.model.MemberDto;

public interface MemberDao {

	int idCheck(String userId) throws SQLException;
	void joinMember(MemberDto memberDto) throws SQLException;
	MemberDto loginMember(Map<String, String> map) throws SQLException;
	
}
