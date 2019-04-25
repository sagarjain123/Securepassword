package com.xworks.securepassword.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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
	public List<UserCredentialEntity> fetchAllCredentialRepository(String userName)
	{
		String hql="from UserCredentialEntity where loggedUser=:un";
		Session session=factory.openSession();
		Query query=session.createQuery(hql);
		query.setParameter("un",userName);
		 List<UserCredentialEntity> list=query.list();
		return list;
	}

	public UserCredentialEntity editCredentialRepository(String name, String user) {
		Session session=factory.openSession();
		String hql="from UserCredentialEntity where name=:nn and loggedUser=:un";
	 Query query=session.createQuery(hql);
	 query.setParameter("nn",name);
	 query.setParameter("un",user);
	 UserCredentialEntity credentialEntity=(UserCredentialEntity) query.uniqueResult();
		return credentialEntity;
	}

}
