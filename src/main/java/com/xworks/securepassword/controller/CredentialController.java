package com.xworks.securepassword.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworks.securepassword.entity.UserCredentialEntity;
import com.xworks.securepassword.entity.UserEntity;
import com.xworks.securepassword.service.CredentialService;

@Controller
public class CredentialController {
	
	Logger logger=LoggerFactory.getLogger(CredentialController.class);
	
	@Autowired
	private CredentialService credentialService;
	
	public CredentialController() {
		logger.info(this.getClass().getSimpleName()+"created");
	}
   
	@RequestMapping(value="userCredential.do",method=RequestMethod.POST)
	public ModelAndView credential(UserCredentialEntity credentialentity,HttpServletRequest request)
	{
		logger.info("inside credential service"+credentialentity);
		 HttpSession session=request.getSession(false);
		  UserEntity user=(UserEntity) session.getAttribute("UserEntity");
		  credentialentity.setLoggedUser(user.getUserName());
		  credentialService.credential(credentialentity);
		  List<UserCredentialEntity> list=credentialService.fetchAllCredentialService(user.getUserName());
		  return new ModelAndView("home.jsp","msg","Data adde").addObject("UserEntity",user).addObject("list",list);
	}
}
