package com.revature.pixott.handler;

import com.revature.pixott.app.App;
import com.revature.pixott.dao.AdminDao;
import com.revature.pixott.dao.MovieDao;

public class AdminHandler {
	public static void displayAdmin() {
		System.out.println("\n -------------\n|Welcome Admin|\n -------------\n");
		System.out.println("(1) Add Movie");
		System.out.println("(2) Mark Movie Unavailable");
		System.out.println("(3) MarkMovie Available");
		System.out.println("(4) Modify Movie Details");
		System.out.println("(5) Change Top Five Movies");
		System.out.println("(6) Show Movie List");
		System.out.println("(7) LogOut");
		System.out.print("\nSelect an Option : ");
		int option = Integer.parseInt(App.scanner.next());
		if(option==1) {
			System.out.print("Enter the Movie Name : ");
			String name = App.scanner.nextLine();
			System.out.print("Enter the Movie Genre : ");
			String genre = App.scanner.nextLine();
			System.out.print("Enter the Movie Sale : ");
			int sales = Integer.parseInt(App.scanner.next());
			System.out.print("Enter the Movie Year : ");
			int year = Integer.parseInt(App.scanner.next());
			AdminDao.addMovie(name, genre, sales, year);
			System.out.println("Movie Added Successful");
			AdminHandler.displayAdmin();
			}
		
		else if(option == 2) {
			System.out.print("\nEnter Movie Id to Mark Unavailable : ");
			int id = Integer.parseInt(App.scanner.next());
			AdminDao.makeUnavailableOrAvailable("unavailable",id);
			System.out.println("\nMovie Updated to Unavailable");
			AdminHandler.displayAdmin();
		}
		else if(option == 3) {
			System.out.print("\nEnter Movie Id to Mark Available : ");
			int id = Integer.parseInt(App.scanner.next());
			AdminDao.makeUnavailableOrAvailable("available",id);
			System.out.println("\nMovie Updated to Available");
			AdminHandler.displayAdmin();
		}
		else if(option == 4) {
			AdminDao.showFullMovie();
			System.out.println("\n(1) Change Movie Name\n(2) Change Movie Year\n(3) Change Movie Genre\n(4) Change Movie Sales\n(5)Back");
			System.out.print("\nSelect an Option : ");
			int choice =Integer.parseInt(App.scanner.next());
			System.out.print("\nEnter Movie Id You Want To Change : ");
			int movieid=Integer.parseInt(App.scanner.next());
			if(choice==1) {
				System.out.print("\nEnter Movie Name : ");String moviename=App.scanner.nextLine();
				AdminDao.modifyMovie("name",moviename, movieid);  System.out.println("\nMovie Name Updated");
				AdminHandler.displayAdmin();
			}else if(choice==2){
				System.out.print("\nEnter Movie Year : ");int movieyear = Integer.parseInt(App.scanner.next());
				AdminDao.modifyMovieSalesOrYear("year",movieyear, movieid);System.out.println("\nMovie Year Updated");
				AdminHandler.displayAdmin();
			}else if(choice==3) {
				System.out.print("\nEnter Movie Genre : ");String moviegenre=App.scanner.nextLine();
				AdminDao.modifyMovie("genre",moviegenre, movieid);System.out.println("\nMovie Genre Updated");
				AdminHandler.displayAdmin();
			}else if(choice==4) {
				System.out.print("\nEnter Movie Sales : ");int sales = Integer.parseInt(App.scanner.next());
				AdminDao.modifyMovieSalesOrYear("sales",sales, movieid);System.out.println("\nMovie Sales Updated");
				AdminHandler.displayAdmin();
			}else {
				AdminHandler.displayAdmin();
			}
		}
		
		else if(option == 5) {
			System.out.println("\nFull Movie List\n");
			AdminDao.showFullMovie();
			System.out.println("\nTop Five Movies\n");
			MovieDao.topfivemovie();
			System.out.print("Enter the Top Five Movie Id You Want To Change : ");
			int removeTopFiveMovie = Integer.parseInt(App.scanner.next());	
			System.out.print("Enter the Movie Id You Want To Add in Top Five : ");
			int updateTopFiveMovie = Integer.parseInt(App.scanner.next());
			AdminDao.changeTopFiveMovie(updateTopFiveMovie,removeTopFiveMovie);
			System.out.println("\nTop Five Movies Updated");
			AdminHandler.displayAdmin();
			}
		else if(option == 6){
			System.out.println("\n**********\nMovie List\n**********\n");
			AdminDao.showFullMovie();
			AdminHandler.displayAdmin();
		}
		else {
			MainMenuHandler.displayMenu();
		}
		
	}


}
