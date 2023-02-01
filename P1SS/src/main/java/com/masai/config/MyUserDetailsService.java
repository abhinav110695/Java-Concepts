package com.masai.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.bean.Employee;
import com.masai.repository.EmployeeRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private EmployeeRepo er;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Employee e=er.findByUserName(username);
		if(e!=null) {
			return new MyUserDetails(e);
		}
		else
			throw new UsernameNotFoundException("not found");
	}

}
