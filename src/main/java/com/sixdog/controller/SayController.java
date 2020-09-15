package com.sixdog.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sixdog.util.CSVUtil;
import com.sixdog.dto.SayInfo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class SayController {


	/** Logger实例 */
	static final Logger logger = LoggerFactory.getLogger(SayController.class);

	@RequestMapping(path = "/saveSay",method = RequestMethod.POST)
	public String saveSayWords(@RequestBody SayInfo say) {
		boolean isSuccess = false;
//	    try {
//	    	List<String[]> sayInfoList = CSVUtil.readCSV();
//	    	int length = sayInfoList.size();
//	    	if (0!=length) {
//	    		sayInfoList.sort((String[] o1,String[] o2)->Integer.parseInt(o1[0])-Integer.parseInt(o2[0]));
//	    		logger.info("-----------------------------");
//	    		//sayInfoList.forEach(item->logger.info(item[0]));
//	    		
//	    		int lastId = Integer.parseInt(sayInfoList.get(length-1)[0])+1;
//	    		String sayInfo[] = {String.valueOf(lastId),say.getTitle(),say.getContent()};
//	    		sayInfoList.add(sayInfo);
//	    	}else {
//	    		String sayInfo[] = {String.valueOf(1),say.getTitle(),say.getContent()};
//	    		sayInfoList.add(sayInfo);
//	    	}
//			isSuccess = CSVUtil.createCsv(sayInfoList);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			logger.info(e.getMessage());
//		}
	    return "{\"ret\":"+isSuccess+"}";
	}
	
	@RequestMapping(path = "/test")
	public String test() {
		logger.info("--------------------------1");
		logger.debug("--------------------------2");
		logger.info("--------------------------1");
	    return "{'name','zhansgan','age','12'}";
	    
	}
}
