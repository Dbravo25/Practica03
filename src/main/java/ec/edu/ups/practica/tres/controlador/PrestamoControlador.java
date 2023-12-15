package ec.edu.ups.practica.tres.controlador;

import java.util.List;
import java.util.Scanner;

import ec.edu.ups.practica.tres.IDAO.ILibroDAO;
import ec.edu.ups.practica.tres.IDAO.IPrestamoDAO;
import ec.edu.ups.practica.tres.IDAO.IUsuarioDAO;
import ec.edu.ups.practica.tres.modelo.Libro;
import ec.edu.ups.practica.tres.modelo.Prestamo;
import ec.edu.ups.practica.tres.modelo.Usuario;
import ec.edu.ups.practica.tres.vista.LibroVista;
import ec.edu.ups.practica.tres.vista.PrestamoVista;
import ec.edu.ups.practica.tres.vista.UsuarioVista;

public class PrestamoControlador {
	//Atributos de todos los metodos con lo que se va a trabajar
	private IPrestamoDAO prestamoDAO;
	private PrestamoVista prestamoVista;
	private Prestamo prestamo;
	private IUsuarioDAO usuarioDAO;
	private UsuarioVista usuarioVista;
	private Usuario usuario;
	private ILibroDAO libroDAO;
	private LibroVista libroVista;
	private Libro libro;
	Scanner entrada = new Scanner(System.in);
	//Constructor
	public PrestamoControlador(IPrestamoDAO prestamoDAO, PrestamoVista prestamoVista, IUsuarioDAO usuarioDAO,
			UsuarioVista usuarioVista, ILibroDAO libroDAO, LibroVista libroVista) {
		this.prestamoDAO = prestamoDAO;
		this.prestamoVista = prestamoVista;
		this.usuarioDAO = usuarioDAO;
		this.usuarioVista = usuarioVista;
		this.libroDAO = libroDAO;
		this.libroVista = libroVista;
	}
	//Implementamos los demas metodos tando del dao como de vista para crear el prestamo
	
