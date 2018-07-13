package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Autor;
import guru.springframework.spring5webapp.model.Editorial;
import guru.springframework.spring5webapp.model.Libro;
import guru.springframework.spring5webapp.repositories.AutorRepository;
import guru.springframework.spring5webapp.repositories.EditorialRepository;
import guru.springframework.spring5webapp.repositories.LibroRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AutorRepository autorRepo;
	private LibroRepository libroRepo;
	private EditorialRepository editorialRepo;
	
		
	public DevBootstrap(AutorRepository autorRepo, LibroRepository libroRepo, EditorialRepository editorialRepo) {
		super();
		this.autorRepo = autorRepo;
		this.libroRepo = libroRepo;
		this.editorialRepo=editorialRepo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
	}
	
	private void initData() {
		Editorial editorial1= new Editorial();
		editorial1.setDireccion("Aqui y alla");
		editorial1.setNombre("Pub1");
		editorialRepo.save(editorial1);
		
		Editorial editorial2= new Editorial();
		editorial2.setDireccion("Aqui y alla 2");
		editorial2.setNombre("Pub 2");
		editorialRepo.save(editorial2);
				
		
		//Raul
		Autor raul= new Autor("Raúl","Segura");
		Libro libro1 = new Libro("tit 1", "isbn 1", editorial1);
		raul.getLibros().add(libro1);
		libro1.getAutores().add(raul);
		
		autorRepo.save(raul);
		libroRepo.save(libro1);
		//Ana
		Autor ana= new Autor("Ana","Llelhy");
		Libro libro2 = new Libro("tit 2", "isbn 2", editorial2);
		ana.getLibros().add(libro2);
		

		autorRepo.save(ana);
		libroRepo.save(libro2);
		//libro2.getAutores().add(ana);
		
		
	}

	
}
