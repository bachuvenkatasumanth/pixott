package com.revature.pixott.validation;

import com.revature.pixott.model.UserVO;

public class UserValidator {
	public void validate(UserVO uservo) {
		uservo.getPassword().isEmpty();
			
		
	}

}
