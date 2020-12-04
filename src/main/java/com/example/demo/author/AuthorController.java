package com.example.demo.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService service;
	
	@RequestMapping("/newAuthor")
	public String newBook(Model model) {
		Author author = new Author();
		model.addAttribute("author", author);
		
		List<Author> listAuthors = service.listAll();
		model.addAttribute("listAuthors", listAuthors);
		return "newAuthor";
	}
	
	@RequestMapping(value = "/saveAuthor", method = RequestMethod.POST)
	public String saveAuthor(@ModelAttribute("author") Author author) {
		service.save(author);
		
		return "redirect:/";
	}
	
	@RequestMapping("/editAuthor/{author_id}")
	public ModelAndView editAuthor(@PathVariable(name = "author_id") Long author_id) {
		ModelAndView mav = new ModelAndView("editAuthor");
		
		Author author = service.get(author_id);
		mav.addObject("author", author);
		return mav;
	}
	
	@RequestMapping("/deleteAuthor/{id}")
	public String deleteAuthor(@PathVariable(name = "id") Long id) {
		service.delete(id);
		
		return "redirect:/";
	}
}
