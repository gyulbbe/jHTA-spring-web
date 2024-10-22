package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Service.ProductService;
import com.example.demo.dto.ListDto;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.util.Pagination;
import com.example.demo.vo.Product;

@SpringBootTest
public class ProductServiceTests {

	@Autowired
	ProductService productService;
	@Autowired
	ProductMapper productMapper;
	
	@BeforeEach
	public void setup() {
		// 테스트에 사용할 더미 데이터를 저장하기
	}

	@AfterEach
	public void teardown() {
		// 테스트에 사용된 더미 데이터를 삭제하기
	}
	
	@Test
	public void testGetAllProducts() {
		Map<String, Object> condition = new HashMap<>();
		condition.put("page", 1);
		condition.put("rows", 10);
		condition.put("sort", "date");
		condition.put("opt", "name");
		condition.put("value", "갤럭시");
		
		ListDto<Product> dto = productService.getAllProducts(condition);
		List<Product> products = dto.getData();
		Pagination paging = dto.getPaging();
		
		assertThat(products.size()).isGreaterThan(0);
		assertEquals(paging.getTotalRows(), 69);
		assertThat(products.get(0).getMaker()).contains("갤럭시");
	}
}