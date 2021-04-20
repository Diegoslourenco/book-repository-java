package com.gft.book.model;

/**
 * Status --- contains the possible status for a book.
 * @author    Diego da Silva Lourenco
 */

public enum StatusBook {
	
	NEW("Novo"),
	USED("Usado");

	private String status;
	
	StatusBook(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
