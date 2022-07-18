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
	
	public final String file_path = "/Users/hikaru/git/Practice_Java/CustomerRepo/DBconfig.properties";
	DBconfig config = new DBconfig();
	
	public List<LoginUser> check(String user, String password) throws IOException {
		String[] DbInfo = config.getDBinfo(file_path);
		
		String url = DbInfo[0];
		String db_user_name = DbInfo[1];
		String db_password = DbInfo[2];
		
		// this outputs are looks like good.
		//System.out.println("db_info: " + url + "\n" + db_user_name + "\n" + db_password);

		String sql = "select * from user "
				+ "where name = ? and password = ?";
		
		LoginUser login_user = new LoginUser();
		List<LoginUser> user_info = new ArrayList<LoginUser>();
		
		/**
		 * required.
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
		System.out.println("user_name: \n" + user_info.get(0).getName());
		return user_info;
	}
	
	//顧客情報を取得するメソッド
	public List<Customer> get_customer_info() throws FileNotFoundException {
		String[] DbInfo = config.getDBinfo(file_path);
		String url = DbInfo[0];
		String db_user_name = DbInfo[1];
		String db_password = DbInfo[2];
		
		String sql = "select * from customer_tb";

		List<Customer> cus_info = new ArrayList<Customer>();
		Customer cus;

		try(Connection conn = DriverManager.getConnection(url,db_user_name,db_password)){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				cus = new Customer();
				cus.setId(rs.getInt("id"));
				cus.setName(rs.getString("name"));
				cus.setAddress(rs.getString("address"));
				cus.setTel_number(rs.getString("tel_number"));
				cus_info.add(cus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cus_info;
	}
	//顧客情報を登録するメソッド
	public void insert_customer_info(String name, String address, String tel) throws FileNotFoundException {
		String[] DbInfo = config.getDBinfo(file_path);
		String url = DbInfo[0];
		String db_user_name = DbInfo[1];
		String db_password = DbInfo[2];

		String sql = "insert into "
				+ "customer_tb(name,address,tel_number) "
				+ "values (?,?,?)";

		try(Connection conn = DriverManager.getConnection(url,db_user_name,db_password)){
			conn.setAutoCommit(false);
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				//変数sqlの一番目の?に引数のnameをセットする
				stmt.setString(1, name);
				//変数sqlの二番目の?に引数のaddressをセットする
				stmt.setString(2, address);
				//変数sqlの三番目の?に引数のtelをセットする
				stmt.setString(3, tel);
				stmt.executeUpdate();
				conn.commit();
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
