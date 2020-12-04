package com.example.demo.publisher;

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
@Table(name = "publisher")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "yayineviadi")
	private String yayineviadi;
	
	@Column(name = "aciklama")
	private String aciklama;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pb_fid", referencedColumnName = "id")
	public List<Book> book = new ArrayList<>();
	
	
	public Publisher() {
		
	}
	
	public Publisher(String yayineviadi, String aciklama) {
		super();
		this.yayineviadi = yayineviadi;
		this.aciklama = aciklama;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYayineviadi() {
		return yayineviadi;
	}

	public void setYayineviadi(String yayineviadi) {
		this.yayineviadi = yayineviadi;
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