package daq.manage.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import daq.manage.controller.BaseController;
import daq.manage.model.Collect;
import daq.manage.model.User;
import daq.manage.service.CollectService;
import daq.manage.utils.DateUntil;

@Controller
@RequestMapping(value = "admin/collect")
public class CollectController extends BaseController{
	@Autowired
	private CollectService collectService;
	
	@RequestMapping(value = "/view")
	public ModelAndView test(HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv){	
		mv.setViewName("/admin/collect/index");
		return mv;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv=new ModelAndView("/admin/collect/collectList");
//		System.out.println(loginUser);
		Map<String, String> map =new HashMap<String, String>();
		Map<String, Object> param = this.queryPageParamInit(request,mv,collectService.getTotal(map));
		List<Collect> entitys = collectService.queryPageList(param);
		return mv.addObject("entitys", entitys);
	}	
	
	@RequestMapping(value="/data",method=RequestMethod.POST)
	@ResponseBody
	public Object getData(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, String> map =new HashMap<String, String>();
		List<Collect> list=collectService.getALLCollect(map);
		JSONObject obj=new JSONObject();
		JSONArray XYZ_1=new JSONArray();
		JSONArray XYZ_2=new JSONArray();
		JSONArray SINGAL_1=new JSONArray();
		JSONArray SINGAL_2=new JSONArray();
		
		for (int i = 0; i < list.size(); i++) {
			Collect collect=list.get(i);
			JSONArray array=new JSONArray();
			array.add(0, DateUntil.date2Str(collect.getCreated(),DateUntil.NORMAL_FORMAT1));
			array.add(1, collect.getValue());
			if("XYZ_1".equals(collect.getType()))
			{
				XYZ_1.add(array);
			}
			if("XYZ_2".equals(collect.getType()))
			{
				XYZ_2.add(array);
			}
			if("SINGAL_1".equals(collect.getType()))
			{
				SINGAL_1.add(array);
			}
			if("SINGAL_2".equals(collect.getType()))
			{
				SINGAL_2.add(array);
			}
		}
		obj.put("XYZ_1", XYZ_1);
		obj.put("XYZ_2", XYZ_2);
		obj.put("SINGAL_1", SINGAL_1);
		obj.put("SINGAL_2", SINGAL_2);
		return obj;
	}
	
	public static void main(String[] args) {
		JSONObject obj=new JSONObject();
		JSONArray arrays=new JSONArray();
		for (int i = 0; i < 20; i++) {
			JSONArray array=new JSONArray();
			Date nowTime=new Date();
			Date berforeTime=DateUntil.DateMinute(nowTime, i, true);
			array.add(0, DateUntil.date2Str(berforeTime,DateUntil.NORMAL_FORMAT1));
			array.add(1, i);
			arrays.add(i,array);
		}
		obj.put("XYZ_1", arrays);
		System.out.println(obj);
	}
}
