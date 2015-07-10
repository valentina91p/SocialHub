package com.socialhub.dao;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.socialhub.modelos.Usuario;

@Repository
public class UsuarioDAO {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addUsuario(Usuario usuario){
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(usuario);
		logger.info("Usuario guardado. Usuario = "+usuario);
	}
	
	public void updateUsuario(Usuario p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Usuario updated successfully, Person Details="+p);
    }
	 @SuppressWarnings("unchecked")
	public List<Usuario> listUsuarios() {
		 Session session = this.sessionFactory.getCurrentSession();
	     List<Usuario> personsList = session.createQuery("from Usuario").list();
	     logger.info("Encontrados "+personsList.size() +" usuarios");
	        for(Usuario p : personsList){
	            logger.info("Usuario List::"+p);
	        }
	        return personsList;
	    }
	 
	    public Usuario getUsuarioById(int id) {
	        Session session = this.sessionFactory.getCurrentSession();      
	        Usuario p = (Usuario) session.load(Usuario.class, new Integer(id));
	        logger.info("Usuario loaded successfully, Usuario details="+p);
	        return p;
	    }
	    public Usuario getUsuarioByUsername(String username) {
	    	Usuario u = null;
	        Session session = this.sessionFactory.getCurrentSession();
	        Criteria cr = session.createCriteria(Usuario.class);
	        cr.add(Restrictions.eq("email",username ));
	        List<Usuario> r = cr.list();
	        if(!r.isEmpty())
	        	u = r.get(0);
	        logger.info("Usuario loaded successfully, Usuario details="+u);
	        return u;
	    }
	 
	    public void removeUsuario(int id) {
	        Session session = this.sessionFactory.getCurrentSession();
	        Usuario p = (Usuario) session.load(Usuario.class, new Integer(id));
	        if(null != p){
	            session.delete(p);
	        }
	        logger.info("Usuario deleted successfully, person details="+p);
	    }
}
