

package com.xworks.securepassword.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworks.securepassword.entity.UserEntity;
import com.xworks.securepassword.service.SignUpService;

@Controller
public class SignUpController 
{
	Logger log=LoggerFactory.getLogger(SignUpController.class);
	
	@Autowired
	private SignUpService service;
	
	public SignUpController() 
	{
		log.info("Created\t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="signUp.do",method=RequestMethod.POST)
	public ModelAndView signUpController(UserEntity userEntity)
	{
		log.info("inside signupController" + userEntity);
		
		service.signUpService(userEntity);
		
		return new ModelAndView("index.jsp", "msg", "user created Successfully");
		
	}

}
