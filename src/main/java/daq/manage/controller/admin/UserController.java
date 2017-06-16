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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import daq.manage.controller.BaseController;
import daq.manage.model.User;
import daq.manage.service.UserService;


@Controller
@RequestMapping(value = "admin/user")
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	
	/**
	 * 用户管理首页-用户列表页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request,
			HttpServletResponse response, Model model){
		Map<String, Object> param = this.queryPageParamInit(request,model,userService.count());
		param.put("account", request.getParameter("account"));
		List<User> entitys = userService.queryPageList(param);
		model.addAttribute("entitys", entitys);
		model.addAttribute("account", request.getParameter("account"));
		return "/admin/user/list";
	}
	
	/**
	 * 编辑页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/up")
	public String up(@RequestParam Integer id, Model model){
		User entity = userService.selectByPrimaryKey(id);
		model.addAttribute("entity", entity);
		return "/admin/user/up";
	}
	
	@RequestMapping(value = "/save")
	public @ResponseBody Map<String,Object> save(@RequestParam Integer id,@RequestParam String name ,@RequestParam String account
			,@RequestParam String password){
		JSONObject json = new JSONObject();
		json.put("success", true);
		json.put("url", "/admin/user/list");
		User entity = new User();
		entity.setId(id);
		entity.setAccount(account);
		entity.setName(name);
		entity.setPassword(password);
		userService.updateByPrimaryKeySelective(entity);;
		return json;
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
