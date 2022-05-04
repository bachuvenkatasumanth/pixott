package com.revature.pixott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pixott.model.Movie;

public class MovieDao {
	public static void findAll() {
		String sql = "select * from movie where availability = 'available'";
		List<Movie> movies = new ArrayList<>();
		try (Connection connection = Util.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql);) {
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

	public static void findTopMovieBasedOnYear(int year) {
		String sql =String.format( "select * from movie where availability='available' && year=%d order by sales desc limit 1",year);
		List<Movie> movies = new ArrayList<>();
		try (Connection connection = Util.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql);) {
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

	public static void search(String keyword) {
		String symbol = "%";
		String sql = String.format("select * from movie where availability = 'available' && name like '%s%s%s'", symbol,
				keyword, symbol);
		List<Movie> movies = new ArrayList<>();
		try (Connection connection = Util.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql);) {
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

	public static void topfivemovie() {
		String sql = "select * from movie  join topfivemovie on topfivemovieid=movie.id where availability= 'available'";
		List<Movie> movies = new ArrayList<>();
		try (Connection connection = Util.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql);) {
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
	
	public static void searchGenre(String genre) {
		String sql = String.format("select * from movie  where genre = '%s' && availability='available'",genre);
		List<Movie> movies = new ArrayList<>();
		try (Connection connection = Util.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql);) {
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
	
	public static void print() {
		System.out.printf("%4s    %-40s %-10s %9s\n", "**", "****", "*****", "****");
		System.out.printf("%4s    %-40s %-10s %9s\n", "id", "Name", "Genre", "Year");
		System.out.printf("%4s    %-40s %-10s %9s\n", "**", "****", "*****", "****");
	}

}
