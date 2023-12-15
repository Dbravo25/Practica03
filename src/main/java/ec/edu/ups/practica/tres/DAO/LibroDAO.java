package ec.edu.ups.practica.tres.DAO;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.practica.tres.IDAO.ILibroDAO;
import ec.edu.ups.practica.tres.modelo.Libro;

public class LibroDAO implements ILibroDAO{//implementamos la clase IDAO de Libro
	//Creamos el listado donde se guardaran los Libros simulando nuestra base de datos

	private List<Libro> listaLibros;
	//Creamos el constructor 
	public LibroDAO() {
		listaLibros = new ArrayList<>();
	}
	//retornamos la lista de libros
	@Override
	public List<Libro> obtenerLibros() {
		return listaLibros;
	}
	//Obtenemos el libro por el titulo con el equals haciendo la comparacion 
	@Override
	public Libro obtenerLibroPorTitulo(String titulo) {
		for(Libro libro : listaLibros) {
			if (libro.getTitulo().equalsIgnoreCase(titulo)) {
				return libro;
			}
		}
		return null;
	}
	//Obtenemos el libro por el autor y el año con el equals y con el getAño haciendo comparacion
	@Override
	public Libro obtenerLibroPorAutorAño(String autor, int año) {
		for(Libro libro : listaLibros) {
			if (libro.getAutor().equalsIgnoreCase(autor) && libro.getAño() ==año ) {
				return libro;
			}
		}
		return null;
	}
	//Añadimos el libro a la lista
	@Override
	public void crearLibro(Libro libro) {
		listaLibros.add(libro);
		
	}
	//Encontramos el libro con el mismo titulo e intercambiamos con el libro actualizado
	@Override
	public boolean actualizarLibro(String titulo, Libro libro) {
		for(int i = 0; i<listaLibros.size(); i++) {
			Libro libroEncontrado = listaLibros.get(i);
			//Verificamos que el titulo sea el mismo y actualizamos con set
			if(libroEncontrado.getTitulo().equalsIgnoreCase(titulo)==true) {
				listaLibros.set(i, libro);
				return true;
			}		
			
		}
		return false;
	}
	//Identificamos el libro y lo eliminamos del listado
	@Override
	public boolean eliminarLibro(String titulo) {
		//Identificamos la poscion del libro en el listado y con remove lo eliminamos
		for(int i = 0; i<listaLibros.size(); i++) {
			Libro libro = listaLibros.get(i);
			if(libro.getTitulo().equalsIgnoreCase(titulo)) {
				listaLibros.remove(i);
				return true;
			}
		}
		return false;
		
	}
	
}
