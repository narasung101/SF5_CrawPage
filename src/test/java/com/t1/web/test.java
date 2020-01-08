package com.t1.web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.t1.web.proxy.Inventory;

@Component("crawler")
public class test {
	@Autowired
	static Inventory<String> box;
	
	public static void main(String[] args) {
		
		box.clear();
		
		try {
			Document rawData = Jsoup.connect
					("https://music.bugs.co.kr/recomreview?&order=listorder&page=2")
					.timeout(10*1000).get();
			Elements artist = rawData.select("div[class=review_txt]"); 
			
			for(Element e : artist) {
				box.add(e.text()+"\n ************** \n");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	System.out.println(box.get());	
	}
	

}
