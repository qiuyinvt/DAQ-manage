package daq.manage.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import daq.manage.controller.BaseController;
import daq.manage.model.User;
import daq.manage.service.UserService;


@Controller
@RequestMapping(value = "admin/user")
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request,
			HttpServletResponse response, Model model){
		Map<String, Object> param = this.queryPageParamInit(request,model,userService.count());
		List<User> entitys = userService.queryPageList(param);
		model.addAttribute("entitys", entitys);
		return "/admin/user/list";
	}
	
	@RequestMapping(value = "/enabled")
	public String enabeld(@RequestParam Integer id){
		userService.updateEnabled(id, true);
		return "redirect:/admin/user/list";
	}
	
	@RequestMapping(value = "/disabled")
	public String disabled(@RequestParam Integer id){
		userService.updateEnabled(id, false);
		return "redirect:/admin/user/list";
	}
	
	@RequestMapping(value = "/send")
	public String send(@RequestParam Integer id){
		userService.updateIsSend(id, true);
		return "redirect:/admin/user/list";
	}
	
	@RequestMapping(value = "/noSend")
	public String noSend(@RequestParam Integer id){
		userService.updateIsSend(id, false);
		return "redirect:/admin/user/list";
	}
}
