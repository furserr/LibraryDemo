package com.example.demo.publisher;

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
public class PublisherController {
	
	@Autowired
	private PublisherService service;

	@RequestMapping("/newPublisher")
	public String newBook(Model model) {
		Publisher publisher = new Publisher();
		model.addAttribute("publisher", publisher);
		
		List<Publisher> listPublishers = service.listAll();
		model.addAttribute("listPublishers", listPublishers);
		return "newPublisher";
	}
	
	@RequestMapping(value = "/savePublisher", method = RequestMethod.POST)
	public String savePublisher(@ModelAttribute("publisher") Publisher publisher) {
		service.save(publisher);
		
		return "redirect:/";
	}
	
	@RequestMapping("/editPublisher/{id}")
	public ModelAndView editPublisher(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("editPublisher");
		
		Publisher publisher = service.get(id);
		mav.addObject("publisher", publisher);
		return mav;
	}
	
	@RequestMapping("/deletePublisher/{id}")
	public String deletePublisher(@PathVariable(name = "id") Long id) {
		service.delete(id);
		
		return "redirect:/";
	}
}
