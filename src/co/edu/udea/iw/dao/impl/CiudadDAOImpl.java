package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.HibernateSessionFactory;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.IWDaoException;

public class CiudadDAOImpl extends HibernateDaoSupport implements CiudadDAO {
	
	
	
	@Override
	public List<Ciudad> obtener() throws IWDaoException {
		List<Ciudad> ciudades = null;
		Session session = null;
		try {
		ciudades = new ArrayList<Ciudad>();
		session = this.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Ciudad.class);
		ciudades = criteria.list();
	}catch(HibernateException e){
		throw new IWDaoException(e);
	}
	return ciudades;
	}

	@Override
	public Ciudad obtener(Integer codigo) throws IWDaoException {
		Ciudad ciudad = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getInstancia().getSession();
			ciudad = (Ciudad)session.get(Ciudad.class, codigo);

		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		return ciudad;
	}

}
