package com.example.demo.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class Book {

	private int no;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String pubDate;
	private int stock;
	private int discountPrice;
}
