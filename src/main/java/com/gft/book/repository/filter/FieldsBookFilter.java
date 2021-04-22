package com.gft.book.repository.filter;

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
