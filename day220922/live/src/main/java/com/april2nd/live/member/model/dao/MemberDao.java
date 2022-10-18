package com.april2nd.live1.member.model.dao;

import com.april2nd.live1.member.model.MemberDto;

import java.sql.SQLException;

public interface MemberDao {

	int idCheck(String userId) throws SQLException;
	void joinMember(MemberDto memberDto) throws SQLException;
	MemberDto loginMember(String userId, String password) throws SQLException;
	
}
