package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.IWDaoException;

public class CiudadDAOHibernate extends HibernateDaoSupport implements CiudadDAO {

	@Override
	public List<Ciudad> obtener() throws IWDaoException {
		
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		
		try{
			Session session = this.getSessionFactory().getCurrentSession();
			
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
		
		try{
			Session session = this.getSessionFactory().getCurrentSession();
			
			Criteria criteria = session.createCriteria(Ciudad.class)
					.add(Restrictions.eq("codigo", codigo));
			
			//ciudad = (Ciudad)criteria.uniqueResult();
			
//			ciudad = (Ciudad)session.load(Ciudad.class, codigo); retorna excepción
//			
			ciudad = (Ciudad)session.get(Ciudad.class, codigo); //retorna null
			
			//Obtener un objeto desde hibernate con otras dos instrucciones. 
			//Averiguar cuales son y cual es la que debe usar segun las buenas practicas.
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return ciudad;
	}

}
