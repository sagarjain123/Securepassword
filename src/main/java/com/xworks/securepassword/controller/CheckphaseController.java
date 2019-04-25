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
@RequestMapping("/")
public class CheckphaseController {
	
	@Autowired
	private CredentialService service;

	Logger logger=LoggerFactory.getLogger(CheckphaseController.class);
	
	public CheckphaseController() {
		logger.info(this.getClass().getSimpleName()+"created");
	}
	
	@RequestMapping(value="checkphase.do",method=RequestMethod.GET)
	public ModelAndView checkphase(HttpServletRequest request)
	{
		String securePhase=request.getParameter("securePhse");
		logger.info(securePhase);
		 HttpSession session=request.getSession(false);
		  UserEntity user=(UserEntity) session.getAttribute("UserEntity");
		  if(user.getSecurePhase().equals(securePhase))
		  {
			  List<UserCredentialEntity> list=service.fetchAllCredentialService(user.getUserName());
			  System.out.println("list of data"+list);
			  for(UserCredentialEntity credentialEntity:list){
				  logger.info("Credentials"+credentialEntity);
			  }
			  return new ModelAndView("home.jsp","UserEntity",user).addObject("msg","logged in Successful").addObject("list", list);
		  }
		  else
		  {
			  return new ModelAndView("login.jsp","msg","entered phase is credentials");
		  }
	}
}
