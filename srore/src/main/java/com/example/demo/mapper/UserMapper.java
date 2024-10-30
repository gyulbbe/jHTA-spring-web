package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.Role;
import com.example.demo.vo.User;
import com.example.demo.vo.UserRole;

@Mapper
public interface UserMapper {
	
	User getUserByEmail(@Param("email") String email);
	User getUserByNo(@Param("no") int no);
	List<Role> getRolesByUserNo(@Param("userNo") int userNo);
	
	void insertUser(@Param("user") User user);
	void insertUserRole(@Param("userRole") UserRole userRole);
}
