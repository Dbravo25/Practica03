package ec.edu.ups.practica.tres.modelo;


public class Usuario extends Persona {//Persona hereda a Usuario
	private String correo;
	//Constructor vacio
	public Usuario() {
		
	}
	//Constructor con los atributos del padre y de la clase hija
	public Usuario(String nombre, String identificacion, String correo) {
		super(nombre, identificacion);
		this.correo = correo;
	}

	public Usuario(String correo) {
		super();
		this.correo = correo;
	}
	//Creacion de get y set

	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	//Sobrescritura de metodos
	@Override
	public void mostrarInformacion() {
		System.out.println("\nInformación usuario: ");
		System.out.println("Nombre: " + nombre);
		System.out.println("Identificación: " + identificacion);
		System.out.println("Correo: " + correo);
	} 
//Creacion del toString
	@Override
	public String toString() {
		return super.toString()+ "Usuario [correo=" + correo + "]";
	}
	
	
	
	
	
	

}
