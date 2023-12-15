package ec.edu.ups.practica.tres.IDAO;

import java.util.List;

import ec.edu.ups.practica.tres.modelo.Prestamo;

public interface IPrestamoDAO {
	//Creacion del CRUD en prestamo
	List<Prestamo> obtenerPrestamos();
	Prestamo obtenerPrestamo(int numeroPrestamo);
	void crearPrestamo(Prestamo prestamo);
	boolean actualizarPrestamo(int numeroPrestamo, Prestamo Prestamo);
	boolean eliminarPrestamo(int numeroPrestamo);

}
