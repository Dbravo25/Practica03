package ec.edu.ups.practica.tres.modelo;

import java.util.Objects;

public class Libro implements IPrestable {//implementamos la interfaz IPrestable
	//Creacion de los atribtos de libro
	private String titulo;
	private String autor;
	private int año;
	private boolean disponible;
	//Constructor vacio
	public Libro() {
		
	}
//Constructor con sus atributos
	public Libro(String titulo, String autor, int año, boolean disponible) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.año = año;
		this.disponible = disponible;
	}
//Creacion de los getters y setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	//metodo para mostrar informacion
	public void mostrarInformacion() {
		System.out.println("\nInformación sobre el libro: ");
		System.out.println("Titulo: "+ titulo);
		System.out.println("Autor: " + autor);
		System.out.println("Año publicación: " + año);
		System.out.println("Disponible: " + disponible);
	}
//Creacion del hashCode y equal con el titulo
	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(titulo, other.titulo);
	}
//Implementacion de los metodos de la interfaz
	@Override
	public void prestar(Libro libro) {
		System.out.println("Libro prestado");
		libro.setDisponible(false);
	}

	@Override
	public void devolver(Libro libro) {
		System.out.println("Libro Devuelto");
		libro.setDisponible(true);
	}
//Creacion del toString
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", año=" + 
	año + ", disponible=" + disponible + "]";
	}
}
