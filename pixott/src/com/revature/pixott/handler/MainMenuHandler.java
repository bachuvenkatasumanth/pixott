package com.revature.pixott.handler;

import com.revature.pixott.app.App;

public class MainMenuHandler {
	public static void displayMenu() {
		System.out.println("\n --------\n|Pix Menu|\n --------\n");
		System.out.println("(1) SignUp");
		System.out.println("(2) Login");
		System.out.println("(3) Exit App");
		System.out.print("\nSelect an Option : ");
		int option = Integer.parseInt(App.scanner.next());
		if (option == 1) {
			SignUpHandler.displaySignUp();
		}
		else if (option == 2) {
			LoginHandler.displayLogin();
		}
		else {
			System.out.println("\n********************\nThank You.Come Again\n********************\n");
		}
	}

}
