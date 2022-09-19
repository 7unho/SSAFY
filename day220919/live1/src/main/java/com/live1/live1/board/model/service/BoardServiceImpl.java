package com.live1.live1.board.model.service;

import java.util.List;
import java.util.Map;

import com.live1.live1.board.model.BoardDto;
import com.live1.live1.board.model.dao.BoardDao;
import com.live1.live1.board.model.dao.BoardDaoImpl;
import com.live1.live1.util.SizeConstant;

public class BoardServiceImpl implements BoardService {
	
	private static BoardService boardService = new BoardServiceImpl();
	private BoardDao boardDao;
	
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getBoardDao();
	}

	public static BoardService getBoardService() {
		return boardService;
	}

	@Override
	public int writeArticle(BoardDto boardDto) throws Exception {
		return 0;
	}

	@Override
	public List<BoardDto> listArticle(Map<String, String> map) throws Exception {
		return null;
	}

	@Override
	public BoardDto getArticle(int articleNo) throws Exception {
		return null;
	}

	@Override
	public void updateHit(int articleNo) throws Exception {
		
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws Exception {
		
	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {
		
	}

}
