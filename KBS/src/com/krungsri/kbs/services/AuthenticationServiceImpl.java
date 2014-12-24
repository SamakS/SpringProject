package com.krungsri.kbs.services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public boolean handleLogin(String userName, String password) {
		boolean authen = false;
		
		if(userName.equals("user") && password.equals("pass")){
			authen = true;
		}
		
		return authen;
	}

}
