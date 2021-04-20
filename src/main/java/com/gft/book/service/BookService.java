package com.gft.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gft.book.model.Book;
import com.gft.book.repository.BooksRepository;

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
	
	/*
	public String getById(Long id) {
		Optional<Book> book = books.findById(id);
		books.setStatus(StatusBook.NEW);
		titulos.save(titulo);
		
		return StatusTitulo.RECEBIDO.getDescricao();
	}
	*/
	
	/*
	public List<Titulo> filtrar(TituloFilter filtro) {
		String descricao = filtro.getDescricao() == null ? "" : filtro.getDescricao();
		return titulos.findByDescricaoContaining(descricao);	
	}
	*/
}
