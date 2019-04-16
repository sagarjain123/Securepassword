package com.xworks.securepassword.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.xworks.securepassword.entity.UserEntity;

@Component
public class MailServiceImpl implements MailService {
	
	Logger logger=LoggerFactory.getLogger(MailServiceImpl.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private EncryptionDecryption encryptionDecryption;
	
	public MailServiceImpl() {
		logger.info(this.getClass().getSimpleName()+"created");
	}

	public void sendMail(UserEntity userentity) {
		SimpleMailMessage message=new SimpleMailMessage();
		String link= "  http://localhost:8080/SecurePassword/confirmPassword.do?userName="+userentity.getUserName();
	try {
		message.setTo(userentity.getEmail());
		message.setSubject("Register conformation Mail");
		message.setText("Hi, /n"+userentity.getUserName()+"you have Successfully register for Secure Password"+
				 "/n" + "with userName\t"+userentity.getUserName()+
				"/n"+ "with userName\t"+encryptionDecryption.decrypt(userentity.getPassword())+"\t"+
				"\n" + "This is for confirmpassword./n click here" +link);
		mailSender.send(message);
		logger.info("mail sent to"+userentity.getEmail());
		logger.info("link"+link);
	} catch (Exception e) {
		logger.info(e.getMessage());
	}
	}

}
