package ec.edu.ups.practica.tres.test;

import ec.edu.ups.practica.tres.vista.*;

import java.util.Scanner;

import ec.edu.ups.practica.tres.DAO.*;
import ec.edu.ups.practica.tres.IDAO.*;
import ec.edu.ups.practica.tres.controlador.BibliotecaControlador;
import ec.edu.ups.practica.tres.controlador.LibroControlador;
import ec.edu.ups.practica.tres.controlador.PrestamoControlador;
import ec.edu.ups.practica.tres.controlador.UsuarioControlador;

public class Principal {
	public static void main(String[] args) {
		//Intanciamos las clases necesarias para que funcione los controladores
		ILibroDAO libroDAO = new LibroDAO();
		LibroVista libroVista = new LibroVista();
		IUsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVista usuarioVista = new UsuarioVista();
		IPrestamoDAO prestamoDAO = new PrestamoDAO();
		PrestamoVista prestamoVista = new PrestamoVista();
		IBibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
		BibliotecaVista bibliotecaVista = new BibliotecaVista();
		//Instanciasmos los controladores
		LibroControlador libroControlador = new LibroControlador(libroDAO, libroVista);
		UsuarioControlador usuarioControlador = new UsuarioControlador(usuarioDAO, usuarioVista);
		PrestamoControlador prestamoControlador = new PrestamoControlador(prestamoDAO, prestamoVista,
				usuarioDAO, usuarioVista,libroDAO, libroVista);
		BibliotecaControlador bibliotecaControlador = new BibliotecaControlador(bibliotecaDAO,
				bibliotecaVista, usuarioDAO, usuarioVista, libroDAO, libroVista);
		//Instanciamos la clase Scanner para pedir desde consola 
		Scanner entrada = new Scanner(System.in);
		int op = 0;
		//Creamos la variable op y con eso hacemos que funcione el bucle 
		while(op!= 3) {
			//Creamos un menu para biblioteca
		System.out.println("Sistema Bibliotecario");
		System.out.println("Menú");
		System.out.println("1. Crear Biblioteca");
		System.out.println("2. Buscar Biblioteca");
		System.out.println("3.Salir");
		System.out.println("Ingrese una opción: ");
		 op = entrada.nextInt();
		 //Creamos condicionales para acceder a la operacion que seleccione 
		 if (op == 1) {
			 //Creamos la biblioteca
			 bibliotecaControlador.crearBiblioteca();
			 //Creacion de la opc y bucle while para accerder a otro menu 
			 int opc= 0;
			 while(opc!=4) {
			 System.out.println("Menú");
			 System.out.println("1. Agregar Libro");
			 System.out.println("2. Agregar Usuario");
			 System.out.println("3. Crear Prestamo");
			 System.out.println("4. Salir");
			 System.out.println("Ingrese una opción: ");
			 opc = entrada.nextInt();
			 //Cramos condicionales para acceder depende cual seleccione
			 if(opc == 1) {
				 //Solicitamos el numero de libros a agregar
				 System.out.println("Cuantos libros desea agregar?");
				 int res = entrada.nextInt();
				 for(int i = 0; i<res; i++) {
					 //Creamos y agregamos el libro
					 bibliotecaControlador.agregarLibros();	 
				 }
				 int opc2 = 0;
				 while(opc2!=5) {
					 //Creamos mas opciones para libro
				 System.out.println("Otras opciones");
				 System.out.println("1. Actualizar Libro");
				 System.out.println("2. Eliminar Libro");
				 System.out.println("3. Buscar Libro");
				 System.out.println("4. Listar libro");
				 System.out.println("5. Salir");
				 System.out.println("Ingrese una opción: ");
				 opc2 = entrada.nextInt();
				 if(opc2 == 1) {
					 //Actualizamos el libro
					 libroControlador.actualizarLibro();
				 }else if(opc2==2) {
					 //eliminamos el libro
					 libroControlador.eliminarLibro();
				 }else if(opc2 == 3) {
					 //buscamos el libro
					 libroControlador.buscarLibroPorTitulo();
				 }else if(opc2==4) {
					 //Imprimos la lista de libros
					 libroControlador.listarLibros();
				 }else {
					 System.out.println(" ");
				 	}
				 } 
			 	}else if (opc==2) {
			 		//Solicitamos el numero de usuarioa a ingresar
			 		System.out.println("Cuantos Usuarios quieres ingresar?");
					 int res = entrada.nextInt();
					 for(int i = 0; i<res; i++) {
						 //Creamos y agregamos el usuario
						 bibliotecaControlador.agregarUsuarios();
					 }
					 int resp=0;
					 while(resp!=5) {//Bucle con mas opciones
					 System.out.println("Desea realizar algun cambio");
					 System.out.println("1.Actualizar Usuario");
					 System.out.println("2.Eliminar Usuario");
					 System.out.println("3.Buscar Usuario");
					 System.out.println("4.Listar Usuarios");
					 System.out.println("5. Salir");
					 System.out.println("Ingrese una opción: ");
					 resp = entrada.nextInt();
					 
					 if (resp == 1) {
						 //actualizamos el usuario
						usuarioControlador.actualizarUsuario();
					 }else if (resp == 2){
						 //eliminamos el usuario
						 usuarioControlador.eliminarUsuario();
					 }else if (resp == 3) {
						 //buscamos el usuario
						 usuarioControlador.buscarUsuario();
					 }else if (resp == 4) {
						 //Imprimimos el listado de usuarios
						 usuarioControlador.listarUsuarios();
					 	}
					 }
			 		
			 	}else if(opc ==3) {
			 		//Crear el prestamo
			 		prestamoControlador.crearPrestamo();
			 		 int resp=0;
					 while(resp!=5) {//menu con mas opciones del prestamo
					 System.out.println("Desea realizar algun cambio");
					 System.out.println("1.Actualizar Prestamo");
					 System.out.println("2.Eliminar Prestamo");
					 System.out.println("3.Buscar Prestamo");
					 System.out.println("4.Listar Prestamo");
					 System.out.println("5. Salir");
					 System.out.println("Ingrese una opción: ");
					 resp = entrada.nextInt();
					 
					 if (resp == 1) {
						 //Actualizamos el prestamo
						prestamoControlador.actualizarPrestamo();
					 }else if (resp == 2){
						 //eliminamos el prestamo
						 prestamoControlador.eliminarPrestamo();
					 }else if (resp == 3) {
						 //Buscamos el prestamo
						 prestamoControlador.buscarPrestamo();
					 }else if (resp == 4) {
						 //Imprimos el listado de prestamos
						 prestamoControlador.listarPrestamo();
					 	}
					 }
			 	}else {
			 		if(opc == 3) {
			 			System.out.println("Los datos han sido guardados");
			 		}else {
			 			System.out.println("Opcion invalida!");
			 		}
			 		
			 	}
			 }
		 }else if(op ==2) {
			 //Buscamos la biblioteca
			 bibliotecaControlador.buscarBiblioteca();
			 System.out.println("Otras opciones: ");
			 System.out.println("1.Actualizar Biblioteca");
			 System.out.println("2.Eliminar Biblioteca");
			 System.out.println("3. Salir");
			 System.out.println("Ingrese una opción: ");
			 int resp = entrada.nextInt();
			 
			 if (resp == 1) {
				 //actualizamos biblioteca
				 bibliotecaControlador.actualizarBiblioteca();
			 }else if (resp == 2){
				 //eliminamos biblioteca
				 bibliotecaControlador.eliminarBiblioteca();
			 }
		 }else {
			 entrada.close();
		 }
		}
	}
}
