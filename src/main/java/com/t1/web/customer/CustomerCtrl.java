package com.t1.web.customer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerCtrl {
	@Autowired Map<String, Object> map;
	@Autowired CustomerServiceImpl service;
	
	@PostMapping("/")
	public Map<?, ?> join(@RequestBody Customer param) {
		System.out.println("조인 param 값" + param.getUid()  + param.getUpw());
		service.insertCustomerJoin(param);
		map.clear();
		map.put("msg", "success");
		
		return map;
	}
	
	@PostMapping("/{uid}")
	public Customer login(@PathVariable String uid, @RequestBody Customer param) {
		System.out.println("uid 값 넘어온 결과 :" +uid);
		System.out.println("param 값 넘어온 결과" + param.getUid() + param.getUpw());
		return service.selectCustomerLogin(param);
		
		
	}
	
	

}
