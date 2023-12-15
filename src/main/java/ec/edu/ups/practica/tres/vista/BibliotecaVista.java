package ec.edu.ups.practica.tres.vista;

import java.util.Scanner;

import ec.edu.ups.practica.tres.modelo.Biblioteca;

public class BibliotecaVista {
	  private Scanner entrada;
//Creamos el contructor 
	    public BibliotecaVista() {
	        entrada = new Scanner(System.in);
	    }
	    //Realizamos la vista para la Biblioteca al momento de ingresar datos
	   public Biblioteca ingresarDatosBiblioteca() {
		   System.out.println("Ingreso Nueva Biblioteca");
		   System.out.println("Ingrese el nombre de la Biblioteca");
		   String nombre = entrada.next();
		   System.out.println("Ingrese la direccion");
		   String direccion = entrada.next();
		   return new Biblioteca(nombre, direccion);
		   
	   }
	   //Realizamos la vista para la Biblioteca al momento de actualizar datos
	   public Biblioteca actualizarDatosBiblioteca() {
		   System.out.println("Ingreso Nueva Biblioteca");
		   System.out.println("Ingrese el nombre de la Biblioteca");
		   String nombre = entrada.next();
		   System.out.println("Ingrese la direccion");
		   String direccion = entrada.next();
		   return new Biblioteca(nombre, direccion);
		   
	   }
	   //Realizamos la vista para la biblioteca al momento de eliminar
	   public String eliminarDatosBiblioteca(){
	        System.out.println("------Eliminar Biblioteca------");
	        System.out.println("Ingresa el nombre de la Biblioteca a eliminar");
	        String nombre = entrada.next();
	        return nombre;
	    }
	    //Realizamos la vista al momento de buscar la biblioteca
	    public String buscarDatosBiblioteca(){
	        System.out.println("------Buscar Biblioteca------");
	        System.out.println("Ingresa el nombre de la biblioteca a buscar");
	        String nombre = entrada.next();
	        return nombre;
	    }               
	    //Mostramos la informacion con el toString
	    public void mostrarInformacionBiblioteca(Biblioteca biblioteca){
	        System.out.println(biblioteca.toString());
	    }
	    //Metodo para imprimir cualquier mensaje
	    public void mostrarAlertas(String mensaje){
	        System.out.println(mensaje);
	    }
	   
}
