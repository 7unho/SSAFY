package com.april2nd.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.april2nd.happyhouse.model.BookmarkDto;
import com.april2nd.happyhouse.model.MemberDto;

@Mapper
public interface MemberMapper {

	public MemberDto login(MemberDto memberDto) throws SQLException;

	public MemberDto userInfo(String userid) throws SQLException;

	public void saveRefreshToken(Map<String, String> map) throws SQLException;

	public Object getRefreshToken(String userid) throws SQLException;

	public void deleteRefreshToken(Map<String, String> map) throws SQLException;

	public int registUser(MemberDto memberDto) throws SQLException;

	public int removeUser(String userid) throws SQLException;

	public List<BookmarkDto> getBookmarkApt(String userid) throws SQLException;

	public int newBookmark(String userId, String aptCode) throws SQLException;
	
	public int deleteBookmark(String userId, String aptCode) throws SQLException;

	public int updateUser(MemberDto memberDto) throws SQLException;
}
