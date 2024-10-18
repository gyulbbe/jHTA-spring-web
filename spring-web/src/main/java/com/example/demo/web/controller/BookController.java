package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.BookInsertForm;
import com.example.demo.service.BookService;
import com.example.demo.vo.Book;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "book/list";
	}
	
	@GetMapping("/add")
	public String addForm() {
		return "book/form";
	}
	
	@GetMapping("/detail")
	public String detail(int no, Model model) {
		Book book = bookService.getBookByNo(no);
		model.addAttribute("book", book);
		return "book/detail";
	}
	
	@PostMapping("/add")
	public String addBook(BookInsertForm form) {
		bookService.insertBook(form);
		return "redirect:/book/list";
	}
}
