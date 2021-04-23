package com.gft.book.repository.filter;


/**
 * AttributesBook --- contains the possible fields to filter a book search.
 * @author    Diego da Silva Lourenco
 */

public enum FieldsBookFilter {
	
	TITLE("Título"),
	AUTHOR("Autor");
	
	private String description;

	FieldsBookFilter(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

}
