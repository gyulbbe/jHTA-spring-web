package com.example.demo.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRegisterForm;
import com.example.demo.exception.AlreadyUsedEmailException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.User;
import com.example.demo.vo.UserRole;

@Service
@Transactional
public class UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 이메일을 전달받아서 존재여부를 체크하는 서비스다.
	 * @param email 이메일
	 * @return 이메일이 존재하면 true를 반환한다.
	 */
	public boolean isExistEmail(String email) {
		User user = userMapper.getUserByEmail(email);
		return user != null;
	}
	
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

		// 비밀번호를 암호화한다.
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		
		// 회원정보를 테이블에 저장시킨다.
		userMapper.insertUser(user);
		// User -> {no=0, email=hong@gmail.com, password=zxcv1234, ...}
		
		addUserRole(user.getNo(), "ROLE_USER");
		// User -> {no=23, email=hong@gmail.com, password=zxcv1234, ...}
		
		// 신규 회원의 권한정보를 테이블에 저장시킨다.
		// 신규 회원은 ROLE_USER권한을 가진다.
//		UserRole userRole = new UserRole(user.getNo(), "ROLE_USER");
//		userMapper.insertUserRole(userRole);
	}
	
	/**
	 * 
	 * @param userNo
	 * @param roleName
	 */
	public void addUserRole(int userNo, String roleName) {
		UserRole userRole = new UserRole(userNo, roleName);
		userMapper.insertUserRole(userRole);
	}
}
