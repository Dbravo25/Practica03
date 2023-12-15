package ec.edu.ups.practica.tres.controlador;

import java.util.Scanner;

import ec.edu.ups.practica.tres.IDAO.IBibliotecaDAO;
import ec.edu.ups.practica.tres.IDAO.ILibroDAO;
import ec.edu.ups.practica.tres.IDAO.IUsuarioDAO;
import ec.edu.ups.practica.tres.modelo.Biblioteca;
import ec.edu.ups.practica.tres.modelo.Libro;
import ec.edu.ups.practica.tres.modelo.Usuario;
import ec.edu.ups.practica.tres.vista.BibliotecaVista;
import ec.edu.ups.practica.tres.vista.LibroVista;
import ec.edu.ups.practica.tres.vista.UsuarioVista;

public class BibliotecaControlador {
	//Creamos los atributos con los cuales se va a controlar la Biblioteca
	private IBibliotecaDAO bibliotecaDAO;
	private BibliotecaVista bibliotecaVista;
	private Biblioteca biblioteca;
	private IUsuarioDAO usuarioDAO;
	private UsuarioVista usuarioVista;
	private Usuario usuario;
	private ILibroDAO libroDAO;
	private LibroVista libroVista;
	private Libro libro;
	private Scanner entrada;
	//Contructor
	public BibliotecaControlador(IBibliotecaDAO bibliotecaDAO, BibliotecaVista bibliotecaVista, IUsuarioDAO usuarioDAO,
			UsuarioVista usuarioVista, ILibroDAO libroDAO, LibroVista libroVista) {
		this.bibliotecaDAO = bibliotecaDAO;
		this.bibliotecaVista = bibliotecaVista;
		this.usuarioDAO = usuarioDAO;
		this.usuarioVista = usuarioVista;
		this.libroDAO = libroDAO;
		this.libroVista = libroVista;
		entrada = new Scanner(System.in);
	}
	//Creacion del metodo crear Biblioteca 
	public void crearBiblioteca() {
		biblioteca= bibliotecaVista.ingresarDatosBiblioteca();
		bibliotecaDAO.crearBiblioteca(biblioteca);
	
	}
	//Actualizamos la biblioteca implementando los metodos del DAO y vista
	public void actualizarBiblioteca() {
		biblioteca = bibliotecaVista.actualizarDatosBiblioteca();
		if(bibliotecaDAO.actualizarBiblioteca(biblioteca.getNombre(), biblioteca)) {
			bibliotecaVista.mostrarAlertas("Se ha actualizado correctamente");
		}else {
			bibliotecaVista.mostrarAlertas("La biblioteca no existe en el Sistema");
		}
		
	}
	//Eliminamos la biblioteca implementando los metodos del DAO y vista
	public void eliminarBiblioteca() {
		String nombre = bibliotecaVista.eliminarDatosBiblioteca();
		if(bibliotecaDAO.eliminarBiblioteca(nombre)) {
			bibliotecaVista.mostrarAlertas("Se ha eliminado correctamente!");
			
		}else {
			bibliotecaVista.mostrarAlertas("Se ha producido un error");
		}
	}
	//Buscamos la biblioteca implementando los metodos del DAO y vista
	public void buscarBiblioteca() {
		String nombre = bibliotecaVista.buscarDatosBiblioteca();
		biblioteca = bibliotecaDAO.obtenerBiblioteca(nombre);
	if(biblioteca != null) {
		System.out.println(biblioteca.toString());
		
	}else {
		bibliotecaVista.mostrarAlertas("Se ha producido un error");
		}
	}
	//Agregamos los libros a la biblioteca
	public void agregarLibros() {
		libro = libroVista.ingresarDatosLibro();
		libroDAO.crearLibro(libro);
		biblioteca.agregarLibro(libro);
			 
		 
	}
	//Agregamos el usuario a la biblioteca. 
	public void agregarUsuarios() {
			usuario = usuarioVista.ingresarDatosUsuario();
			usuarioDAO.crearUsuario(usuario);
			 biblioteca.registrarUsuario(usuario);
			 
		 }
	
}
