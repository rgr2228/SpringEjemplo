package co.edu.udea.iw.bl.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.bl.ClienteBL;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.cfg.xml")
@Transactional
public class ClienteBLImplTest {
	@Autowired
	ClienteBL clienteBL;
	
	@Test
	public void testObtener() {
		List<Cliente> clientes = null;
		try {
			clientes = new ArrayList<Cliente>();
			clientes = clienteBL.obtener();
			assertTrue(clientes.size()>0);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInsertar() {
		try {
			clienteBL.insertar("1045024228", "Pedro", "Ramirez", "rgr2228@gmail.com", "elver");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());		
		}
	}

}
