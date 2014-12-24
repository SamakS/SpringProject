package com.krungsri.kbs.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.krungsri.kbs.controllers.model.LoginForm;
import com.krungsri.kbs.services.AuthenticationService;
import com.krungsri.kbs.utils.Constants;
/**
 * Handles requests for the application home page.
 */
@Controller
public class AuthenticationController {	
	
	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);		
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(){
		return "redirect:login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(Model model){
		log.info("*************** Start KBS *************** ");
		model.addAttribute("loginTitle", "Plase login for KBS");
		
		return new ModelAndView("login", "form1", new LoginForm());		
	}
	
	@RequestMapping(value="/authen",method=RequestMethod.POST)
	public String authen(Model model, @Validated LoginForm loginForm, BindingResult result, HttpSession session){
		log.info("LoginForm : {}",loginForm);
		
		//check validate user/password
		boolean authen = false;
		
		String userName = loginForm.getUserName();
		String password = loginForm.getPassword();
		log.info("userName:{}",userName);
		log.info("password:{}",password);
		
		//TODO : Authentication if success then redirect to marketingProgramAdmin.jsp else login.jsp		
		authen = authenticationService.handleLogin(userName, password);
		
		if(authen){						
			session.setAttribute(Constants.SESSION_USER_AUTHEN, userName);
			log.info("redirect to marketingProgramAdmin.jsp");
			return "redirect:marketingProgramAdmin";
		}else{
			session.setAttribute(Constants.SESSION_USER_AUTHEN, "");
			model.addAttribute("error", "User Id or Pass not correct.");
			log.info("redirect to login.jsp");
			return "redirect:login";//redirect to login.jsp
		}
	}
}
