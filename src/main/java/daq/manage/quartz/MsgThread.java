package daq.manage.quartz;

import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import daq.manage.model.User;
import daq.manage.service.UserService;

/**
 * 定时推送数值
 * @author linj
 *
 */
public class MsgThread {
	@Autowired
	private UserService userService;

	public void start() {
//		System.out.println("dddd");
//		List<User> users = userService.getSendList();
//		for(User user:users){
//			//System.out.println(user.getAccount());
//		}
	}

}
