package ec.edu.ups.practica.tres.IDAO;

import java.util.List;

import ec.edu.ups.practica.tres.modelo.Libro;

public interface ILibroDAO {
	//Creacion del CRUD en libro
	List<Libro> obtenerLibros();
    Libro obtenerLibroPorTitulo(String titulo);
    Libro obtenerLibroPorAutorAño(String autor, int año);
    void crearLibro(Libro libro);
    boolean actualizarLibro(String titulo, Libro libro);
    boolean eliminarLibro(String titulo);
	

}
