package daq.manage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class BaseController {
	
	/*
	 * 分页查询默认一次查询的数据量
	 */
	private static int PAGE_LIMIT = 10;
	
	private static int PAGE_SIZE = 5;
	
	/**
	 * 分页处理
	 */
	public Map<String, Object> queryPageParamInit(HttpServletRequest request,Model model,int count){
		Map<String, Object> param = new HashMap<String, Object>();
		int page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")):1;
		param.put("PAGE_LIMIT", PAGE_LIMIT);	
		param.put("PAGE_INDEX", page);
		int countPage = count/PAGE_LIMIT;
		if(count % PAGE_LIMIT >0){
			countPage++;
		}
		List<String> pagination = new ArrayList<String>();
		int start = page - PAGE_SIZE;
		start = page <= PAGE_SIZE ? 1 : start; 
		start = page > countPage - PAGE_SIZE ? countPage - 2 * PAGE_SIZE: start; 
		if(start < 1){
			start = 1;
		}
		for(int i=start ; i < start + PAGE_SIZE * 2 + 1 ;i++){	
			if(i <= countPage){
				pagination.add("" + i);			
			}
		}	
		model.addAttribute("pagination", pagination);
		model.addAttribute("page", page);
		model.addAttribute("PAGE_COUNT", countPage);
		return param;
	}
}
