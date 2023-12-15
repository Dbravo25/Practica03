package ec.edu.ups.practica.tres.IDAO;

import java.util.List;

import ec.edu.ups.practica.tres.modelo.Usuario;

public interface IUsuarioDAO {
	//Creacion del CRUD EN USUARIO
	List<Usuario> obtenerUsuarios();
	Usuario obtenerUsuario(String identificacion);
    void crearUsuario(Usuario usuario);
    boolean actualizarUsuario(String identificacion, Usuario usuario);
    boolean eliminarUsuario(String identificacion);

}
