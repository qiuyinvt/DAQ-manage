package daq.manage.controller;

import java.util.Date;
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
import daq.manage.security.PasswordService;
import daq.manage.service.UserService;

@Controller
@RequestMapping(value = "register")
public class RegisterController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv){
		mv.setViewName("/register");
		return mv;
	}
	
	@RequestMapping(value = "/save")
	public @ResponseBody Map<String,Object> save(HttpServletRequest request,
			HttpServletResponse response){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("success", true);
		if(userService.getUserByAccount(request.getParameter("account")) != null){
			map.put("success", false);
			map.put("msg", "该账号已被注册!");
		}else{
			User user = new User();
			user.setAccount(request.getParameter("account"));
			user.setName(request.getParameter("name"));
			user.setPassword(PasswordService.getEncryptPassword(request.getParameter("password"), request.getParameter("password")));
			user.setRole("ROLE_USER");
			user.setCreated(new Date());
			user.setEnabled(true);
			user.setIsSend(false);
			user.setSalt(request.getParameter("password"));
			userService.insert(user);
			map.put("msg", "注册成功,即将跳转登录!");
			map.put("url", "/login/index");
		}
		return map;
	}
}
