package com.sixdog.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class HelloController {

	@Value("${userName}")
	private String userName;
	/** Logger实例 */
	static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(value= {"/","/index"})
	public String index(Model model) {
		logger.info("-----hello-------开始-----------");
		model.addAttribute("userName", userName);
		return "index";
		
	}
	
	@RequestMapping("hello")
	public String hello(Map<String,Object> map) {
		logger.info("-----hello-------开始-----------");
		map.put("msg", "hello");
		return "hello";
		
	}
	
}
