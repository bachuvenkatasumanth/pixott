package com.revature.pixott.handler;

import com.revature.pixott.app.App;
import com.revature.pixott.dao.WishListAndHistoryDao;

public class WishListAndHistoryHandler {
	public static int userid = LoginHandler.userid;
	
	public static void displayWishlist() {
		System.out.println("\n --------------\n|Your Whishlist|\n --------------\n");
		WishListAndHistoryDao.showWishList(userid);
		System.out.println("\n(1) Play Movie\n(2) Back\n");
		System.out.print("Select an Option : ");
		int choice = Integer.parseInt(App.scanner.next());
		if(choice == 1){
			WishListAndHistoryHandler.checkAddHistory();
		}else {
			MovieHandler.displayMovies();
		}		
	}
	public static void addWishList() {
		System.out.println("\nEnter Movie ID : ");
		int movieid = Integer.parseInt(App.scanner.next());
		boolean checkWishList = WishListAndHistoryDao.checkWishList(movieid, userid);
		if(checkWishList) {
			System.out.println("\n***************************\nWish List Already Available\n***************************\n");
			MovieHandler.displayMovies();
		}
		else {
			WishListAndHistoryDao.insertWishList(movieid, userid);
			System.out.println("\n****************************\nWish List Added Successfully\n****************************\n");
			MovieHandler.displayMovies();
		}
	}
	public static void checkAddHistory() {
		System.out.println("\nEnter Movie ID : ");
		int movieid = Integer.parseInt(App.scanner.next());
		boolean checkHistory = WishListAndHistoryDao.checkHistory(movieid, userid);
		if(checkHistory) {
			System.out.println("Movie Is Playing");
			System.out.println("Movie Ended");
			MovieHandler.displayMovies();
		}
		else {
			WishListAndHistoryDao.insertHistory(movieid, userid);
			System.out.println("Movie Is Playing");
			System.out.println("Movie Ended");
			MovieHandler.displayMovies();
		}
		
	}

}
