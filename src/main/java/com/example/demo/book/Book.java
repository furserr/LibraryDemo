package com.example.demo.book;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.author.Author;
import com.example.demo.publisher.Publisher;

@Entity
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String kitapadi;
	private String kitapalt;
	private Long kitapseri;
	private Long isbn;
	private String aciklama;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ab_fid", referencedColumnName = "author_id")
	private Author author;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pb_fid", referencedColumnName = "id")
	private Publisher publisher;
	

	public Book() {
		
	}
	
	public Book(String kitapadi, String kitapalt, Long kitapseri, Long isbn, String aciklama, String yazar,
			String yayinevi) {
		super();
		this.kitapadi = kitapadi;
		this.kitapalt = kitapalt;
		this.kitapseri = kitapseri;
		this.isbn = isbn;
		this.aciklama = aciklama;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKitapadi() {
		return kitapadi;
	}

	public void setKitapadi(String kitapadi) {
		this.kitapadi = kitapadi;
	}

	public String getKitapalt() {
		return kitapalt;
	}

	public void setKitapalt(String kitapalt) {
		this.kitapalt = kitapalt;
	}

	public Long getKitapseri() {
		return kitapseri;
	}

	public void setKitapseri(Long kitapseri) {
		this.kitapseri = kitapseri;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	
	
	
}