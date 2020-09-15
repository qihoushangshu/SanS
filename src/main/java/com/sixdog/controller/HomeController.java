package com.sixdog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sixdog.util.CSVUtil;


@RestController
public class HomeController {

	/** Logger实例 */
	static final Logger logger = LoggerFactory.getLogger(SayController.class);

	@RequestMapping(path = "/getSay",method = RequestMethod.GET)
	@ResponseBody
	public List<String[]> getSayWords() {
		List<String[]> list = new ArrayList<String[]>();
		try {
			list = CSVUtil.readCSV();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	@DeleteMapping(path = "/homeDelete")
	@ResponseBody
	public boolean homeDelete(@RequestBody Map<String,Object> sayInfo) {
		logger.info("yyyyyy----"+sayInfo.get("id"));
		boolean isSuccess = false;
		boolean deleteFlag = false;
		int index = 0;
		String id = (String) sayInfo.get("id");
		try {
			List<String[]> sayInfoList = CSVUtil.readCSV();
			for(int i=0,length=sayInfoList.size();i<length;i++) {
				if(sayInfoList.get(i)[0]==id || id.equals(sayInfoList.get(i)[0])) {
					logger.info("--------");
					deleteFlag = true;
					index = i;
					break;
				}
			}
			if(deleteFlag) {
				sayInfoList.remove(index);
			}
			isSuccess = CSVUtil.createCsv(sayInfoList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
		
	}
}
