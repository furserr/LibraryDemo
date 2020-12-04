package com.example.demo.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository repo;
	
	public List<Author> listAll() {
		return repo.findAll();
	}
	
	public void save(Author author) {
		repo.save(author);
	}
	
	public Author get(Long author_id) {
		return repo.findById(author_id).get();
	}
	
	public void delete(Long author_id) {
		repo.deleteById(author_id);
	}
}
