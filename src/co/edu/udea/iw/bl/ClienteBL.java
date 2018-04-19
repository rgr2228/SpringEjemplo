package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.IWDaoException;

public interface ClienteBL {
	
	/**
	 * 
	 * @return
	 * @throws IWDaoException
	 */
	public List<Cliente> obtener() throws IWDaoException;
	public Cliente insertar(String cedula, String nombres, String apellidos, 
			String email, String usuarioCrea) throws IWDaoException;
	
}
