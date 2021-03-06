package com.gft.book.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.book.model.Book;
import com.gft.book.model.GenreBook;
import com.gft.book.model.StatusBook;
import com.gft.book.repository.filter.BookFilter;
import com.gft.book.repository.filter.FieldsBookFilter;
import com.gft.book.service.BookService;

@Controller
@RequestMapping("/livros")
public class BookController {
		
	private static final String REGISTER_VIEW = "BookRegister";
	private static final String SEARCH_VIEW = "BookSearch";
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/novo")
	//@RequestMapping("/novo")
	public ModelAndView newBook() {
		ModelAndView mv = new ModelAndView(REGISTER_VIEW);
		mv.addObject(new Book());
	
		return mv;
	}
	
	@PostMapping
	public ModelAndView save(@Validated Book book, Errors errors, RedirectAttributes attributes) {
		
		ModelAndView mv = new ModelAndView();
		
		if (errors.hasErrors()) {
			mv.setViewName(REGISTER_VIEW);;
			
			return mv;
		}
		
		try {
			bookService.save(book);
			
			mv = new ModelAndView("redirect:/livros/novo");
			attributes.addFlashAttribute("message", "Livro salvo com sucesso");
			
			return mv;
	
		} catch (IllegalArgumentException error) {
			errors.rejectValue("dateInclusion", null, error.getMessage());		
			mv.setViewName(REGISTER_VIEW);
			
			return mv;
		}
	}
	
	@GetMapping
	public ModelAndView search(@ModelAttribute("filter") BookFilter bookfilter) {
		List<Book> allBooks = bookService.get(bookfilter);
		
		ModelAndView mv = new ModelAndView(SEARCH_VIEW);
		mv.addObject("books", allBooks);
		
		return mv;
	}
	
	@GetMapping("{id}")
	public ModelAndView update(@PathVariable("id") Book book) {		
		ModelAndView mv = new ModelAndView(REGISTER_VIEW);
		mv.addObject(book);
		
		return mv;
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id, RedirectAttributes attributes) {
		bookService.delete(id);
		
		attributes.addFlashAttribute("message", "Livro removido com sucesso");
		
		return "redirect:/livros";	
	}
	
	@ModelAttribute("allStatusBook")
	public List<StatusBook> allStatusBook() {
		return Arrays.asList(StatusBook.values());
	}
	
	@ModelAttribute("allGenreBook")
	public List<GenreBook> allGenreBook() {
		return Arrays.asList(GenreBook.values());
	}
	
	@ModelAttribute("allFieldsBookFilter")
	public List<FieldsBookFilter> allFieldsBookFilter() {
		return Arrays.asList(FieldsBookFilter.values());
	}
}
