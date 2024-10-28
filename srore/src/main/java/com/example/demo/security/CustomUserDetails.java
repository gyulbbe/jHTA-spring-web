package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.vo.Role;
import com.example.demo.vo.User;

public class CustomUserDetails extends LoginUser implements UserDetails {

	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public CustomUserDetails(User user, List<Role> roles) {
		super(user.getNo(), user.getEmail(), user.getNickname());
		this.username = user.getEmail();
		this.password = user.getPassword();
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		for (Role role : roles) {
			list.add(new SimpleGrantedAuthority(role.getName()));
		}
		this.authorities = list;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}
}