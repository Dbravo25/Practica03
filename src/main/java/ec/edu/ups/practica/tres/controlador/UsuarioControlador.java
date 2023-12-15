package ec.edu.ups.practica.tres.controlador;

import java.util.List;

import ec.edu.ups.practica.tres.IDAO.IUsuarioDAO;
import ec.edu.ups.practica.tres.modelo.Usuario;
import ec.edu.ups.practica.tres.vista.UsuarioVista;

public class UsuarioControlador {
	private IUsuarioDAO usuarioDAO;
	private UsuarioVista usuarioVista;
	private Usuario usuario;
	//Consructor
	public UsuarioControlador(IUsuarioDAO usuarioDAO, UsuarioVista usuarioVista) {
		super();
		this.usuarioDAO = usuarioDAO;
		this.usuarioVista = usuarioVista;
	}
	//Implementamos los demas metodos tando del dao como de vista para crear usuario
	public void crearUsuario() {
		usuario = usuarioVista.ingresarDatosUsuario();
		usuarioDAO.crearUsuario(usuario);
	}
	//Implementamos los demas metodos tando del dao como de vista para actualizar usuario
	public void actualizarUsuario() {
		//Obtenemos el objeto usuario actualizado y lo actuaizamos en el dao
		usuario = usuarioVista.actualizarDatosUsuario();
		if(usuarioDAO.actualizarUsuario(usuario.getIdentificacion(), usuario)) {
			usuarioVista.mostrarAlertas("Se ha actualizado correctamente");
		}else {
			usuarioVista.mostrarAlertas("El usuario ha actualizar no se encuentra registrado");
		}
	}
	//Implementamos los demas metodos tando del dao como de vista para eliminar usuario
	public void eliminarUsuario() {
		//Pbtenemos la identificacion del usuario 
		String identificacion = usuarioVista.eliminarDatosUsuario();
		//Verificamos que el usuario se haya eliminado
		if(usuarioDAO.eliminarUsuario(identificacion) == true) {
			usuarioVista.mostrarAlertas("Usuario eliminado correctamente");
		}else {
			usuarioVista.mostrarAlertas("Ha ocurrido un error");
	
		}
	}
	//Implementamos los demas metodos tando del dao como de vista para buscar usuario
	public void buscarUsuario() {
		String identificacion = usuarioVista.buscarDatosUsuario();
		usuario = usuarioDAO.obtenerUsuario(identificacion);
		//Obtenmos el usuario y verificamos que no sea un objeto nulo 
		if(usuario == null) {
			usuarioVista.mostrarAlertas("No se encontraron resultados");
		}else {
			usuarioVista.mostrarInformacion(usuario);
		}
	
		}
	//Implementamos los demas metodos tando del dao como de vista para listar usuario
	public void listarUsuarios(){
		//Extraemos el listado y mostramos la infromacion de cada objeto usuario 
        List<Usuario> listaUsuarios = usuarioDAO.obtenerUsuarios();
        for (Usuario usuario : listaUsuarios) {
           usuarioVista.mostrarInformacion(usuario);
        }
    }
}
