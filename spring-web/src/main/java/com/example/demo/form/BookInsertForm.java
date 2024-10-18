package com.example.demo.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class BookInsertForm {

	private int no;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String pubDate;
	private int stock;
	private int discountPrice;
}
