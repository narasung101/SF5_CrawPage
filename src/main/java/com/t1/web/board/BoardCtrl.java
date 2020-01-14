package com.t1.web.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t1.web.proxy.Inventory;
import com.t1.web.proxy.PageProxy;
import com.t1.web.proxy.Proxy;
import com.t1.web.proxy.CrawlingProxy;

@RestController
@RequestMapping("/boards")
public class BoardCtrl extends Proxy {
	@Autowired
	BoardServiceImpl service;
	@Autowired
	Map<String, Object> map;
	@Autowired
	CrawlingProxy crawler;
	@Autowired
	PageProxy pager;

	@PostMapping("/")
	public Map<?, ?> white(@RequestBody Board param) {
		System.out.println("글쓰기 param값 넘어옴 :" + param);
		service.insertBoardWhite(param);

		map.clear();
		map.put("msg", "WHITE SUCCESS");

		return map;
	}

	@GetMapping("/list/{pageSize}/{nowPage}/{option}/{search}")
	public Map<?, ?> listPage(@PathVariable("pageSize") String pageSize, @PathVariable("nowPage") String nowPage,
			@PathVariable("option") String option, @PathVariable("search") String search) {
		
		System.out.println("페이지 사이즈 넘어옴" + pageSize);
		System.out.println("나우 페이지 넘어옴" + nowPage);
		System.out.println("옵션 넘어옴" + option);
		System.out.println("서치 넘어옴" + search);
		System.out.println("Board 총 카운트는? :" + service.boardAllCount());

		pager.setRowCount(service.boardAllCount());
		pager.setPageSize(Integer.parseInt(pageSize));
		pager.setBlockSize(5);
		pager.setNowPage(integer(nowPage));
		pager.setOption(option);
		pager.setSearch(search);
		pager.paging();
		System.out.println("pager값들 : " + pager.toString());

		List<Board> list = service.selectAllBoard(pager);
		System.out.println(list);
		map.clear();
		map.put("list", list);
		map.put("listSize", list.size());
		map.put("pager", pager);
		return map;
	}

	@GetMapping("/contentView/{bno}")
	public Map<?, ?> detailView(@PathVariable String bno) {
		System.out.println("int param값 넘어옴 :" + bno);
	
		map.clear();
		map.put("read", service.readBoard(Integer.parseInt(bno)));

		return map;
	}

	@PutMapping("/update")
	public Map<?, ?> update(@RequestBody Board param) {
		System.out.println("update param값 넘어옴 :" + param);
		service.updateBoard(param);
		map.clear();
		map.put("msg", "UPDATE SUCCESS");
		
		return map;
	}

	@GetMapping("/delete/{bno}")
	public Map<?, ?> delete(@PathVariable String bno) {
		System.out.println("DELETE bno값 넘어옴 :" + bno);
		service.deleteBoard(Integer.parseInt(bno));
		map.clear();
		map.put("msg", "DELETE SUCCESS");

		return map;
	}

	@GetMapping("/crawl")
	public ArrayList<HashMap<String, String>> crawl() {
		System.out.println("crawl" + crawler.crawling());

		return crawler.crawling();
	}

	@GetMapping("/crawlBugs")
	public ArrayList<HashMap<String, String>> bug() {
		return crawler.bugsCrawling();
	}

}
