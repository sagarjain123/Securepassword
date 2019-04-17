package com.xworks.securepassword.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworks.securepassword.entity.UserCredentialEntity;

@Repository
public class CredentialRepositoryImpl implements CredentialRepository {
	
	Logger logger=LoggerFactory.getLogger(CredentialRepositoryImpl.class);
	
	@Autowired
	private SessionFactory factory;
	
	public CredentialRepositoryImpl() {
		logger.info(this.getClass().getSimpleName()+"created");
	}

	public void credential(UserCredentialEntity credentialEntity) {
		Session session=factory.openSession();
		 Transaction tx=session.beginTransaction();
		 try {
			session.save(credentialEntity);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			session.getTransaction().rollback();
			he.getMessage();
		}

	}

}
