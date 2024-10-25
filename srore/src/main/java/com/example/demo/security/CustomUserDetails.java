package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.vo.Role;
import com.example.demo.vo.User;

public class CustomUserDetails implements UserDetails {

	private int no;
	private String nickname;
	private String email;		// username에 해당하는 값이다.
	private String password;	// 비밀번호에 해당하는 값이다.
	private Collection<? extends GrantedAuthority> authorities;
	
	public CustomUserDetails(User user, List<Role> roles) {
		this.no = user.getNo();
		this.nickname = user.getNickname();
		this.email = user.getEmail();
		this.password = user.getPassword();
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
			authorities.add(authority);
		}
		this.authorities = authorities;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public int getNo() {
		return no;
	}
	
	// 사용자가 보유한 접근권한 정보를 반환한다.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	// 사용자의 비밀번호를 반환한다.
	@Override
	public String getPassword() {
		
		return password;
	}
	
	// 사용자를 고유하게 식별하는 정보(사용자아이디, 사용자번호, 이메일, 사원번호 등)반환한다.
	@Override
	public String getUsername() {
		
		return email;		// 우리 사이트에서는 이메일이 사용자를 식별하는 정보다.
	}
}