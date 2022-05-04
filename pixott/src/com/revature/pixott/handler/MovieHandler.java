package com.revature.pixott.handler;

import com.revature.pixott.app.App;
import com.revature.pixott.dao.MovieDao;
import com.revature.pixott.dao.WishListAndHistoryDao;

public class MovieHandler {
	public static int userid = LoginHandler.userid;

	public static void displayMovies() {
		System.out.println("\n ----------\n|Movie Menu|\n ----------\n");
		System.out.println("(1) Show Movie List");
		System.out.println("(2) Show Top Movies Based On Year");
		System.out.println("(3) Search Movies");
		System.out.println("(4) Show Top Five Movies");
		System.out.println("(5) Show Wishlist");
		System.out.println("(6) Show History");
		System.out.println("(7) Search By Genre");
		System.out.println("(8) Logout");
		System.out.print("\nSelect an Option : ");
		int option = Integer.parseInt(App.scanner.next());

		if (option == 1) {
			System.out.println("\n ------\n|Movies|\n ------\n");
			MovieDao.findAll();
			MovieHandler.addPlayBack();
		}

		else if (option == 2) {
			System.out.println("\n ------------------------\n|Top Movies Based On Year|\n ------------------------\n");
			System.out.print("Enter Year : ");
			int year = Integer.parseInt(App.scanner.next());
			MovieDao.findTopMovieBasedOnYear(year);
			MovieHandler.addPlayBack();
		}

		else if (option == 3) {
			System.out.print("Enter Movie Name : ");
			String keyword = App.scanner.next();
			System.out.println("\n -------------\n|Search Result|\n -------------\n");
			MovieDao.search(keyword);
			MovieHandler.addPlayBack();
		} else if (option == 4) {
			System.out.println("\n ---------------\n|Top Five Movies|\n ---------------\n");
			MovieDao.topfivemovie();
			MovieHandler.addPlayBack();
		} else if (option == 5) {
			WishListAndHistoryHandler.displayWishlist();
		} else if (option == 6) {
			System.out.println("\n ------------\n|Your History|\n ------------\n");
			WishListAndHistoryDao.showHistory(userid);
			MovieHandler.addPlayBack();
		} else if (option == 7) {
			System.out.println("\n(1) Comedy\n(2) Drama\n(3) Animation\n(4) Romance\n(5) Action\n");
			System.out.print("Select an Option : ");
			int choice = Integer.parseInt(App.scanner.next());
			System.out.println("\n -------------\n|Search Result|\n -------------\n");
			if (choice == 1) {
				MovieDao.searchGenre("Comedy");
			} else if (choice == 2) {
				MovieDao.searchGenre("Drama");
			} else if (choice == 3) {
				MovieDao.searchGenre("Animation");
			} else if (choice == 4) {
				MovieDao.searchGenre("Romance");
			} else if (choice == 5) {
				MovieDao.searchGenre("Action");
			}
			MovieHandler.addPlayBack();
		}

		else {
			MainMenuHandler.displayMenu();
		}

	}

	public static void addPlayBack() {
		System.out.println("\n(1) Add Movie to Wish List\n(2) Play Movie\n(3) Back\n");
		System.out.print("Select an Option : ");
		int choice = Integer.parseInt(App.scanner.next());
		if (choice == 1) {
			WishListAndHistoryHandler.addWishList();
		} else if (choice == 2) {
			WishListAndHistoryHandler.checkAddHistory();
		} else {
			MovieHandler.displayMovies();
		}

	}
}
