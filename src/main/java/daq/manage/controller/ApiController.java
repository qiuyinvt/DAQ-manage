package daq.manage.controller;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import daq.manage.model.Collect;
import daq.manage.service.CollectService;

/**
 * 数据接口
 * @author linj
 *
 */
@Controller
@RequestMapping(value = "api")
public class ApiController {
	@Autowired
	private CollectService collectService;
	
	@RequestMapping(value = "/data")
	public void data(HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv){
		Enumeration<Object> names = request.getParameterNames();
		String name = null ;
		Collect entity = new Collect();
		while(names.hasMoreElements()){			
			name = names.nextElement().toString();
			entity.setCreated(new Date());
			entity.setType(name);
			entity.setValue(Double.parseDouble(request.getParameter(name)));
			collectService.insert(entity);
			System.out.println("name="+ name + " value=" + request.getParameter(name));
		}
	}
}
