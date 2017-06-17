package daq.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import daq.manage.annotation.CurrentUser;
import daq.manage.model.User;
import daq.manage.service.UserService;
import daq.manage.utils.JsonResult;




@Controller
@RequestMapping(value = "login")
public class LoginController {
	@Autowired
	private UserService userService;  
	
	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv){
		mv.setViewName("/login");
	//	System.out.println(userService.getAllList().size());
		return mv;
	}
	
//	@RequestMapping(value = "/login")
//	public @ResponseBody Map<String,Object> login(HttpServletRequest request,
//			HttpServletResponse response){
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("success", true);
//		map.put("url", "/admin/collect/view");
//		User user = userService.getUserByLogin(request.getParameter("account"), request.getParameter("password"));
//		if(user != null){
//			request.getSession().setAttribute("user", user);
//		}else{
//			map.put("success", false);
//			map.put("msg", "账号或密码错误!"); 
//		}
//		return map;
//	}
	
	@RequestMapping(value = "/logout",method=RequestMethod.GET)
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "/login";
    }

	@RequestMapping(value = "/profile",method=RequestMethod.GET)
    public String profile(@CurrentUser User loginUser, Model model) {
       // model.addAttribute("roleNames", membershipFacade.getRoleNames(loginUser.getRoles()));
        return "membership/profile";
    }

    @ResponseBody
    @RequestMapping(value = "/authenticate",method=RequestMethod.GET)
    public JsonResult<String> authenticate(String account, String password, boolean rememberMe, HttpServletRequest req) {
        JsonResult<String> result = new JsonResult<String>(false, "用户名/密码错误!");
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(account, password);
            token.setRememberMe(rememberMe);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            result.setSuccess(true);
            result.setUrl("/admin/collect/view");
            result.setMsg("登录成功!");
        } catch (IncorrectCredentialsException ex) {
            result.setMsg("用户名/密码错误!");
        }catch ( UnknownAccountException ex) {
            result.setMsg("用户名/密码错误!");
        } 
        
        catch (Exception ex) {
            if ("LockedAccountException".equals(ex.getClass().getSimpleName())) {
                result.setMsg("您的账号已经被锁定!");
            }
//            else if ("ExcessiveAttemptsException".equals(ex.getClass().getSimpleName())) {
//                result.setMsg("您重试密码超过10次,账号已被锁定!");
//            }
        }
        return result;
    }
}
