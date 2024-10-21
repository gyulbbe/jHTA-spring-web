package com.example.demo.vo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Alias("Product")
public class Product {

	private int no;
	private String name;
	private String maker;
	private int price;
	private int discountPrice;
	private int stock;
	private int reviewCnt;
	private String sell;
	private Date createdDate;
	private Date updatedDate;
	private Category category;
}
