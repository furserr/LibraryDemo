package com.example.demo.author;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.book.Book;

@Entity
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long author_id;
	
	@Column(name = "yazaradi")
	private String yazaradi;
	
	@Column(name = "aciklama")
	private String aciklama;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ab_fid", referencedColumnName = "author_id")
	List<Book> book = new ArrayList<>();
	
	
	public Author() {
		
	}
	
	public Author(String yazaradi, String aciklama) {
		super();
		this.yazaradi = yazaradi;
		this.aciklama = aciklama;
	}

	public Long getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}

	public String getYazaradi() {
		return yazaradi;
	}

	public void setYazaradi(String yazaradi) {
		this.yazaradi = yazaradi;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	

}