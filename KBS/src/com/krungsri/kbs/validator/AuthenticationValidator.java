package com.krungsri.kbs.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.krungsri.kbs.controllers.model.LoginForm;

public class AuthenticationValidator implements Validator{

	private static final String USER_NAME = "user";
	private static final String PASSWORD = "password";
	
	@Override
	public boolean supports(Class<?> paramClass) {		
		return LoginForm.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		LoginForm form = (LoginForm) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "valid.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password");

		if(!(form.getUserName().equals(USER_NAME) && form.getPassword().equals(PASSWORD))){
			errors.rejectValue("passwordWrong", "valid.passwordWrong");
		}
	}

}
