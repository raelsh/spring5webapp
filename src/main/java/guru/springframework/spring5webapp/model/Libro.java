package guru.springframework.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Libro {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String Titulo;
	private String Isbn;
	private String Publicador;

	@ManyToMany
	@JoinTable(name="autor_libro", joinColumns=@JoinColumn(name="libro_id"), 
	inverseJoinColumns=@JoinColumn(name="autor_id"))
	private Set<Autor> Autores = new HashSet<>();

	public Libro() {

	}

	public Libro(String titulo, String isbn, String publicador) {
		this.Titulo = titulo;
		this.Isbn = isbn;
		this.Publicador = publicador;
	}

	public Libro(String titulo, String isbn, String publicador, Set<Autor> autores) {
		this.Titulo = titulo;
		this.Isbn = isbn;
		this.Publicador = publicador;
		this.Autores = autores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getIsbn() {
		return Isbn;
	}

	public void setIsbn(String isbn) {
		Isbn = isbn;
	}

	public String getPublicador() {
		return Publicador;
	}

	public void setPublicador(String publicador) {
		Publicador = publicador;
	}

	public Set<Autor> getAutores() {
		return Autores;
	}

	public void setAutores(Set<Autor> autores) {
		Autores = autores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", Titulo=" + Titulo + ", Isbn=" + Isbn + ", Publicador=" + Publicador + ", Autores="
				+ Autores + "]";
	}

}
