package com.xworks.securepassword.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworks.securepassword.entity.UserCredentialEntity;
import com.xworks.securepassword.entity.UserEntity;
import com.xworks.securepassword.service.CredentialService;
import com.xworks.securepassword.service.LoginService;
import com.xworks.securepassword.service.SecurePhaseService;

@Controller
public class SecurePhaseController {

	Logger logger = LoggerFactory.getLogger(SecurePhaseController.class);

	@Autowired
	private SecurePhaseService service;

	@Autowired
	private CredentialService credentialService;

	@Autowired
	private LoginService loginService;
	
	public SecurePhaseController() {
		logger.info(this.getClass().getSimpleName() + "created");
	}

	@RequestMapping(value = "/securePhrase.do", method = RequestMethod.GET)
	public ModelAndView setSecurePhase(@RequestParam("userName") String userName,
			@RequestParam("securePhase") String securePhase, HttpServletRequest request) {
		logger.info("userName-->" + userName);
		logger.info("securePhase-->" + securePhase);
		UserEntity entity=loginService.getByUsername(userName);
		HttpSession session = request.getSession(false);
		session.setAttribute("userEntity",entity);
		service.securePhase(userName, securePhase);
		List<UserCredentialEntity> list = credentialService.fetchAllCredentialService(userName);
		logger.info("{}",list.size());
		return new ModelAndView("home.jsp","list",list);

	}
}
