package com.webzifi.app.ws.userservice.imp;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webzifi.app.ws.shared.Utils;
import com.webzifi.app.ws.ui.model.request.UserDetailsRequestModel;
import com.webzifi.app.ws.ui.model.response.UserRest;
import com.webzifi.app.ws.userservice.UserService;

@Service
public class UserServiceImp implements UserService {
	
	Map<String, UserRest> users;
	
	
	Utils utils;
	
	public UserServiceImp() {}
	
	@Autowired
	public UserServiceImp(Utils utils) {
		this.utils =  utils;
	}
	
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		
		String userId = utils.generateUserId();
		returnValue.setUserId(userId);
		
		if(users == null) users = new HashMap<>();
		users.put(userId, returnValue);
		
		return returnValue;
	}

}
