package com.revature.pixott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pixott.model.Movie;

public class WishListAndHistoryDao {
	public static boolean checkWishList(int movieid,int userid) {
		String sql= String.format("select * from wishlist where wishlist=%d && user_id=%d;",movieid,userid);
		boolean check = false;
		try(
				Connection connection = Util.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);
				){
			ResultSet rs= stmt.executeQuery();
			while(rs.next()) {
				check=true;
			}
		}catch(SQLException e) {
			Util.displayMessage(e);
		}
		return check;
	}
	
	public static void showWishList(int userid) {
		String sql= String.format("select * from movie join wishlist where user_id=%d && wishlist=movie.id;",userid);
		List<Movie> movies = new ArrayList<>();
		try(
				Connection connection = Util.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);
				){
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("id"));
				movie.setName(rs.getString("name"));
				movie.setGenre(rs.getString("genre"));
				movie.setYear(rs.getInt("year"));
				movies.add(movie);
			}
		} catch (SQLException e) {
			Util.displayMessage(e);
		}
		MovieDao.print();
		movies.forEach(System.out::println);
		
	}
	
	public static void insertWishList(int movieid,int userid) {
		String sql = "insert into wishlist (wishlist,user_id) values (?,?)";
		try(
				Connection connection = Util.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);
				){
	                 stmt.setInt(1,movieid);
	                 stmt.setInt(2, userid);
	                 stmt.executeUpdate();
		}catch(SQLException e) {
			Util.displayMessage(e);
		}
		
	}
	
	public static void insertHistory(int movieid,int userid) {
		String sql = "insert into history (history,user_id) values (?,?)";
		try(
				Connection connection = Util.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);
				){
	                 stmt.setInt(1,movieid);
	                 stmt.setInt(2, userid);
	                 stmt.executeUpdate();
		}catch(SQLException e) {
			Util.displayMessage(e);
		}
		
	}
	
	public static void showHistory(int userid) {
		String sql= String.format("select * from movie join history where user_id=%d && history=movie.id;",userid);
		List<Movie> movies = new ArrayList<>();
		try(
				Connection connection = Util.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);
				){
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("id"));
				movie.setName(rs.getString("name"));
				movie.setGenre(rs.getString("genre"));
				movie.setYear(rs.getInt("year"));
				movies.add(movie);
			}
			MovieDao.print();
			movies.forEach(System.out::println);
		} catch (SQLException e) {
			Util.displayMessage(e);
		}
		
		
	}
	public static boolean checkHistory(int movieid,int userid) {
		String sql= String.format("select * from history where history=%d && user_id=%d;",movieid,userid);
		boolean check = false;
		try(
				Connection connection = Util.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);
				){
			ResultSet rs= stmt.executeQuery();
			while(rs.next()) {
				check=true;
			}
		}catch(SQLException e) {
			Util.displayMessage(e);
		}
		return check;
	}
	
}