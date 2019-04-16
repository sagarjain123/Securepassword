package com.xworks.securepassword.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworks.securepassword.entity.UserEntity;
import com.xworks.securepassword.repository.SignUpRepository;
import com.xworks.securepassword.util.EncryptionDecryption;
import com.xworks.securepassword.util.MailServiceImpl;
import com.xworks.securepassword.util.PasswordGenerator;

@Service
public class SignUpServiceImpl implements SignUpService 
{
	
	Logger log=LoggerFactory.getLogger(SignUpServiceImpl.class);
	
	@Autowired
	private SignUpRepository repository;
	
	@Autowired
	private MailServiceImpl mailServiceImpl;
	
	public SignUpServiceImpl() 
	{
		log.info("Created\t"+this.getClass().getSimpleName());
	}

	public void signUpService(UserEntity userEntity)
	{
		
		String unencryptedString=PasswordGenerator.generatePassword();
		
		userEntity.setPassword(unencryptedString);
		log.info("newley password generated"+unencryptedString);
		
		EncryptionDecryption encryptionDecryption=null;
		try {
			encryptionDecryption=new EncryptionDecryption();
			String encryptedString=encryptionDecryption.encrypt(unencryptedString);
			log.info("Encrypted String="+encryptedString);
			userEntity.setNewUser(true);
			userEntity.setPassword(encryptedString);
			log.info("Decrypted Password is"+encryptionDecryption.decrypt(encryptedString));
			repository.signUpRepository(userEntity);
			mailServiceImpl.sendMail(userEntity);
			log.info("signup Service");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		
		
	}

}
