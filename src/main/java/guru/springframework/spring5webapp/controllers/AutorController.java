package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.AutorRepository;

@Controller
public class AutorController {
	
	private AutorRepository autorRepo;

	public AutorController(AutorRepository autorRepo) {
		super();
		this.autorRepo = autorRepo;
	}
	
	@RequestMapping("/autores")
	public String getAutores(Model model) {
		model.addAttribute("autores", autorRepo.findAll());
		return "autores";
	}
}
