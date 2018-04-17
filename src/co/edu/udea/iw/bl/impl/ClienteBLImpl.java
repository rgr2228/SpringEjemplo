package co.edu.udea.iw.bl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import co.edu.udea.iw.bl.ClienteBL;
import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.IWDaoException;

@Transactional
public class ClienteBLImpl implements ClienteBL {
	@Autowired
	ClienteDAO clienteDao;
	
	@Override
	public List<Cliente> obtener() throws IWDaoException {
		// TODO Auto-generated method stub
		return clienteDao.obtener();
	}

}
