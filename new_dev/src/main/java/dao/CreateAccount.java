package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DBconfig;
import dto.CreateUser;

public class CreateAccount {
	
	// save db information
	public final String file_path = "/Users/hikaruh/git/Practice_Java/new_dev/DBconfig.properties";
	DBconfig config = new DBconfig();
	
	public List<CreateUser> create(String user, String password) throws IOException {
		String[] DbInfo = config.getDBinfo(file_path);
		
		String url = DbInfo[0];
		String db_user_name = DbInfo[1];
		String db_password = DbInfo[2];
		
		// this outputs are looks like good.

		String sql = "INSERT INTO user (name, password) VALUES (?, ?)";
		CreateUser new_user = new CreateUser();
		List<CreateUser> new_account = new ArrayList<CreateUser>();
		
		/**
		 * required.
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		/**
		 * Use try with resource. it automatically close 
		 * resource when something error happens.
		 */
		try (Connection conn = DriverManager.getConnection(url,db_user_name,db_password)){
			//Class.forName("com.mysql.jdbc.Driver");
			PreparedStatement stmt = conn.prepareStatement(sql);
			// set variable to statement (location : 1st ?)
			stmt.setString(1, user);
			// set variable to statement (location : 2nd ?)
			stmt.setString(2, password);
			// execute sql.
			int result = stmt.executeUpdate();

			if(result != 0) {
				System.out.println("Success of creating account");
				new_user.setName(user);
				new_user.setPassword(password);
				new_account.add(new_user);
			} else {
				// if not, go into else condition
				System.out.println("failure of creating account");
				new_account.add(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new_account;
	}
}
