package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.Category;

@Mapper
public interface CategoryMapper {

	List<CategoryMapper> getAllCategories();
	Category getCategoryByNo(@Param("no") int no);
}
