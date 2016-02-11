package com.socialhub.dao;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public class RedSocialDAO {
	private static final Logger logger = LoggerFactory.getLogger(RedSocialDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<String> listSocialNetworks(){
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("SELECT DISTINCT providerId from userconnection where userId=?");
		return query.setString(0, email).list();
	}
}
