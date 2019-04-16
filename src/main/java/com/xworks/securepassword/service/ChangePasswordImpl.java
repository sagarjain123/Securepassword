package com.xworks.securepassword.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworks.securepassword.entity.ChangePasswordEntity;
import com.xworks.securepassword.entity.UserEntity;
import com.xworks.securepassword.repository.ChangedPasswordRepository;

@Service
public class ChangePasswordImpl implements ChangePassword {
	
	
	Logger logger=LoggerFactory.getLogger(ChangePasswordImpl.class);
	
	@Autowired
	private ChangedPasswordRepository changedPasswordRepository;
	
	public ChangePasswordImpl() {
		logger.info(this.getClass().getSimpleName()+"created");
	}

	
		public boolean findByUserName(String userName) {
			UserEntity entity=changedPasswordRepository.checkByUserName(userName);
			if(entity !=null)
			{
				logger.info("user exists");
				return true;
			}
			else
			{
				logger.info("user not exists");
				return false;
			}
			
			
			
		}


		public boolean changePassword(ChangePasswordEntity passwordEntity) {
			return changedPasswordRepository.changePassword(passwordEntity);
			
			
		}

}
