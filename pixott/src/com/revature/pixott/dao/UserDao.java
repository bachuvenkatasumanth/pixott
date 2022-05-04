package com.revature.pixott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pixott.handler.MainMenuHandler;
import com.revature.pixott.model.UserVO;

public class UserDao {
 
	public static boolean signUpCheck(long mobileNumber) {
		String sql= String.format("select * from user where mobilenumber=%d;",mobileNumber);
		boolean user = false;
		try(
				Connection connection = Util.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);
				){
			ResultSet rs= stmt.executeQuery();
			while(rs.next()) {
				user=true;
			}
		}catch(SQLException e) {
			Util.displayMessage(e);
		}
		return user;
	}
	
	public static void signUp(long mobileNumber,String password,String user_name){
		String sql= "insert into user (mobilenumber,password,user_name) values (?,?,?)";
		try(
				Connection connection = Util.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);
				){
	                 stmt.setLong(1,mobileNumber);
	                 stmt.setString(2, password);
	                 stmt.setString(3,user_name);
	                 stmt.executeUpdate();
		}catch(SQLException e) {
			Util.displayMessage(e);
		}
		
	}
	
	public UserVO login(Long mobileNumber,String password) {
		String sql="select * from user where mobilenumber = ? && password = ?";
		try (
				Connection conn = Util.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setLong(1, mobileNumber);
			stmt.setString(2, password);
			ResultSet rs =stmt.executeQuery();
			if(rs.next()) {
				UserVO user= new UserVO();
				user.setId(rs.getInt("id"));
				user.setUser_name(rs.getString("user_name"));
				user.setMobilenumber(rs.getLong("mobilenumber"));
				user.setPassword(rs.getString("password"));
				return user;
			}else {
				System.out.println("\nIncorrect Mobile Number or Password");
				MainMenuHandler.displayMenu();
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}


