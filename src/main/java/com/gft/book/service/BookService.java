package com.gft.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gft.book.model.Book;
import com.gft.book.repository.BooksRepository;
import com.gft.book.repository.filter.BookFilter;

@Service
public class BookService {
	
	@Autowired
	private BooksRepository books;
	
	public void save(Book book) {
		try {
			books.save(book);
		} catch (DataIntegrityViolationException error) {
			throw new IllegalArgumentException("Formato de data inválido");
		}	
	}

	public void delete(Long id) {
		books.deleteById(id);		
	}
	
	public List<Book> get(BookFilter bookFilter) {
		if (bookFilter.getTitle() == null) {
			return books.findAll();
		}
		
		return books.findByTitleContaining(bookFilter.getTitle());
	}
}
