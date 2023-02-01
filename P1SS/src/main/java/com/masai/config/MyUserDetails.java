package com.masai.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.masai.bean.Employee;

public class MyUserDetails implements UserDetails {
	
	private Employee emp;
	

	public MyUserDetails(Employee empfromdb) {
		this.emp = empfromdb;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
//		
//        grantedAuthorityList.add(new SimpleGrantedAuthority(emp.getRole()));
//
//        return grantedAuthorityList;
		
		Collection<GrantedAuthority> authorities=new ArrayList<>();
		
		SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(emp.getRole());
		
		authorities.add(simpleGrantedAuthority);
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return emp.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return emp.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
