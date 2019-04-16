package com.xworks.securepassword.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class securePhaseRepositoryImpl implements SecurePhaseRepository {
	
	Logger logger=LoggerFactory.getLogger(securePhaseRepositoryImpl.class);
	
	@Autowired
	private SessionFactory factory;
	
	public securePhaseRepositoryImpl() {
		logger.info(this.getClass().getSimpleName()+"created");
	}

	public void securePhase(String userName, String securePhase) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="update UserEntity set securePhase=:phase,newUser=false where userName=:un";
		 Query query=session.createQuery(hql);
		 query.setParameter("phase",securePhase);
		 query.setParameter("un",userName);
         query.executeUpdate();
         tx.commit();
	}

}
