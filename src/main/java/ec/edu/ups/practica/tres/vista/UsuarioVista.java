package ec.edu.ups.practica.tres.vista;

import java.util.Scanner;
import ec.edu.ups.practica.tres.modelo.Usuario;

public class UsuarioVista {
	private Scanner  entrada;

	public UsuarioVista() {
		
		entrada = new Scanner(System.in);
	}
	//Realizamos la vista para el usuario al momento de ingresar datos
	public Usuario ingresarDatosUsuario() {
		System.out.println("--------Ingreso de nuevo Usuario------");
		System.out.println("Ingresar el nombre del usuario");
		String nombre = entrada.next();
		System.out.println("Ingresar la identificacion del usuario");
		String identificacion = entrada.next();
		System.out.println("Ingresar el correo del usuario");
		String correo = entrada.next();
		
		return new Usuario(nombre, identificacion, correo);
		
	}
	///Realizamos la vista para el usuario al momento de actualizar datos
	public Usuario actualizarDatosUsuario() {
		System.out.println("-------Actualizar Usuario------");
		System.out.println("Ingresar la identificacion del usuario");
		String identificacion = entrada.next();
		System.out.println("Ingresar el nombre del usuario a actualizar");
		String nombre = entrada.next();
		
		System.out.println("Ingresar el correo del usuario a actualizar");
		String correo = entrada.next();
		
		return new Usuario(nombre, identificacion, correo);
		
	}
	//La vista al momento de eliminar al Usuario
	public String eliminarDatosUsuario() {
		System.out.println("--------Eliminar Usuario------");
		System.out.println("Ingresar la identificacion del usuario a eliminar");
		String identificacion = entrada.next();
		return identificacion;
	}
	//Vista al momento de buscar usuario
	public String buscarDatosUsuario() {
		System.out.println("--------Buscar Usuario------");
		System.out.println("Ingresar la identificacion del usuario a buscar");
		String identificacion = entrada.next();
		return identificacion;
	}
	//Mostramos informacion del Usuario
	public void mostrarInformacion(Usuario usuario){
		//implementamos el metodo mostrar informacion
		usuario.mostrarInformacion();
 }
	//Metodo para imprimir cualquier mensaje
	public void mostrarAlertas(String mensaje){
        System.out.println(mensaje);
 }
}
