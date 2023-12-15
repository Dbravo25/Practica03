package ec.edu.ups.practica.tres.vista;

import java.util.Scanner;

import ec.edu.ups.practica.tres.modelo.Libro;

public class LibroVista {
	private Scanner entrada;
	public LibroVista() {
		entrada = new Scanner(System.in);
	}
	
	public Libro ingresarDatosLibro() {
		System.out.println("--------Ingrese Datos del Libro------");
		System.out.println("Ingresar el titulo del libro");
		String titulo = entrada.next();
		System.out.println("Ingresar el autor del libro");
		String autor = entrada.next();
		System.out.println("Ingresar el año del libro");
		int año = entrada.nextInt();
		boolean disponible = true;
		return new Libro(titulo,autor,año, disponible);
		
	}
	public Libro actualizarDatosLibro() {
		System.out.println("--------Actualizar Libro------");
		System.out.println("Ingresar el titulo del libro a actualizar");
		String titulo = entrada.next();
		System.out.println("Ingresar el autor a actualizar del libro");
		String autor = entrada.next();
		System.out.println("Ingresar el año a actualizar del libro");
		int año = entrada.nextInt();
		boolean disponible = true;
		return new Libro(titulo,autor,año, disponible);
	}
	public String eliminarDatosLibro() {
		System.out.println("--------Eliminar Libro------");
		System.out.println("Ingresar el titulo del Libro a eliminar: ");
		String titulo = entrada.next();
		return titulo;
	}
	public String buscarDatosLibro(){
			System.out.println("--------Buscar Libro------");
			System.out.println("Ingresar el titulo del Libro a buscar: ");
			String titulo = entrada.next();
			return titulo;
	}  
	 public void mostrarInformacion(Libro libro){
		 //Implementamos el metodo de la clase libro
		 libro.mostrarInformacion();
		 
	 }
	//Metodo para imprimir cualquier mensaje  
	 public void mostrarAlertas(String mensaje){
	        System.out.println(mensaje);
	 }
	
}