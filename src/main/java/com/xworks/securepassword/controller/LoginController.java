package com.xworks.securepassword.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworks.securepassword.entity.LoginEntity;
import com.xworks.securepassword.entity.UserEntity;
import com.xworks.securepassword.service.LoginService;

@Controller
public class LoginController 
{

	Logger log=LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService service;
	
	public LoginController() 
	{
		log.info("Created\t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public ModelAndView loginController(LoginEntity loginEntity,HttpServletRequest request)throws Exception
	{
		
		log.info("LoginController started" +loginEntity);
		UserEntity userEntity=service.loginService(loginEntity);
		if (userEntity!=null) 
		{
			 HttpSession session=request.getSession(true);
			 session.setAttribute("userEntity",userEntity);
			return new ModelAndView("phase.jsp", "user",userEntity.getUserName());
		}
		else
		{
			return new ModelAndView("login.jsp", "msg", "invalid  login credential");
		}
		
		
	}
	
	
}
