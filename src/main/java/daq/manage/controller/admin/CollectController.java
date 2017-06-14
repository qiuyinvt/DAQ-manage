package daq.manage.controller.admin;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JacksonInject;

import daq.manage.service.CollectService;

@Controller
@RequestMapping(value = "admin")
public class CollectController {
	@Autowired
	private CollectService collectService;
	
	@RequestMapping(value = "/view")
	public ModelAndView test(HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv){
		System.out.println(collectService.selectByPrimaryKey(1l).getValue());
		mv.setViewName("/admin/collect/index");
		return mv;
	}
}
