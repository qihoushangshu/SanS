package com.sixdog.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String add(HttpServletRequest request) {
		logger.info("-----add-------开始-----------");
		String flag = "success";
		try {
		String name = request.getParameter("name");
		User u = new User();
		u.setName(name);
		userMapper.saveUser(u);
		}catch(Exception e) {
			flag = "fail";
		}
		logger.info("---------add ----结束---");
		return "{\"status\":\""+flag+"\"}";
		
	}
	
	
	
}
