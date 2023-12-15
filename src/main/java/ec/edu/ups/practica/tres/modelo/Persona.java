package ec.edu.ups.practica.tres.modelo;

import java.util.Objects;

public abstract class Persona {
	protected String nombre;
	protected String identificacion;
	//Constructor vacio
	public Persona() {
		
	}
	//Constructor con todos los atributos 
	public Persona(String nombre, String identificacion) {
		this.nombre = nombre;
		this.identificacion = identificacion;
	}
	//Creacion de los getters y setters
	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	//Creacion del metodo abstracto mostrarInformacion
	public abstract void mostrarInformacion();
	//Creacion del hashCode y equal con la identificacion
	public int hashCode() {
		return Objects.hash(identificacion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(identificacion, other.identificacion);
	}
	//Creacion del toString
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", identificacion=" + identificacion + "]";
	}
	
	
}
