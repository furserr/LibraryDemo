package com.example.demo.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("SELECT b FROM Book b WHERE b.kitapadi LIKE %?1% OR b.kitapseri LIKE %?1% OR b.author.yazaradi LIKE %?1% OR b.isbn LIKE %?1%")
	public List<Book> findAll(String search);
}
