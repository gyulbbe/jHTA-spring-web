package com.example.demo.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRegisterForm;
import com.example.demo.exception.AlreadyUsedEmailException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.User;
import com.example.demo.vo.UserRole;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 신규 사용자 정보를 전달받아서 회원가입시키는 서비스다.
	 * @param form
	 */
	public void addNewUser(UserRegisterForm form) {
		// 이메일 중복 체크
		User savedUser = userMapper.getUserByEmail(form.getEmail());
		if (savedUser != null) {
			throw new AlreadyUsedEmailException(form.getEmail());
		}
		
		User user = new User();
		BeanUtils.copyProperties(form, user);
		// User -> {no=0, email=hong@gmail.com, password=zxcv1234, ...}
		
		// 회원정보를 테이블에 저장시킨다.
		userMapper.insertUser(user);
		// User -> {no=23, email=hong@gmail.com, password=zxcv1234, ...}
		
		// 신규 회원의 권한정보를 테이블에 저장시킨다.
		// 신규 회원은 ROLE_USER권한을 가진다.
		UserRole userRole = new UserRole(user.getNo(), "ROLE_USER");
		userMapper.insertUserRole(userRole);
	}
}
