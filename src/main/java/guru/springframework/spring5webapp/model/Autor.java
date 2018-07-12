package guru.springframework.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String Nombre;
	private String Apellidos;
	
	@ManyToMany(mappedBy="Autores")
	private Set<Libro> Libros = new HashSet<>();

	public Autor() {
		
	}
	
	public Autor(String nombre, String apellidos) {
	this.Nombre = nombre;
	this.Apellidos=apellidos;
	}

	public Autor(String nombre, String apellidos, Set<Libro> libros) {
	this.Nombre = nombre;
	this.Apellidos=apellidos;
	this.Libros=libros;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public Set<Libro> getLibros() {
		return Libros;
	}

	public void setLibros(Set<Libro> libros) {
		Libros = libros;
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
		Autor other = (Autor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Libros=" + Libros + "]";
	}

	
}
