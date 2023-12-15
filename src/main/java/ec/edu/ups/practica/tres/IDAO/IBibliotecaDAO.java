package ec.edu.ups.practica.tres.IDAO;

import java.util.List;

import ec.edu.ups.practica.tres.modelo.Biblioteca;

public interface IBibliotecaDAO {
	//Creacion del CRUD en biblioteca
	List<Biblioteca> obtenerBiblioteca();
	Biblioteca obtenerBiblioteca(String nombre);
	void crearBiblioteca(Biblioteca biblioteca);
	boolean actualizarBiblioteca(String nombre, Biblioteca biblioteca);
	boolean eliminarBiblioteca(String nombre);

}
