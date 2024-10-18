package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.Book;

@Mapper
public interface BookMapper {

	List<Book> getAllBooks();
	void insertBook(@Param("book") Book book);
	Book getBookByNo(@Param("no") int no);
	Book updateBookByNo(@Param("no") int no);
	void deleteBookByNo(@Param("no") int no);
}
