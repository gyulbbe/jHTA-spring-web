package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.form.BookInsertForm;
import com.example.demo.mapper.BookMapper;
import com.example.demo.vo.Book;
import com.example.demo.vo.Employee;

@Service
public class BookService {

	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<Book> getAllBooks() {
		List<Book> books = bookMapper.getAllBooks();
		return books;
	}

	public void insertBook(BookInsertForm form) {
		Book book = modelMapper.map(form, Book.class);
		bookMapper.insertBook(book);
	}

	public Book getBookByNo(int no) {
		Book book = bookMapper.getBookByNo(no);
		return book;
	}
}
