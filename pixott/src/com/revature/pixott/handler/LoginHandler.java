package com.revature.pixott.handler;

import com.revature.pixott.app.App;
import com.revature.pixott.dao.UserDao;
import com.revature.pixott.model.UserVO;

public class LoginHandler {
	public static int userid;
	
	public static void displayLogin() {
		System.out.println("\n ----------\n|Login Menu|\n ----------\n");
		System.out.print("Enter Mobile Number : ");
		long mobileNumber = App.scanner.nextLong();
		System.out.print("Enter Password : ");
		String password = App.scanner.next();
		if(mobileNumber==9999999999L&&password.equals("password")) {
			AdminHandler.displayAdmin();
		}else {	
		UserVO user = new UserVO();
		UserDao userdao =new UserDao();
		user=userdao.login(mobileNumber, password);
		System.out.println("\nWelcome Back "+user.getUser_name());
		userid = user.getId();
		MovieHandler.displayMovies();
		}
	}

}
