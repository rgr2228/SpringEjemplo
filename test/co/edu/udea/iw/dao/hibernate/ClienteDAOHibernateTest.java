package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.impl.ClienteDAOHibernate;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

public class ClienteDAOHibernateTest {

	@Test
	public void testInsertar() {
		Cliente cliente = null;
		Usuario usuarioCrea = null;
		ClienteDAO dao = null;
		try {
			cliente = new Cliente();
			usuarioCrea = new Usuario();
			dao = new ClienteDAOHibernate();
			cliente.setCedula("12345");
			cliente.setNombres("Camila");
			cliente.setApellidos("Morales");
			cliente.setCorreoElectronico("dasda@sfsf.com");
			cliente.setFechaCreacion(new Date());
			usuarioCrea.setLogin("elver");
			cliente.setUsuarioCrea(usuarioCrea);
			cliente.setEliminado(Boolean.FALSE);
			dao.insertar(cliente);
		}catch(IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

//	@Test
	public void testObtener() {
		fail("Not yet implemented");
	}

}
