package com.webzifi.app.ws.userservice;

import com.webzifi.app.ws.ui.model.request.UserDetailsRequestModel;
import com.webzifi.app.ws.ui.model.response.UserRest;

public interface UserService {
	
	UserRest createUser(UserDetailsRequestModel userDetails);
}
