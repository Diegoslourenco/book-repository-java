package com.gft.book.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 * Book --- represents a book in the repository.
 * @author    Diego da Silva Lourenco
 */

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Título é obrigatório")
	@Size(max = 60, message = "O título não pode conter mais de 60 caracteres")
	private String title;

	@NotBlank(message = "Autor é obrigatório")
	@Size(max = 40, message = "O nome do autor não pode conter mais de 40 caracteres")
	private String author;
	
	@Enumerated(EnumType.STRING) 
	private GenreBook genre;
	
	@Enumerated(EnumType.STRING) 
	private StatusBook status;
	
	@NotNull(message = "Data de inclusão é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "date_inclusion")
	private Date dateInclusion;
	
	@NotNull(message = "Avaliação é obrigatória")
	@DecimalMin(value = "0.1", message = "Avaliação não pode ser menor que 0,1")
	@DecimalMax(value = "10.0", message = "Avaliação não pode ser maio que 10,0")
	@NumberFormat(pattern = "#,#0.0")
	private BigDecimal rate;
	
	@NotNull(message = "Preço é obrigatório")
	@DecimalMin(value = "0.01", message = "Preço não pode ser menor que 0,01")
	@DecimalMax(value = "999999.99", message = "Preço não pode ser maio que 999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal price;
	
	@NotNull(message = "Quantidade é obrigatória")
	@Positive(message = "Quantidade deve ser maior que zero")
	private int quantity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public GenreBook getGenre() {
		return genre;
	}

	public void setGenre(GenreBook genre) {
		this.genre = genre;
	}

	public StatusBook getStatus() {
		return status;
	}

	public void setStatus(StatusBook status) {
		this.status = status;
	}

	public Date getDateInclusion() {
		return dateInclusion;
	}

	public void setDateInclusion(Date dateInclusion) {
		this.dateInclusion = dateInclusion;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
