package ec.edu.ups.practica.tres.modelo;

import java.util.ArrayList;
import java.util.List;



public class Biblioteca {
	//Atributos de la clase Biblioteca
	private String nombre;
	private String direccion;

	//Atributo de relacion entre Biblioteca con libro y usuario 
	private List<Libro> listaLibros;
	private List<Usuario> listaUsuarios;
	//Constructor vacio
	public Biblioteca() {
		this.listaLibros = new ArrayList<>();
		this.listaUsuarios = new ArrayList<>();
	}
	//Constructor con los atributos
	public Biblioteca(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaLibros = new ArrayList<>();
		this.listaUsuarios = new ArrayList<>();
	}
	//metodo para agregar el libro
	public void agregarLibro(Libro libro) {
		listaLibros.add(libro);
		
	}
	//metodo para registrar usuario
	public void registrarUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
	}
	//Creacion de getters y setters
	public List<Libro> getLibro(){
		return listaLibros;
	}
	public List<Usuario> getUsuario(){
		return listaUsuarios;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void prestarLibro(Libro libro){
	    //prestamos el libro
	    libro.prestar(libro);
	}
//Creacion del toString
	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + ", listaLibros=" + listaLibros
				+ ", listaUsuarios=" + listaUsuarios + "]";
	}

}
