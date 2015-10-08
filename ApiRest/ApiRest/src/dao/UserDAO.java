package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;


public class UserDAO {

	private Statement getStatement(){
		Connection conn = null;
		Statement st = null;
	    String url = "jdbc:mysql://localhost:3306/";
	    String dbName = "users";
	    String driver = "com.mysql.jdbc.Driver";
	    String userName = "root";
	    String password = "root";

	    try
	    {
	        Class.forName(driver).newInstance();
	        conn = DriverManager.getConnection(url+dbName,userName,password);
	        st = conn.createStatement();

	    }
	    catch (Exception e)
	    {
	        System.out.println("NO CONNECTION =(");
	    }
	    return st;
	}
	
	public List<User> findAll(){
		List<User> users = new ArrayList<User>();
		User user;
		try {
			ResultSet rs = getStatement().executeQuery("SELECT * FROM users");
			 while (rs.next())
		      {
		        String id = rs.getString("id");
		        String name = rs.getString("name");
		        String lastname = rs.getString("lastname");
		        user = new User(id,name,lastname);
		        users.add(user);
		      }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public void saveOrUpdate(User user){
		try {
			getStatement().executeQuery("INSERT INTO users values");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
