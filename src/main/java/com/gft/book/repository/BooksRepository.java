package com.gft.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.book.model.Book;

public interface BooksRepository extends  JpaRepository<Book, Long> {
	
	public List<Book> findByTitleContaining(String title);

	public List<Book> findByAuthorContaining(String author);
}
