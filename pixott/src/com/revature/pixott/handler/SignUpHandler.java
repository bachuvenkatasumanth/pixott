package com.revature.pixott.handler;

import com.revature.pixott.app.App;
import com.revature.pixott.dao.UserDao;

public class SignUpHandler {
	public static void displaySignUp() {
		App.scanner.nextLine();
		System.out.println("\n -----------\n|SignUp Menu|\n -----------\n");
		System.out.print("Enter your Name : ");
		String user_name = App.scanner.nextLine();
		System.out.print("Enter Mobile Number : ");
		long mobileNumber = App.scanner.nextLong();
		System.out.print("Enter Password : ");
		String password = App.scanner.next();
		boolean accountExisted = UserDao.signUpCheck(mobileNumber);
		if (accountExisted) {
			System.out.println("");
			System.out.println("************************\nAccounnt already existed\n************************");
			MainMenuHandler.displayMenu();
		} else {
			UserDao.signUp(mobileNumber, password, user_name);
			System.out.println(
					"********************************\nSignup successfull. Please Login\n********************************");
			MainMenuHandler.displayMenu();
		}

	}
}
