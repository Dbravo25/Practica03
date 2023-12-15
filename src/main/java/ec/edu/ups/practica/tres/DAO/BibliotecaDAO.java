package ec.edu.ups.practica.tres.DAO;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.practica.tres.IDAO.IBibliotecaDAO;
import ec.edu.ups.practica.tres.modelo.Biblioteca;

public class BibliotecaDAO implements IBibliotecaDAO {//implementamos la clase IDAO de Biblioteca
	//Creamos el listado donde se guardaran las Bibliotecas simulando nuestra base de datos
	private List<Biblioteca> listaBibliotecas;

    public BibliotecaDAO() {
    	listaBibliotecas = new ArrayList<>();
    }

	@Override
	public List<Biblioteca> obtenerBiblioteca() {
		return listaBibliotecas;
	}

	@Override
	public Biblioteca obtenerBiblioteca(String nombre) {
		for(Biblioteca biblioteca : listaBibliotecas) {
			//Con equals comparamos que sea el mismo y retornamos 
			if(biblioteca.getNombre().equalsIgnoreCase(nombre)) {
				return biblioteca;
			}
		}
		return null;
	}

	@Override
	public void crearBiblioteca(Biblioteca biblioteca) {
		listaBibliotecas.add(biblioteca);
	}
	@Override
	public boolean actualizarBiblioteca(String nombre, Biblioteca biblioteca) {
		for (int i = 0; i < listaBibliotecas.size(); i++) {
			 Biblioteca bibliotecaEncontrada = listaBibliotecas.get(i);
	            if(bibliotecaEncontrada.getNombre().equalsIgnoreCase(nombre)==true){
	            	//Seteamos el nombre y la direccion de la biblioteca para poder 
	            	//mantener los listados
	            	bibliotecaEncontrada.setNombre(biblioteca.getNombre());
	            	bibliotecaEncontrada.setDireccion(biblioteca.getDireccion());
	            	listaBibliotecas.set(i, bibliotecaEncontrada);
	                return true;
	            }            
	        }
	        return false;
	    }
	@Override
	public boolean eliminarBiblioteca(String nombre) {
		for (int i = 0; i < listaBibliotecas.size(); i++) {
			 Biblioteca bibliotecaEncontrada = listaBibliotecas.get(i);
			 //Verificamos que el nombre sea el mismo para eliminar la biblioteca
	            if(bibliotecaEncontrada.getNombre().equalsIgnoreCase(nombre)){
	            	listaBibliotecas.remove(i);
	                return true;
	            }            
	        }
		return false;
	}
    
}
