package daq.manage.dao;

import java.util.List;

import daq.manage.model.User;

public interface UserMapper extends BaseDao<User, Integer>{	
	/**
	 * 根据账号获取用户
	 * @param account
	 * @return
	 */
	public User getUserByAccount(String account);
	/**
	 * 根据账号密码获取用户
	 * @param account
	 * @param password
	 * @return
	 */
	public User getUserByLogin(String account,String password);
	
	public List<User> getAllList();
	
	/**
	 * 修改用户状态
	 * @param id
	 * @param enabled
	 */
	public void updateEnabled(Integer id,Boolean enabled);
	
	/**
	 * 修改是否发送短信
	 * @param id
	 * @param isSend
	 */
	public void updateIsSend(Integer id,Boolean isSend);
	
	/**
	 * 获取需要发送短信的用户列表
	 * @return
	 */
	public List<User> getSendList();
}
