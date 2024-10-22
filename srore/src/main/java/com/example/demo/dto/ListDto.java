package com.example.demo.dto;

import java.util.List;

import com.example.demo.util.Pagination;

public class ListDto<T> {
	// 목록화면 표시되는 데이터다.
	List<T> data;
	// 목록화면서 표시되는 페이징처리정보다.
	Pagination paging;
	
	public ListDto(List<T> data, Pagination paging) {
		this.data = data;
		this.paging = paging;
	}
	
	public List<T> getData(){
		return data;
	}
	
	public Pagination getPaging() {
		return paging;
	}
}
