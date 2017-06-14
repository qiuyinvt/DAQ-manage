package daq.manage.controller;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "test")
public class TestController {
	
	@RequestMapping(value = "test")
	public void test(HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv){
		System.out.println(request.getProtocol());
		Enumeration<Object> names = request.getParameterNames();
		String name = null ;
		while(names.hasMoreElements()){			
			name = names.nextElement().toString();
			System.out.println(new Date());
			System.out.println("name="+ name + " value=" + request.getParameter(name));
		}
	}
}
