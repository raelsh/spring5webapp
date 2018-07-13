package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.model.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long> {

}
	