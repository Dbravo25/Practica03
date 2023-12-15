package ec.edu.ups.practica.tres.DAO;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.practica.tres.IDAO.IPrestamoDAO;
import ec.edu.ups.practica.tres.modelo.Prestamo;

public class PrestamoDAO  implements IPrestamoDAO{//implementamos la clase IDAO de Prestamo
	//Creamos el listado donde se guardaran los Prestamos simulando nuestra base de datos
	private List<Prestamo> listaPrestamos;
	//Creamos el constructor
	public PrestamoDAO() {
		listaPrestamos = new ArrayList<>();
	}
//Retornamos el listado de prestamos
	@Override
	public List<Prestamo> obtenerPrestamos() {
		return listaPrestamos;
	}
//Obtenemos el listado de prestamos en base el numero del mismo
	@Override
	public Prestamo obtenerPrestamo(int numeroPrestamo) {
		for(Prestamo prestamo : listaPrestamos) {
			//Verificamos si tienen el mismo numero y retornamos 
			if( prestamo.getNumeroPrestamo() == numeroPrestamo) {
				return prestamo;
			}
		}
		return null;
	}
//Agregamos el prestamo a la lista
	@Override
	public void crearPrestamo(Prestamo prestamo) {
		listaPrestamos.add(prestamo);
		
	}
//Actualizamos el prestamo identificando e intercambiando por el prestamo actualizado
	@Override
	public boolean actualizarPrestamo(int numeroPrestamo, Prestamo prestamo) {
		for(int i= 0 ; i< listaPrestamos.size();i++) {
			Prestamo prestamoUno = listaPrestamos.get(i);
			if(prestamoUno.getNumeroPrestamo() == numeroPrestamo) {
				//Seteo la fecha de devolucion ya que la fecha de prestamo y el numero es el mismo 
				//Realizamo esto con el fin de evitar eliminaciones de usuario y listas
				prestamoUno.setFechaDevolucion(prestamo.getFechaDevolucion());
				prestamoUno.agregarLibro(prestamo.getPrestamos().get(0));
				
				listaPrestamos.set(i, prestamoUno);
				return true;
			}
		}
		return false;
	}
//Identificamos el prestamos y luego lo eliminamos usando remove. 
	@Override
	public boolean eliminarPrestamo(int numeroPrestamo) {
		//Encontramos la posicion del objeto en la lista y con remove lo eliminamos 
		 for (int i = 0; i < listaPrestamos.size(); i++) {
			 Prestamo prestamo = listaPrestamos.get(i);
	            if(prestamo.getNumeroPrestamo() ==numeroPrestamo ) {
	            	listaPrestamos.remove(i);
	                return true;
	            }            
	        }
	        return false;
	
	}
	

}
