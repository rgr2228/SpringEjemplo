package co.edu.udea.iw.bl.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import co.edu.udea.iw.bl.ClienteBL;
import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.util.validations.Validaciones;

@Transactional
public class ClienteBLImpl implements ClienteBL {
	@Autowired
	ClienteDAO clienteDao;
	
	@Autowired
	UsuarioDAO usuarioDao;
	
	@Override
	public List<Cliente> obtener() throws IWDaoException {
		// TODO Auto-generated method stub
		return clienteDao.obtener();
	}

	@Override
	public Cliente insertar(String cedula, String nombres, String apellidos, 
			String email, String usuarioCrea) throws IWDaoException {
		Cliente cliente = null;
		Usuario usuario = null;
		Validaciones valida = new Validaciones();
		if(valida.isTextoVacio(cedula)) {
			throw new IWDaoException("La cedula del cliente no puede ser vacía");
		}
		if(valida.isTextoVacio(nombres)) {
			throw new IWDaoException("Los nombres del cliente no pueden ser vacíos");
		}
		if(valida.isTextoVacio(apellidos)) {
			throw new IWDaoException("Los apellidos del cliente no pueden ser vacíos");
		}
		if(!valida.isEmail(email)) {
			throw new IWDaoException("El email debe tener el formato correcto");
		}
		usuario = usuarioDao.obtener(usuarioCrea);
		if(usuario==null) {
			throw new IWDaoException("El usuario no puede ser nulo");
		}
		cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setCorreoElectronico(email);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		return clienteDao.insertar(cliente);
	}

}
