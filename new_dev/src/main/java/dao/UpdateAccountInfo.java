package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DBconfig;
import dto.UserInfo;

public class UpdateAccountInfo {
	public final String file_path = "/Users/hikaruh/git/Practice_Java/new_dev/DBconfig.properties";
	DBconfig config = new DBconfig();
	
	public UserInfo getUserInfo(int user_id) throws FileNotFoundException {
		/**
		 * required.
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String[] DbInfo = config.getDBinfo(file_path);
		
		String url = DbInfo[0];
		String db_user_name = DbInfo[1];
		String db_password = DbInfo[2];
		
		String sql = "SELECT * FROM user WHERE id = ?";
		
		UserInfo info = new UserInfo();
		
		try(Connection conn = DriverManager.getConnection(url,db_user_name,db_password)){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, user_id);
			ResultSet rs = stmt.executeQuery();

			// while rs.next() show "true", get customer data from result set.
			while(rs.next()) {
				info = new UserInfo();
				info.setId(rs.getInt("id"));
				info.setName(rs.getString("name"));
				info.setPhoneNumber(rs.getString("phone_number"));
				info.setEmail(rs.getString("email"));
				info.setDateOfBirth(rs.getString("date_of_birth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	
	/*
	 * fix or add information from parameter.
	 * Parameter is got from user input.
	 */
	public void add(UserInfo user_info) throws IOException {
		/**
		 * required.
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		// set up db
		String[] DbInfo = config.getDBinfo(file_path);
		String url = DbInfo[0];
		String db_user_name = DbInfo[1];
		String db_password = DbInfo[2];
		
		//nameが空白で帰る可能性があるためnotnullのエラーがでない？
		String sql = "UPDATE user SET name = ?, date_of_birth = ?, phone_number = ?, email = ? where id = ?";
		
		try (Connection conn = DriverManager.getConnection(url, db_user_name, db_password)) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user_info.getName());
			stmt.setString(2, user_info.getDateOfBirth());
			stmt.setString(3, user_info.getPhoneNumber());
			stmt.setString(4, user_info.getEmail());
			stmt.setInt(5, user_info.getId());
			
			int result = stmt.executeUpdate();
			System.out.println(result + " (number of lines) is fixed.");
		} catch (SQLException e1){
			System.out.println("cause an exception of sql");
			e1.printStackTrace();
		}
	}
}
