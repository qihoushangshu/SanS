package com.sixdog.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sixdog.dto.User;
import com.sixdog.mapper.UserMapper;



@Controller
public class Ss1Controller {
	
	/** Logger实例 */
	static final Logger logger = LoggerFactory.getLogger(Ss1Controller.class);

	@Autowired
	UserMapper userMapper;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public String add(@RequestBody @Validated User user, BindingResult bindingResult) {
		logger.info("-----add-------开始-----------");
		String flag = "success";
		if (bindingResult.hasErrors()) {
	        // 具体的处理逻辑，如封装错误信息等
			System.out.println(bindingResult.getFieldError().getDefaultMessage());
			
			logger.info("---------add ----结束---");
			flag = "fail";
			return "{\"status\":\""+flag+"\",\"errmsg\":\""+bindingResult.getFieldError().getDefaultMessage()+"\"}";
			
	    }
		
		try {
		userMapper.saveUser(user);
		}catch(Exception e) {
			flag = "fail";
		}
		logger.info("---------add ----结束---");
		return "{\"status\":\""+flag+"\"}";
		
	}
	
	
	
}
