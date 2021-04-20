package com.gft.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.book.model.Book;

/**
 * BooksRepository --- defines methods to consult the database.
 * @author    Diego da Silva Lourenco
 */

public interface BooksRepository extends  JpaRepository<Book, Long> {
	
	public List<Book> findByTitleContaining(String title);
}
