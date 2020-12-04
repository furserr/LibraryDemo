package com.example.demo.publisher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository repo;
	
	public List<Publisher> listAll() {
		return repo.findAll();
	}
	
	public void save(Publisher publisher) {
		repo.save(publisher);
	}
	
	public Publisher get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
