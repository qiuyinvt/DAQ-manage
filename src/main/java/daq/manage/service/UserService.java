package daq.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daq.manage.dao.UserMapper;
import daq.manage.model.User;

@Transactional
@Service
public class UserService extends BaseService<User, Integer>{
	@Autowired
	private UserMapper userDao;
	
	public User getUserByAccount(String account){
		return userDao.getUserByAccount(account);
	}
	
	public User getUserByLogin(String account,String password){
		return userDao.getUserByLogin(account, password);
	}
	
	public List<User> getAllList(){
		return userDao.getAllList();
	}
	
	public void updateEnabled(Integer id , Boolean enabled){
		userDao.updateEnabled(id,enabled);
	}
	
	public void updateIsSend(Integer id , Boolean enabled){
		userDao.updateIsSend(id,enabled);
	}
}
