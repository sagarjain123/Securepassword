package com.xworks.securepassword.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworks.securepassword.entity.ChangePasswordEntity;
import com.xworks.securepassword.service.ChangePassword;
import com.xworks.securepassword.util.EncryptionDecryption;

@Controller
public class ChangePasswordController {
	
	Logger logger=LoggerFactory.getLogger(ChangePasswordController.class);
	
	@Autowired
	private ChangePassword password;
	
	public ChangePasswordController() {
		logger.info(this.getClass().getSimpleName()+"created");
	}
	
	@RequestMapping(value="confirmPassword.do",method=RequestMethod.GET)
	public ModelAndView validateLink(@RequestParam(value="userName") String userName)
	{
		logger.info("inside changepassword controller");
		boolean userFromDb=password.findByUserName(userName);
		if(userFromDb)
		{
			return new ModelAndView("ChangePassword.jsp","msg1",userName);
		}
		else
		{
			return new ModelAndView("error.jsp","msg","userName not found");
		}
		 
	}
	
	@RequestMapping(value="ChangePassword.do",method=RequestMethod.POST)
	public ModelAndView changePassword(ChangePasswordEntity changePasswordEntity)
	{
		logger.info(changePasswordEntity.toString());
//		try {
//			logger.info("decryptedpassword is {}",new EncryptionDecryption().decrypt("auTiWwGnK7TpZT7SYfF2Gw=="));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if(changePasswordEntity.getNewPassword().equals(changePasswordEntity.getConfirmPassword()))
		{
			logger.info(changePasswordEntity.getNewPassword()+"   "+changePasswordEntity.getConfirmPassword());
			boolean result=password.changePassword(changePasswordEntity);
			if(result)
			{
				return new ModelAndView("phase.jsp");
			}
			else
			{
				return new ModelAndView("ChangePassword.jsp","msg1","password not match");
			}
		}
		else
		{
			return new ModelAndView("ChangePassword.jsp","msg",changePasswordEntity.getUserName()).addObject("user","newpassword AND confirmpassword should be same");
		}
	
	}

}
