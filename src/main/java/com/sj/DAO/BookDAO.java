package com.sj.DAO;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sj.service.Book;
@Repository
public interface BookDAO {
	
	
	
	
	
	public Book createBook(Book book); 
		public List<Book> showAll();
	
}

