package com.april2nd.vueapi.vue.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.april2nd.vueapi.vue.model.MemberDto;

@Mapper
public interface MemberMapper {

	public MemberDto login(MemberDto memberDto) throws SQLException;
	public MemberDto userInfo(String userid) throws SQLException;
	
}
