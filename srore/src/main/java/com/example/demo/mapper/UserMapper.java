package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.User;
import com.example.demo.vo.UserRole;

@Mapper
public interface UserMapper {
	
	User getUserByEmail(@Param("email") String eamil);
	User getUserByNo(@Param("no") int no);
	void insertUser(@Param("user") User user);
	void insertUserRole(@Param("userRole") UserRole userRole);
}
