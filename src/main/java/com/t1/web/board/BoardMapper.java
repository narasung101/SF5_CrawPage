package com.t1.web.board;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.t1.web.proxy.PageProxy;

@Repository
public interface BoardMapper {
	public void insertBoardWhite(Board param);
	public List<Board> selectAllBoard(PageProxy param);
	public int selectBoardAllCount();
	public Board selectBoardRead(int param);
	public void updateBoard(Board param);
	public void deleteBoard(int param);
	
}
