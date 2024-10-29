package com.example.demo.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.ProductService;
import com.example.demo.dto.ListDto;
import com.example.demo.vo.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public String list(@RequestParam(name = "page", required = false, defaultValue = "1") int page
						, @RequestParam(name = "rows", required = false, defaultValue = "10") int rows
						, @RequestParam(name = "sort", required = false, defaultValue = "date") String sort
						, @RequestParam(name = "opt", required = false) String opt
						, @RequestParam(name = "value", required = false) String value
						, Model model) {
		Map<String, Object> condition = new HashMap<>();
		condition.put("page", page);
		condition.put("rows", rows);
		condition.put("sort", sort);
		if (StringUtils.hasText(value)) {
			condition.put("opt", opt);
			condition.put("value", value);
		}
		
		ListDto<Product> dto = productService.getAllProducts(condition);
		model.addAttribute("products", dto.getData());
		model.addAttribute("paging", dto.getPaging());
		return "product/list";
	}
	
	@GetMapping("/detail")
	public String detail(int no, Model model) {
		Product product = productService.getProductByNo(no);
		model.addAttribute("product", product);
		return "product/detail";
	}
}
