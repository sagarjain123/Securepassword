package com.xworks.securepassword.service;

import org.apache.log4j.spi.LoggerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworks.securepassword.entity.LoginEntity;
import com.xworks.securepassword.entity.UserEntity;
import com.xworks.securepassword.repository.LoginRepository;
import com.xworks.securepassword.util.EncryptionDecryption;
import com.xworks.securepassword.util.PasswordGenerator;

@Service
public class LoginServiceImpl implements LoginService {
	
	Logger logger=LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private LoginRepository loginrepository;
	
	@Autowired
	private EncryptionDecryption decryption;
	public LoginServiceImpl() {
		logger.info(this.getClass().getSimpleName()+"created");
	}

	public UserEntity loginService(LoginEntity loginEntity) {
		logger.info("inside loginentity() loginserviceImpl");
		loginEntity.setPassword(decryption.encrypt(loginEntity.getPassword()));
		
		UserEntity userEntity =loginrepository.loginRepository(loginEntity);
		return userEntity;
	}
	
	public UserEntity getByUsername(String username) {
		logger.info("inside getByUsername() loginserviceImpl");
		return loginrepository.getByUsername(username);
		
	}

}
