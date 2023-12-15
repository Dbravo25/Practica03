package ec.edu.ups.practica.tres.vista;

import java.util.Date;
import java.util.Scanner;

import ec.edu.ups.practica.tres.modelo.Prestamo;

public class PrestamoVista {
	  private Scanner entrada;

	  public PrestamoVista() {
	        entrada = new Scanner(System.in);
	   }
	  ///Realizamos la vista para el prestamo al momento de ingresar datos
	  public Prestamo ingresarDatosPrestamo() {
		  System.out.println("--------Ingreso Nuevo Prestamo------");
		  System.out.println("Ingrese el numero del prestamo");
		  int num = entrada.nextInt();
		  Date fechaPedido = new Date();
		  Date fechaDevolucion;
		  System.out.println("Ingrese la fecha de Devolución");
		  System.out.println("Ingrese el dia: ");
		  int dia = entrada.nextInt();
		  System.out.println("Ingrese el mes");
		  int mes = entrada.nextInt();
		  System.out.println("Ingrese el año");
		  int año = entrada.nextInt();
		  fechaDevolucion = new Date((año-1900), (mes-1), dia);
		  return new Prestamo(num, fechaPedido, fechaDevolucion);
	  }
	  //Realizamos la vista para el prestamo al momento de actualizar datos
	  public Prestamo actualizarDatosPrestamo() {
		  System.out.println("--------Actualizar Prestamo------");
		  System.out.println("Ingrese el numero del prestamo a actualizar");
		  int num = entrada.nextInt();
		  Date fechaPedido = new Date();
		  Date fechaDevolucion;
		  System.out.println("Ingrese la fecha de Devolución");
		  System.out.println("Ingrese el dia: ");
		  int dia = entrada.nextInt();
		  System.out.println("Ingrese el mes");
		  int mes = entrada.nextInt();
		  System.out.println("Ingrese el año");
		  int año = entrada.nextInt();
		  fechaDevolucion = new Date((año-1900), (mes-1), dia);
		  return new Prestamo(num, fechaPedido, fechaDevolucion);
	  }
	//Vista cuando se vaya a eliminar prestamo
	  public int eliminarDatosPrestamo(){
	        System.out.println("------Eliminar Prestamo------");
	        System.out.println("Ingresa el numero de prestamo a eliminar");
	        int num = entrada.nextInt();
	        return num;
	    }
	//Vista cuando se vaya a buscar prestamo
	    public int buscarDatosPrestamo(){
	        System.out.println("------Buscar Prestamo------");
	        System.out.println("Ingresa el numero de prestamo a buscar");
	        int num = entrada.nextInt();
	        return num;
	    }        
	    //Vista cuando se vaya a agregar libros a la lista de prestamos
	    public int agregarLibrosAlPrestamo(){
	        System.out.println("------Agregar Libros al Prestamo------");
	        System.out.println("Ingresa número de libros a agregar");
	        int num = entrada.nextInt();
	        return num;
	    }        
	    //mostramos informacion sobre prestamo
	    public void mostrarInformacionPedido(Prestamo prestamo){
	        System.out.println(prestamo.toString());
	    }
	  //Metodo para imprimir cualquier mensaje
	    public void mostrarAlertas(String mensaje){
	        System.out.println(mensaje);
	    }
}
