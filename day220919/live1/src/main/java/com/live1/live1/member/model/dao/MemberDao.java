package com.live1.live1.member.model.dao;

import java.sql.SQLException;

import com.live1.live1.member.model.MemberDto;

public interface MemberDao {

	int idCheck(String userId) throws SQLException;
	void joinMember(MemberDto memberDto) throws SQLException;
	MemberDto loginMember(String userId, String password) throws SQLException;
	
}
