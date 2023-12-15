package ec.edu.ups.practica.tres.controlador;

import java.util.List;


import ec.edu.ups.practica.tres.IDAO.ILibroDAO;
import ec.edu.ups.practica.tres.modelo.Libro;
import ec.edu.ups.practica.tres.vista.LibroVista;

public class LibroControlador {
	//Creamos los atributos de modelo, DAO Y vista
	private ILibroDAO libroDAO;
	private LibroVista libroVista;
	private Libro libro;
	//Constructor con DAO Y VISTA
	public LibroControlador(ILibroDAO libroDAO, LibroVista libroVista) {
		this.libroDAO = libroDAO;
		this.libroVista = libroVista;
	}
	//Implementamos los demas metodos tando del dao como de vista para crear libro
	public void crearLibro() {
		libro = libroVista.ingresarDatosLibro();
		libroDAO.crearLibro(libro);
	}
	//Implementamos los demas metodos tando del dao como de vista para actualizar libro
	public void actualizarLibro() {
		libro = libroVista.actualizarDatosLibro();
		//Verificamos que el libro se haya actualizado
		if(libroDAO.actualizarLibro(libro.getTitulo(), libro)==true) {
			libroVista.mostrarAlertas("Se ha actualizado correctamente");
			
		}else {
			libroVista.mostrarAlertas("Ha ocurrido un error!");
		}
	}
	//Implementamos los demas metodos tando del dao como de vista para eliminar libro
	public void eliminarLibro() {
		String titulo = libroVista.eliminarDatosLibro();
		//Verifiamos que el libro se haya eliminado 
		if(libroDAO.eliminarLibro(titulo) == true) {
			libroVista.mostrarAlertas("Libro eliminado correctamente");
		}else {
			libroVista.mostrarAlertas("Ha ocurrido un error");
	
		}
	}
	//Implementamos los demas metodos tando del dao como de vista para buscar libro
	public void buscarLibroPorTitulo() {
		String titulo = libroVista.buscarDatosLibro();
		libro = libroDAO.obtenerLibroPorTitulo(titulo);
		if(libro == null) {
			libroVista.mostrarAlertas("No se encontraron resultados");
		}else {
			libroVista.mostrarInformacion(libro);
		}
	}
	//Implementamos los demas metodos tando del dao como de vista para listar los libros
	public void listarLibros(){
		//Obtenemos la lista de libros
	        List<Libro> listaLibros = libroDAO.obtenerLibros();
	        for (Libro libro : listaLibros) {
	            libroVista.mostrarInformacion(libro);
	        }
	    }
}
