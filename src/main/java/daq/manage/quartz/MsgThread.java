package daq.manage.quartz;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import daq.manage.model.User;
import daq.manage.service.UserService;

/**
 * 定时推送数值
 * @author linj
 *
 */
public class MsgThread{
	@Autowired
	private UserService userService;

	public void start() {
		List<User> users = userService.getSendList();
		for(User user:users){
			//System.out.println(user.getAccount());
		}
	}
}
