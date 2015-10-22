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
		User userToUpdate = findById(user.getId());
		
		try {
			if(userToUpdate != null){
				String updateQuery = "UPDATE users SET " + "NAME='" + user.getName() + "',LASTNAME='" + user.getLastname() + "' WHERE " + "ID='" + user.getId() + "'";
				getStatement().executeUpdate(updateQuery);
			}else{
				String insertQuery = "INSERT INTO users " + "(ID, NAME, LASTNAME) " + "VALUES" + "('" + user.getId()+ "','" +  user.getName() + "','" + user.getLastname() + "')";
				getStatement().executeUpdate(insertQuery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void remove(String id){
		try {
			getStatement().executeUpdate("DELETE FROM users WHERE id=" +  id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User findById(String id){
		User user = null;
		try {
			ResultSet rs = getStatement().executeQuery(
					"SELECT * FROM users WHERE id=" + id);
			while (rs.next())
		      {
				user = new User(rs.getString("id"), rs.getString("name"), rs.getString("lastname"));
		      }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
