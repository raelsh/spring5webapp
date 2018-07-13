package guru.springframework.spring5webapp.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.model.repositories.LibroRepository;

@Controller
public class LibroController {

	private LibroRepository libroRepo;
	
	public LibroController(LibroRepository libroRepo) {
		super();
		this.libroRepo = libroRepo;
	}
	
	@RequestMapping("/libros")
	public String getLibros(Model model) {
		model.addAttribute("libros",libroRepo.findAll());
		return "libros";	
	}
	
}
