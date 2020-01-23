package com.t1.web.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t1.web.proxy.PageProxy;
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired BoardMapper mapper;
	@Override
	public void insertBoardWrite(Board param) {
		mapper.insertBoardWrite(param);		
	}
		
	@Override
	public List<Board> selectAllBoard(PageProxy param) {
		// TODO Auto-generated method stub
		return mapper.selectAllBoard(param);
	}
	@Override
	public int boardAllCount() {
		// TODO Auto-generated method stub
		return mapper.selectBoardAllCount();
	}

	@Override
	public Board readBoard(int param) {
		// TODO Auto-generated method stub
		return mapper.selectBoardRead(param);
	}
	
	@Override
	public void updateBoard(Board param) {
		mapper.updateBoard(param);
		
	}

	@Override
	public void deleteBoard(int param) {
		mapper.deleteBoard(param);
		
	}

	@Override
	public List<Board> searchBno(PageProxy param) {
		// TODO Auto-generated method stub
		return mapper.selectAllBoardByBno(param);
	}

	@Override
	public List<Board> searchTitle(PageProxy param) {
		// TODO Auto-generated method stub
		return mapper.selectAllBoardByTitle(param);
	}

	@Override
	public List<Board> searchWriter(PageProxy param) {
		// TODO Auto-generated method stub
		return mapper.selectAllBoardByWriter(param);
	}

	
	

	
	

}
