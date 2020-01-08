package com.t1.web.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t1.web.proxy.PageProxy;
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired BoardMapper mapper;
	@Override
	public void insertBoardWhite(Board param) {
		mapper.insertBoardWhite(param);		
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
	
	

	
	

}
