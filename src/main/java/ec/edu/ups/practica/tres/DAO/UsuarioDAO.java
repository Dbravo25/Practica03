package ec.edu.ups.practica.tres.DAO;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.practica.tres.IDAO.IUsuarioDAO;
import ec.edu.ups.practica.tres.modelo.Usuario;

public class UsuarioDAO implements IUsuarioDAO { //implementamos la clase IDAO de usuario
	//Creamos el listado donde se guardaran los Usuarios simulando nuestra base de datos
	private List<Usuario> listaUsuarios;
	
	public UsuarioDAO() {
		listaUsuarios = new ArrayList<>();
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		//retornamos el listado de usuarios
		return listaUsuarios;
	}
	@Override
	public Usuario obtenerUsuario(String identificacion) {
		for(Usuario usuario : listaUsuarios) {
			//Verificamos que el usuario contenga la misma identificacion y retornamos 
			if (usuario.getIdentificacion().equalsIgnoreCase(identificacion)) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	//Agregamos el usuario a la lista de usuario
	public void crearUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
		
	}
	@Override
	public boolean actualizarUsuario(String identificacion, Usuario usuario) {
		//Con el for identificamos la posicion del usuario y remplazamos con el set
		for(int i = 0; i< listaUsuarios.size(); i++) {
			Usuario usuarioUno = listaUsuarios.get(i);
			if (usuarioUno.getIdentificacion().equalsIgnoreCase(identificacion)== true) {
				listaUsuarios.set(i, usuario);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean eliminarUsuario(String identificacion) {
		//Con el for identificamos la posicion del usuario y eliminamos con el remove
		for(int i = 0; i< listaUsuarios.size(); i++) {
			Usuario usuario = listaUsuarios.get(i);
			if (usuario.getIdentificacion().equalsIgnoreCase(identificacion)) {
				listaUsuarios.remove(i);
				return true;
			}
		}
		return false;
	}
}
