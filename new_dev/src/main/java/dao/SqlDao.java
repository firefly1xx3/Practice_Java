package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.DBconfig;
import dto.Customer;
import dto.LoginUser;

public class SqlDao {
	
	public final String file_path = "/Users/hikaruh/git/Practice_Java/new_dev/DBconfig.properties";
	DBconfig config = new DBconfig();
	
	public List<LoginUser> check(String user, String password) throws IOException {
		
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

		String sql = "select * from user "
				+ "where name = ? and password = ?";
		
		LoginUser login_user = new LoginUser();
		List<LoginUser> user_info = new ArrayList<LoginUser>();
		
		/**
		 * Use try with resource. it automatically close 
		 * resource when something error happens.
		 */
		try (Connection conn = DriverManager.getConnection(url,db_user_name,db_password)){
			//Class.forName("com.mysql.jdbc.Driver");
			PreparedStatement stmt = conn.prepareStatement(sql);
			// set variable stmt (location : 1st ?)
			stmt.setString(1, user);
			// set variable stmt (location : 2nd ?)
			stmt.setString(2, password);
			// execute sql.
			ResultSet rs = stmt.executeQuery();

			// If there is result on rs object, go into if condition
			if(rs.next()) {
				login_user.setId(rs.getInt("id"));
				login_user.setName(rs.getString("name"));
				login_user.setPassword(rs.getString("password"));
				user_info.add(login_user);
			} else {
				// if not, go into else condition
				login_user.setName("No user");
				login_user.setPassword("Not match password");
				user_info.add(login_user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user_info;
	}
	
	//顧客情報を取得するメソッド
	public List<Customer> get_customer_info(int user_id) throws FileNotFoundException {
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
		
		String sql ="select * from customer_list "
				+ "where user_id = ?";

		List<Customer> cus_info = new ArrayList<Customer>();
		Customer cus;

		try(Connection conn = DriverManager.getConnection(url,db_user_name,db_password)){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, user_id);
			ResultSet rs = stmt.executeQuery();

			// while rs.next() show "true", get customer data from result set.
			while(rs.next()) {
				cus = new Customer();
				cus.setId(rs.getInt("customer_id"));
				cus.setName(rs.getString("customer_name"));
				cus.setAddress(rs.getString("address"));
				cus.setPhoneNumber(rs.getString("phone_number"));
				cus.setUserId(rs.getInt("user_id"));
				cus_info.add(cus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(cus_info);
		return cus_info;
	}
	//顧客情報を登録するメソッド
	public void insert_customer_info(String name, String address, String phoneNumber, int user_id) throws FileNotFoundException {
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

		String sql = "insert into "
				+ "customer_list(customer_name, address, phone_number, user_id) "
				+ "values (?,?,?,?)";
		try(Connection conn = DriverManager.getConnection(url,db_user_name,db_password)){
			conn.setAutoCommit(false);
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setString(1, name);
				stmt.setString(2, address);
				stmt.setString(3, phoneNumber);
				stmt.setInt(4, user_id);
				int result = stmt.executeUpdate();
				System.out.println(result);
			} catch(Exception e) {
				// when something goes wrong, roll back before all commits.
				conn.rollback();
				System.out.println("データ処理が正常に終了しなかったため、RollBackを行いました");
				throw e;
			}
		} catch (SQLException e1) {
			System.out.println("SQLの例外が発生しました");
			e1.printStackTrace();
		}
	}
}
