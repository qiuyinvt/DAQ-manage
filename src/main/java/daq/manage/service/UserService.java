package daq.manage.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daq.manage.model.User;

@Transactional
@Service
public class UserService extends BaseService<User, Integer> implements UserDetailsService{
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		User user = this.baseDao.selectByPrimaryKey(1);		
		return user;
	}
}
