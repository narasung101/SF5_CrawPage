package com.t1.web.proxy;

import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("crawler")
public class CrawlingProxy extends Proxy {
	@Autowired Box<String> box;
	@Autowired Inventory<HashMap<String, String>> inventory;
	
	
	public ArrayList<HashMap<String, String>> crawling(){
		box.clear();
		System.out.println("박스 크롤링 시작 지점");
		try {
			Document rawData = Jsoup.connect
					("https://music.bugs.co.kr/recomreview?&order=listorder&page=2")
					.timeout(10*1000).get();
			Elements artist = rawData.select("div[class=recommendItem]"); 
			HashMap<String, String> map = null;
			for(Element e : artist) {
				map = new HashMap<>();
				map.put("list", e.text()+"\n ************** \n");
				inventory.add(map);
				System.out.println("크롤링 확인" + e.text());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return inventory.get();
	}
	
	public ArrayList<HashMap<String, String>> bugsCrawling() {
		inventory.clear();
		try {
			final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
			String bugsurl = "https://music.bugs.co.kr/chart";
			Connection.Response homePage = Jsoup.connect(bugsurl).method(Connection.Method.GET).userAgent(USER_AGENT)
					.execute();
			Document temp = homePage.parse();
			Elements thumbnail = temp.select("a.thumbnail");
			Elements title = temp.select("p.title");
			Elements artist = temp.select("p.artist");
			HashMap<String, String> map = null;
		
			for (int i=0; i < title.size(); i++) {
				map = new HashMap<>();
				map.put("seq", string(i+1));
				map.put("title", title.get(i).text());
				map.put("artist", artist.get(i).text());
				map.put("thumbnail", thumbnail.get(i).select("img").attr("src"));
				inventory.add(map);
			}
		} catch (Exception e) {
		}
		System.out.println("********************크롤링결과********************");
		inventory.get().forEach(System.out :: println);
		return inventory.get();
	}
	
}
