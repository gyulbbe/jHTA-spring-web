package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.Product;

@Mapper
public interface ProductMapper {

	List<Product> getProducts(@Param("condition") Map<String, Object> condition);
	Product getProductByNo(@Param("no") int no);
}