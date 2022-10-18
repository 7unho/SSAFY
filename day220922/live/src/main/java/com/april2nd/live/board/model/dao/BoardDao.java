package com.april2nd.live1.board.model.dao;

import com.april2nd.live1.board.model.BoardDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface BoardDao {

	int writeArticle(BoardDto boardDto) throws SQLException;
	List<BoardDto> listArticle(Map<String, String> map) throws SQLException;
	int totalArticleCount(Map<String, String> map) throws SQLException;
	BoardDto getArticle(int articleNo) throws SQLException;
	void updateHit(int articleNo) throws SQLException;
	void modifyArticle(BoardDto boardDto) throws SQLException;
	void deleteArticle(int articleNo) throws SQLException;
	
}
