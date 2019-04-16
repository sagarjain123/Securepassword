package com.xworks.securepassword.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworks.securepassword.entity.ChangePasswordEntity;
import com.xworks.securepassword.entity.UserEntity;
import com.xworks.securepassword.util.EncryptionDecryption;

@Component
public class ChangePasswordRepositoryImpl  implements ChangedPasswordRepository{
	
	Logger logger=LoggerFactory.getLogger(ChangePasswordRepositoryImpl.class);
	
	@Autowired
	private SessionFactory factory;
	
	@Autowired
	private EncryptionDecryption encryptionDecryption;

	public UserEntity checkByUserName(String userName) {
		   Session session=factory.openSession();
		  Query query=session.getNamedQuery("fetchByUserName");
		  query.setParameter("un",userName);
		  UserEntity dtoFromDb=(UserEntity) query.uniqueResult();
		  logger.info("fetching data from Db"+dtoFromDb);
		  return dtoFromDb;
	}

	public boolean changePassword(ChangePasswordEntity passwordEntity) {
		boolean result=false;
		System.out.println("data from changepwd"+passwordEntity);
		
			String password=encryptionDecryption.encrypt(passwordEntity.getOldPassword());
			logger.info("password is {}",password);
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="select user from UserEntity user where user.userName=:un and user.password=:pass";
		 Query query=session.createQuery(hql);
		 query.setParameter("un",passwordEntity.getUserName());
		 query.setParameter("pass",password);
		 UserEntity dtoFromDb=(UserEntity) query.uniqueResult();
		 logger.info("user data is{}",dtoFromDb);
		 if(dtoFromDb!=null)
		 {
			 logger.info("update password");
			 String hql1="update UserEntity user set user.password=:newpass where user.userName=:un";
			  Query query1=session.createQuery(hql1);
			  query1.setParameter("un",passwordEntity.getUserName());
			  query1.setParameter("newpass",encryptionDecryption.encrypt(passwordEntity.getNewPassword()));
			  query1.executeUpdate();
			  tx.commit();
			  logger.info("updated password......");
			  result=true;
		 }
		 else
		 {
			 logger.info("not updated");
			 result=false;
			 
		 }
		return result;
	}
	


}
