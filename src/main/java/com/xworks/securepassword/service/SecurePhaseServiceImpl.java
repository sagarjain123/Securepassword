package com.xworks.securepassword.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworks.securepassword.repository.SecurePhaseRepository;

@Service
public class SecurePhaseServiceImpl implements SecurePhaseService {

	
	Logger logger=LoggerFactory.getLogger(SecurePhaseServiceImpl.class);
	
	@Autowired
	private SecurePhaseRepository securePhaseRepository;
	
	public SecurePhaseServiceImpl() {
	      logger.info(this.getClass().getSimpleName()+"created");
	      
	}
	
	public void securePhase(String userName, String securePhase) {
		securePhaseRepository.securePhase(userName, securePhase);

	}

}
