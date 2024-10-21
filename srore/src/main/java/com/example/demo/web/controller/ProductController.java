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
import com.example.demo.vo.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public String list(@RequestParam(name = "page", required = false, defaultValue = "1") int page
						, @RequestParam(name = "rows", required = false, defaultValue = "10") int rows
						, @RequestParam(name = "opt", required = false) String opt
						, @RequestParam(name = "value", required = false) String value
						, Model model) {
		Map<String, Object> condotion = new HashMap<>();
		condotion.put("page", page);
		condotion.put("rows", rows);
		if (StringUtils.hasText(value)) {
			condotion.put("opt", opt);
			condotion.put("value", value);
		}
		
		List<Product> products = productService.getAllProducts(condotion);
		model.addAttribute("products", products);
		return "product/list";
	}
	
	@GetMapping("/detail")
	public String detail(int no, Model model) {
		Product product = productService.getProductByNo(no);
		model.addAttribute("product", product);
		return "product/detail";
	}
}
