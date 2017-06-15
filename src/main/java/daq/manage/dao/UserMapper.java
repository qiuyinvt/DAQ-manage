package daq.manage.dao;

import java.util.List;

import daq.manage.model.User;

public interface UserMapper extends BaseDao<User, Integer>{	
	public User getUserByAccount(String account);
	
	public User getUserByLogin(String account,String password);
	
	public List<User> getAllList();
	
	public void updateEnabled(Integer id,Boolean enabled);
	
	public void updateIsSend(Integer id,Boolean isSend);
}
