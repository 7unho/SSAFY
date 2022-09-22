package com.april2nd.live.member.model.dao;

import com.april2nd.live.member.model.MemberDto;

import java.sql.SQLException;

public interface MemberDao {

	int idCheck(String userId) throws SQLException;
	void joinMember(MemberDto memberDto) throws SQLException;
	MemberDto loginMember(String userId, String password) throws SQLException;
	
}
