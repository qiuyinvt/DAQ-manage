package daq.manage.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import daq.manage.model.User;
import daq.manage.service.UserService;

@Controller
@RequestMapping(value = "login")
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv){
		mv.setViewName("/login");
		System.out.println(userService.getSendList().size());
		return mv;
	}
	
	@RequestMapping(value = "/login")
	public @ResponseBody Map<String,Object> login(HttpServletRequest request,
			HttpServletResponse response){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("url", "/admin/view");
		User user = userService.getUserByLogin(request.getParameter("account"), request.getParameter("password"));
		if(user != null){
			if(user.getEnabled()){
				request.getSession().setAttribute("user", user);
			}else{
				map.put("success", false);
				map.put("msg", "该账号已被禁用，请联系管理员!");
			}
		}else{
			map.put("success", false);
			map.put("msg", "账号或密码错误!");
		}
		return map;
	}
}
