package com.april2nd.live1.board.model.service;

import com.april2nd.live1.board.model.BoardDto;
import com.april2nd.live1.board.model.dao.BoardDao;
import com.april2nd.live1.board.model.dao.BoardDaoImpl;
import com.april2nd.live1.util.SizeConstant;

import java.util.List;
import java.util.Map;

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
		return boardDao.writeArticle(boardDto);
	}

	@Override
	public List<BoardDto> listArticle(Map<String, String> map) throws Exception {
		int pgno = Integer.parseInt(map.get("pgno"));
		int spl = SizeConstant.SIZE_PER_LIST; // size per list
		int start = (pgno - 1) * spl;
		map.put("start", start + "");
		map.put("spl", spl + "");

		return boardDao.listArticle(map);
	}

	@Override
	public BoardDto getArticle(int articleNo) throws Exception {
		return boardDao.getArticle(articleNo);
	}

	@Override
	public void updateHit(int articleNo) throws Exception {
		boardDao.updateHit(articleNo);
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws Exception {
		
	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {
		boardDao.deleteArticle(articleNo);
	}

}
