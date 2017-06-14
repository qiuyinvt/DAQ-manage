package daq.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
