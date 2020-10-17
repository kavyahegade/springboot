package com.sj.controller;

import com.sj.DAO.BookDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sj.DAO.BookDAO;
import com.sj.service.Book;

@RestController
@RequestMapping(value="/web")
public class BookController {
	
	@Autowired
	BookDAO b;
	
	@RequestMapping(value="/hi")
	public List<Book> insertBook(Book book) {
		System.out.println("in controller");
		b.createBook(book);
		return b.showAll();
	}

}
