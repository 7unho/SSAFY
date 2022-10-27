package com.april2nd.live1.member.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.april2nd.live1.member.model.MemberDto;
import org.apache.ibatis.jdbc.SQL;

@Mapper
public interface MemberMapper {

	int idCheck(String userId) throws SQLException;
	void joinMember(MemberDto memberDto) throws SQLException;
	MemberDto loginMember(Map<String, String> map) throws SQLException;

	List<MemberDto> listMember(Map<String, Object> map) throws SQLException;

	void deleteMember(String userId) throws SQLException;

	MemberDto getMember(String userId) throws SQLException;

	void modifyMember(MemberDto memberDto) throws SQLException;
}