	public void crearPrestamo() {
		//Creamos el prestamo
		prestamo= prestamoVista.ingresarDatosPrestamo();
		//Identificamos al usuario y lo obtenemos
		String identificacion = usuarioVista.buscarDatosUsuario();
		usuario= usuarioDAO.obtenerUsuario(identificacion);
		//Verificamos que no sea un objeto nulo
		if(usuario!= null) {
			prestamo.setUsuario(usuario);
			int numeroLibros = prestamoVista.agregarLibrosAlPrestamo();
			for(int i = 0; i<numeroLibros; i++) {
				//Buscamos y obtenemos el libro
				String titulo = libroVista.buscarDatosLibro();
				libro = libroDAO.obtenerLibroPorTitulo(titulo);
				//Verificamos que no sea nulo
				if(libro!= null) {
					//Verificamos que este disponible 
					if (libro.getDisponible()!= false) {
						//Prestamo el libro y calculamos los dias de prestamo
					prestamo.agregarLibro(libro);
					libro.prestar(libro);
					int dias = prestamo.calcularDiasPrestamo(prestamo.getFechaPrestamo(), prestamo.getFechaDevolucion());
					System.out.println("Estimado "+ usuario.getNombre() +" dispone de " + dias +" dias para devolver el libro" );
					}else {
						prestamo.esPrestamoVigente(false);
					}
					
				}else {
					libroVista.mostrarAlertas("No se encontraron resultados");
				}
				
			}
			prestamoDAO.crearPrestamo(prestamo);
		}else {
			usuarioVista.mostrarAlertas("No se encontraron resultados del usuario");
		}
		
	}
	//Implementamos los demas metodos tando del dao como de vista para actualizar prestamo
	public void actualizarPrestamo() {
		//Antes de actualizar verificamos que el prestamo exista
		int num = prestamoVista.buscarDatosPrestamo();
		if(prestamoDAO.obtenerPrestamo(num) != null) {
			//Extraemos el nuevo prestamo
		prestamo= prestamoVista.actualizarDatosPrestamo();
			System.out.println("Que cambios adicionales va a realizar: \n1. Agregar mas Libros \n2. Devolver Libros"
					+ "\n Ingrese la Opción: ");
			int respuesta = entrada.nextInt();
			if (respuesta == 1) {
				//Numero de libros
				int numeroLibros = prestamoVista.agregarLibrosAlPrestamo();
				for(int i = 0; i<numeroLibros; i++) {
					//extraemos el titulo del libro
					String titulo = libroVista.buscarDatosLibro();
					//obtenemos el libro
					libro = libroDAO.obtenerLibroPorTitulo(titulo);
					//Verificamos que no sea un objeto nulo
					if(libro!= null) {
						//Verificamos que este disponible el libro
						if (libro.getDisponible()!= false) {
							//Presamos el libro y actualizamos
						libro.prestar(libro);
						prestamo.agregarLibro(libro);
						prestamoDAO.actualizarPrestamo(prestamo.getNumeroPrestamo(), prestamo);
						}else {
							prestamo.esPrestamoVigente(false);
						}
						
					}else {
						libroVista.mostrarAlertas("No se encontraron resultados");
				
					}
				}
			}else if(respuesta == 2) {
				System.out.println("Cuantos libros desea devolver");
				int numLibros = entrada.nextInt();
				for(int i = 0; i<numLibros; i++) {
					//buscamos y obtenos el libro
					String titulo = libroVista.buscarDatosLibro();
					libro = libroDAO.obtenerLibroPorTitulo(titulo);
					//Verificamos que no sea un libro nulo
					if(libro!= null) {
						//Devolvemos el libro
						libro.devolver(libro);
								
					}else {
						libroVista.mostrarAlertas("No se encontraron resultados");
					}
				}
			}else {
				prestamoVista.mostrarAlertas("Opción incorrecta");
			}
		}else {
			System.out.println("Ha ocurrido un error!");
		}
		
	}
	//Implementamos los demas metodos tando del dao como de vista para eliminar prestamo
	public void eliminarPrestamo() {
		//Extraemos el numero de prestamo
		int numPrestamo = prestamoVista.eliminarDatosPrestamo();
		//obtenemos el objeto prestamo
		prestamo = prestamoDAO.obtenerPrestamo(numPrestamo);
		//Verificamos que no sea un prestamo nulo
		if (prestamo != null) {
			for (Libro libro : prestamo.getPrestamos()) {
				//Devolvemos el libro
				libro.devolver(libro);
			}
		}
		if(prestamoDAO.eliminarPrestamo(numPrestamo) == true) {
			//Si se elimina el prestamo mostramos el siquiente mensaje
			prestamoVista.mostrarAlertas("Se ha eliminado correctamente");
			
		}else {
			prestamoVista.mostrarAlertas("Ha producido un error!");
		}
	}
	//Implementamos los demas metodos tando del dao como de vista para buscar prestamo
	public void buscarPrestamo() {
		//Extraemos el numero de prestamo
		int numPrestamo = prestamoVista.buscarDatosPrestamo();
		//Extraemos el prestamo
		prestamo = prestamoDAO.obtenerPrestamo(numPrestamo);
		//Verificamos que el prestamo sea diferente de nulo e imprimos el toString del mismo
		if(prestamo != null) {
			System.out.println(prestamo.toString()); 
			
			
		}else {
			prestamoVista.mostrarAlertas("Ha producido un error!");
		}
	}
	////Implementamos los demas metodos tando del dao como de vista para enlistar prestamo
	public void listarPrestamo(){
		//Obtenemos el listado de prestamos
        List<Prestamo> listaPrestamos = prestamoDAO.obtenerPrestamos();
        //Con el buble imprimimo prestamo por prestamo
        for (Prestamo prestamo : listaPrestamos) {
           prestamoVista.mostrarInformacionPedido(prestamo);
        }
    }
}
