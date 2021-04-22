package com.gft.book.repository.filter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * BookFilter --- represents the text in the search for a book in the repository.
 * @author    Diego da Silva Lourenco
 */

public class BookFilter {
	
	private String text;
	
	@Enumerated(EnumType.STRING) 
	private FieldsBookFilter field;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public FieldsBookFilter getField() {
		return field;
	}

	public void setField(FieldsBookFilter field) {
		this.field = field;
	}
	
}
