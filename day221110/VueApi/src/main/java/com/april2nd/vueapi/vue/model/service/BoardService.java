package com.april2nd.vueapi.vue.model.service;

import java.util.List;

import com.april2nd.vueapi.util.PageNavigation;
import com.april2nd.vueapi.vue.model.BoardDto;
import com.april2nd.vueapi.vue.model.BoardParameterDto;

public interface BoardService {
	public boolean writeArticle(BoardDto boardDto) throws Exception;
	public List<BoardDto> listArticle(BoardParameterDto boardParameterDto) throws Exception;
	public PageNavigation makePageNavigation(BoardParameterDto boardParameterDto) throws Exception;
	
	public BoardDto getArticle(int articleno) throws Exception;
	public void updateHit(int articleno) throws Exception;
	public boolean modifyArticle(BoardDto boardDto) throws Exception;
	public boolean deleteArticle(int articleno) throws Exception;
}
