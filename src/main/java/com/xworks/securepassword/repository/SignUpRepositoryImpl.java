package com.xworks.securepassword.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworks.securepassword.entity.UserEntity;
import com.xworks.securepassword.repository.SignUpRepository;

@Repository
public class SignUpRepositoryImpl implements SignUpRepository 
{
	Logger log=LoggerFactory.getLogger(SignUpRepositoryImpl.class);
	
	@Autowired
	private SessionFactory factory;
	
	public SignUpRepositoryImpl() {
		log.info("created\t"+this.getClass().getSimpleName());
	}

	public void signUpRepository(UserEntity userEntity) 
	{
	Session session=factory.openSession();
	session.beginTransaction();
	try 
	{
	session.save(userEntity);
	session.getTransaction().commit();
	} 
	catch (HibernateException he) 
	{
		session.getTransaction().rollback();
		he.printStackTrace();
		
	}
		
	}

}
