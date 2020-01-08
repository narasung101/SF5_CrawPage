package com.t1.web.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Lazy
@Component("pager")
public class PageProxy extends Proxy {
	private int rowCount, startRow, endRow,
				pageCount, pageSize, startPage, endPage, nowPage,
				blockCount, blockSize, prevBlock, nextBlock, nowBlock;
	private boolean existPrev, existNext;
	private String search, option;

	public void paging() {
		// rowCount, pageSize, blockSize, nowPage
		pageCount = (rowCount % pageSize != 0) ? rowCount / pageSize + 1 : rowCount / pageSize -1;
		blockCount = (pageCount % blockSize != 0) ? pageCount / blockSize + 1 : pageCount / blockSize;
		startRow = nowPage * pageSize;
		endRow = (nowPage != pageCount) ? startRow + (pageSize - 1) : rowCount;
		nowBlock = nowPage / blockSize + 1;
		startPage = (nowBlock-1) * blockSize;
		endPage = (nowBlock != blockCount) ? startPage + (blockSize - 1) : pageCount;
		prevBlock = startPage - 1;
		nextBlock = endPage + 1;
		existPrev = (nowBlock-1) != 0;
		existNext = nowBlock != blockCount;

	}

}
