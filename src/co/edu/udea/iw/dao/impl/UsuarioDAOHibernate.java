package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;


public class UsuarioDAOHibernate extends HibernateDaoSupport implements UsuarioDAO{
	
	
	@Override
	public List<Usuario> obtener() throws IWDaoException {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Session session = null;
		try{
			session = this.getSessionFactory().getCurrentSession();
			
			Criteria criteria = session.createCriteria(Usuario.class);
			
			usuarios = criteria.list();
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		return usuarios;
	}

	@Override
	public Usuario obtener(String login) throws IWDaoException {
		Usuario usuario = null;

		try{
			Session session = this.getSessionFactory().getCurrentSession();
			
			usuario = (Usuario)session.load(Usuario.class, login);

		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return usuario;
	}

}
