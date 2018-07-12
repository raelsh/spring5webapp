package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Autor;
import guru.springframework.spring5webapp.model.Libro;
import guru.springframework.spring5webapp.model.repositories.AutorRepository;
import guru.springframework.spring5webapp.model.repositories.LibroRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AutorRepository autorRepo;
	private LibroRepository libroRepo;
	
		
	public DevBootstrap(AutorRepository autorRepo, LibroRepository libroRepo) {
		super();
		this.autorRepo = autorRepo;
		this.libroRepo = libroRepo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
	}
	
	private void initData() {
		//Raul
		Autor raul= new Autor("Raúl","Segura");
		Libro libro1 = new Libro("tit 1", "isbn 1", "pub 1");
		raul.getLibros().add(libro1);
		libro1.getAutores().add(raul);
		
		autorRepo.save(raul);
		libroRepo.save(libro1);
		//Ana
		Autor ana= new Autor("Ana","Llelhy");
		Libro libro2 = new Libro("tit 2", "isbn 2", "pub 2");
		ana.getLibros().add(libro2);
		

		autorRepo.save(ana);
		libroRepo.save(libro2);
		//libro2.getAutores().add(ana);
		
		
	}

	
}
