package com.t1.web.cmm;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.t1.web.customer.CustomerMapper;
import com.t1.web.customer.CustomerService;
import com.t1.web.customer.CustomerServiceImpl;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired CustomerServiceImpl service;
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		model.addAttribute("count", service.customerCount());
		
		return "index";
	}
	
}
