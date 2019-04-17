package com.xworks.securepassword.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworks.securepassword.entity.UserEntity;

@Controller
@RequestMapping("/")
public class CheckphaseController {

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
			  return new ModelAndView("home.jsp","UserEntity","UserEntity").addObject("msg","logged in Successful");
		  }
		  else
		  {
			  return new ModelAndView("login.jsp","msg","entered phase is credentials");
		  }
	}
}
