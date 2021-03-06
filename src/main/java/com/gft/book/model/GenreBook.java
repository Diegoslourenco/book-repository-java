package com.gft.book.model;

/**
 * GenreBook --- contains the possible genres for a book.
 * @author    Diego da Silva Lourenco
 */

public enum GenreBook {
	
	ART("Arte"),
	CRIME("Crime"),
	FANTASY("Fantasia"),
	FICTION("Ficção"),
	HISTORY("História"),
	HORROR("Horror"),
	ROMANCE("Romance"),
	THRILLER("Suspense"),
	TRAVEL("Viagem");
	
	private String description;

	GenreBook(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
