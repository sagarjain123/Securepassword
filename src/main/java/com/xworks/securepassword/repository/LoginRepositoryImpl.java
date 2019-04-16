package com.xworks.securepassword.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import com.xworks.securepassword.entity.LoginEntity;
import com.xworks.securepassword.entity.UserEntity;

@Repository
public class LoginRepositoryImpl implements LoginRepository {
	
	Logger logger=LoggerFactory.getLogger(LoginRepositoryImpl.class);
	
	@Autowired
	private SessionFactory factory;
	
	public LoginRepositoryImpl() {
		logger.info(this.getClass().getSimpleName()+"created");
	}

	public UserEntity loginRepository(LoginEntity loginEntity) {
		  Session session=factory.openSession();
		  String hql="from UserEntity where userName=:un and password=:pass";
		   Query query=session.createQuery(hql);
		   query.setParameter("un",loginEntity.getUserName());
		   query.setParameter("pass",loginEntity.getPassword());
      UserEntity userentity=(UserEntity) query.uniqueResult();
      return userentity;
	}

}
