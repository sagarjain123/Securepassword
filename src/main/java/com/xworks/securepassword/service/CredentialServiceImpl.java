package com.xworks.securepassword.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworks.securepassword.entity.UserCredentialEntity;
import com.xworks.securepassword.repository.CredentialRepository;

@Service
public class CredentialServiceImpl implements CredentialService {
	
	@Autowired
	private CredentialRepository credentialRepository;
	
	Logger logger=LoggerFactory.getLogger(CredentialServiceImpl.class);
	
	public CredentialServiceImpl() {
		logger.info(this.getClass().getSimpleName()+"created");
	}

	public void credential(UserCredentialEntity credentialentity) {
		credentialRepository.credential(credentialentity);

	}

	public List<UserCredentialEntity> fetchAllCredentialService(String userName) {
		List<UserCredentialEntity> list=credentialRepository.fetchAllCredentialRepository(userName);
		return list;
	}

	public UserCredentialEntity editCredentialService(String name, String user) {
		UserCredentialEntity credentialEntity=credentialRepository.editCredentialRepository(name, user);
		return credentialEntity;
	}
	
    }
