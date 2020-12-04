package com.example.demo.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.author.Author;
import com.example.demo.author.AuthorService;
import com.example.demo.publisher.Publisher;
import com.example.demo.publisher.PublisherService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private PublisherService publisherService;

	@RequestMapping("/")
	public String index(Model model, @Param("search") String search) {
		List<Book> listBooks = service.listAll(search);
		model.addAttribute("listBooks", listBooks);
		return "index";
	}
	
	@RequestMapping("/new")
	public String newBook(Model model) {
		Book book = new Book();
		List<Author> authors = authorService.listAll();
		List<Publisher> publishers = publisherService.listAll();
		model.addAttribute("book", book);
		model.addAttribute("authors", authors);
		model.addAttribute("publishers", publishers);
		return "newBook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") Book book) {
		service.save(book);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editBook(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("editBook");
		
		Book book = service.get(id);
		mav.addObject("book", book);
		
		List<Author> authors = authorService.listAll();
		List<Publisher> publishers = publisherService.listAll();
		mav.addObject("authors", authors);
		mav.addObject("publishers", publishers);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable(name = "id") Long id) {
		service.delete(id);
		
		return "redirect:/";
	}
}
