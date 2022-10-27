package com.april2nd.live1.board.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.april2nd.live1.board.model.BoardDto;
import com.april2nd.live1.board.model.FileInfoDto;

@Mapper
public interface BoardMapper {

	int writeArticle(BoardDto boardDto) throws SQLException;
	void registerFile(BoardDto boardDto) throws Exception;
	List<BoardDto> listArticle(Map<String, Object> map) throws SQLException;
	int getTotalArticleCount(Map<String, Object> map) throws SQLException;
	BoardDto getArticle(int articleNo) throws SQLException;
	void updateHit(int articleNo) throws SQLException;
	void modifyArticle(BoardDto boardDto) throws SQLException;
	void deleteFile(int articleNo) throws Exception;
	void deleteArticle(int articleNo) throws SQLException;
	List<FileInfoDto> fileInfoList(int articleNo) throws Exception;
	
}
