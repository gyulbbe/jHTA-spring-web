package com.example.demo.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.vo.Product;

@Service
public class ProductService {
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private ProductMapper productMapper;
	
	/**
	 * 모든 상품정보 목록을 제공하는 서비스 메소드다.
	 * @param condition 조회조건이 포함된 Map객체다.
	 * @return 모든 상품정보 목록
	 */
	public List<Product> getAllProducts(Map<String, Object> condition){
		List<Product> products = productMapper.getProducts(condition);
		return products;
	}
	
	/**
	 * 상품 정보를 제공하는 서비스 메소드다.
	 * @param no
	 * @return 상품 정보
	 */
	public Product getProductByNo(int no) {
		Product product = productMapper.getProductByNo(no);
		return product;
	}
}
