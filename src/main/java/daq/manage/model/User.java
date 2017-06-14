package daq.manage.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails{
	private Integer id;
	
	private String account;
	
	private String password;
	
	private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	 /**权限管理*/
    private Set<String> roles = new HashSet<String>();
	
	public Set<String> getRoles() {
		return roles;
	}

	public void addRole(String role) {
		getRoles().add(role);
	}

	public void setRoles(String roles) {
		String[] arr = roles.split(",");
		for(String role : arr){
			addRole(role);
		}		
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();		
		for (String role : roles) {
			auths.add(new SimpleGrantedAuthority(role));
		}
		return auths;
	}

	public String getUsername() {
		return null;
	}

	public boolean isAccountNonExpired() {
		return false;
	}

	public boolean isAccountNonLocked() {
		return false;
	}

	public boolean isCredentialsNonExpired() {
		return false;
	}

	public boolean isEnabled() {
		return false;
	}
	
}
