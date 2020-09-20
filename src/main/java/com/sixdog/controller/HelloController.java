package com.sixdog.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



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
	
	@RequestMapping("addJump")
	public String addJump() {
		logger.info("-----addJump-------开始-----------");
		return "ss1/add";
		
	}
	
}
