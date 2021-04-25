package com.gft.book.model;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Book --- represents a user that own books.
 * @author    Diego da Silva Lourenco
 */

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="user_id")
	private long id;
	
	@NotBlank(message = "Nome de usuário é obrigatório")
	@Column(name = "username", unique = true)
	private String userName;
	
	@NotBlank
	private String hash;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private Map<Long, Book> books;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Map<Long, Book> getBooks() {
		return books;
	}

	public void setBooks(Map<Long, Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public void addBook(Book book) throws IllegalArgumentException {
		
		if (books.containsKey(book.getId())) {
			throw new IllegalArgumentException("O livro já existe para esse usuário");
		}
		
		books.put(book.getId(), book);
	}
	
}
