package com.gft.book.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.book.model.Book;
import com.gft.book.model.GenreBook;
import com.gft.book.model.StatusBook;
import com.gft.book.service.BookService;

@Controller
@RequestMapping("/livros")
public class BookController {
		
	private static final String REGISTER_VIEW = "BookRegister";
	
	@Autowired
	private BookService bookService;
	
	/**
	 * Mapeia a url em que sera apresentado o arquivo html.
	 * 
	 * @return nome do arquivo html e enum contendo todos os status possiveis de um titulo.
	 */
	
	@RequestMapping("/novo")
	public ModelAndView newBook() {
		ModelAndView mv = new ModelAndView(REGISTER_VIEW);
		mv.addObject(new Book());
	
		return mv;
	}
	
	/**
	 * Converte os dados da requisicao num objeto Titulo e tenta salvar no banco de dados.
	 * Caso existam erros, retorna o nome do arquivo html
	 * Caso o salvamento ocorra com sucesso, apresenta a mensagem de sucesso e redireciona para uma url
	 * @param dados da requisicao que Spring converte para objeto Titulo e valida conforme parametros estabelecidos.
	 * @return string contendo nome do arquivo html ou url para redirecionamento.
	 */
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated Book book, Errors errors, RedirectAttributes attributes) {
		
		if (errors.hasErrors()) {
			return REGISTER_VIEW;
		}
		
		try {
			bookService.save(book);	
			
			attributes.addFlashAttribute("message", "Livro salvo com sucesso");
			return "redirect:/livros/novo";
		} catch (IllegalArgumentException error) {
			errors.rejectValue("dateInclusion", null, error.getMessage());
			return REGISTER_VIEW;
		}
	}
	
	/**
	 * Apresenta a pagina de pesquisa de titulos.
	 * @return objeto MOdelAndView contendo o nome do arquivo html e uma lista com todos os titulos cadastrados.
	 */
	
	/*
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") TituloFilter filtro) {	
		List<Titulo> todosTitulos = cadastroTituloService.filtrar(filtro);
		
		
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos);
		
		return mv;
	}
	*/
	
	/**
	 * Busca no banco de dados o objeto a partir do codigo fornecido e retorna isso para a view.
	 * @param recebe o codigo do Titulo a ser editado.
	 * @return string contendo nome do arquivo html ou url para redirecionamento.
	 */
	
	@RequestMapping("{id}")
	public ModelAndView update(@PathVariable("id") Book book) {		
		ModelAndView mv = new ModelAndView(REGISTER_VIEW);
		mv.addObject(book);
		
		return mv;
	}
	
	/**
	 * Busca no banco de dados o objeto a partir do codigo fornecido e retorna isso para a view.
	 * @param recebe o codigo do Titulo a ser editado.
	 * @return string contendo nome do arquivo html ou url para redirecionamento.
	 */
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id, RedirectAttributes attributes) {
		bookService.delete(id);
		
		attributes.addFlashAttribute("message", "Livro removido com sucesso");
		
		return "redirect:/livros";	
	}
	
	/*
	@RequestMapping(value = "/{codigo}/receber", method = RequestMethod.PUT)
	public @ResponseBody String receber(@PathVariable Long codigo) {
		
		return cadastroTituloService.receber(codigo);
	}
	*/
	
	/**
	 * Disponibiliza conjunto de elementos presentes no model no enum StatusTitulo para a view
	 * 
	 * @return lista contendo todos os status possiveis para titulo.
	 */
	
	@ModelAttribute("allStatusBook")
	public List<StatusBook> allStatusBook() {
		return Arrays.asList(StatusBook.values());
	}
	
	@ModelAttribute("allGenreBook")
	public List<GenreBook> allGenreBook() {
		return Arrays.asList(GenreBook.values());
	}	
}
