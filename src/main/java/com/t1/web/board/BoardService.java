package com.t1.web.board;

import java.util.List;

import org.springframework.stereotype.Component;

import com.t1.web.proxy.PageProxy;

@Component
public interface BoardService {
	
	public void insertBoardWrite(Board param);
	public List<Board> selectAllBoard(PageProxy param);
	public int boardAllCount();
	public Board readBoard(int param);
	public void updateBoard(Board param);
	public void deleteBoard(int param);
	public List<Board> searchBno(PageProxy param);
	public List<Board> searchTitle(PageProxy param); 
	public List<Board> searchWriter(PageProxy param); 
}
