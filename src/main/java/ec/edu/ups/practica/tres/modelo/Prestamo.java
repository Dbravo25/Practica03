package ec.edu.ups.practica.tres.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prestamo {
	//Creacion de los atributos de Prestamo
	private int numeroPrestamo;
	private List<Libro> listaLibro;
	private Usuario usuario;
	private Date fechaPrestamo;
	private Date fechaDevolucion;
	//Constructor vacio
	public Prestamo() {
		listaLibro = new ArrayList<>();
	}
	//Constructor con sus atributos
	public Prestamo( Usuario usuario, Date fechaPrestamo, Date fechaDevolucion, int numeroPrestamo) {

		listaLibro = new ArrayList<>();
		this.usuario = usuario;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.numeroPrestamo = numeroPrestamo;
	}
	//Constructor con otros atributos
	public Prestamo(int numeroPrestamo, Date fechaPrestamo, Date fechaDevolucion) {
		listaLibro = new ArrayList<>();
		this.numeroPrestamo = numeroPrestamo;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
	}

	//Creacion de los getters y setters
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	public int getNumeroPrestamo() {
		return numeroPrestamo;
	}
	public void setNumeroPrestamo(int numeroPrestamo) {
		this.numeroPrestamo = numeroPrestamo;
	}
	//Agrefamos el libro el libro que prestamos
	public void agregarLibro(Libro libro) {
		listaLibro.add(libro);
		
	}
	public List<Libro> getPrestamos() {
		return listaLibro;
	}
	//Calculamos los dias prestamo
	public int calcularDiasPrestamo(Date fechaPrestamo, Date fechaDevolucion) {
		int dias =(int) ((fechaDevolucion.getTime() - fechaPrestamo.getTime())/ (24 * 60 * 60 * 1000));
		
		return dias;
	}
	//Creación del metodo si es prestamo vigente 
	public void esPrestamoVigente(boolean estado) {
		if (estado == true) {
			System.out.println("No existe un prestamo vigente, puede continuar.\n");
			
		}
		else {
			System.out.println("El libro se encuentra en un prestamo vigente!");
			
		}
	}
	
	//Creacion del toString
	@Override
	public String toString() {
		return "Prestamo [libros=" + listaLibro + ", usuario=" + usuario + ", fechaPrestamo=" + fechaPrestamo
				+ ", fechaDevolucion=" + fechaDevolucion + "]";
	}
}
