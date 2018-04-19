package co.edu.udea.iw.bl.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.bl.UsuarioBL;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.util.encode.Cifrar;
import co.edu.udea.iw.util.validations.Validaciones;

@Transactional
public class UsuarioBLImpl implements UsuarioBL {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	private final String MENSAJE_AUTENTICA = "Usuario y/o contraseña inválida";
	
	
	@Override
	public Usuario autentificar(String login, String password) throws IWDaoException {
		Usuario usuario = null;
		usuario = usuarioDAO.obtener(login);
		Cifrar cifra = new Cifrar();
		if(Validaciones.isTextoVacio(login)) {
			throw new IWDaoException(MENSAJE_AUTENTICA);
		}
		if(usuario==null)
		{
			throw new IWDaoException(MENSAJE_AUTENTICA);
		}
		if(!usuario.getPassword().equals(password)) {
			throw new IWDaoException(MENSAJE_AUTENTICA);
		}
		return usuario;
	}

}
