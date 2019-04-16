package com.xworks.securepassword.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworks.securepassword.service.SecurePhaseService;

@Controller
public class SecurePhaseController {
	
	Logger logger=LoggerFactory.getLogger(SecurePhaseController.class);
	
	     @Autowired
	    private SecurePhaseService service;
	
		public SecurePhaseController() {
		logger.info(this.getClass().getSimpleName()+"created");
	}
     
	@RequestMapping(value="securePhrase.do",method=RequestMethod.GET)
	public ModelAndView setSecurePhase(@RequestParam("userName")String userName,@RequestParam("securePhase")String securePhase)
	{
		logger.info("userName-->"+userName);
		logger.info("securePhase-->"+securePhase);
		
		service.securePhase(userName, securePhase);
		return new ModelAndView("index.jsp");
		
	}
}
