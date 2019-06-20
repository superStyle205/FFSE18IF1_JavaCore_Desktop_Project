package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectUtil.ConnectUtil;
import Model.bean.Login;
import Model.bean.QuanLiDiem;



public class LoginDao {
	public List<Login> getAllLogin(){
		String sql = "SELECT * FROM user_login";
		List<Login> listLogin = new ArrayList<Login>();
		ConnectUtil connectUtilLogin = new ConnectUtil();
		Connection conn = connectUtilLogin .connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			Login login;
			while (resultSet.next()) { 
				login = new Login();
				login.setUsername(resultSet.getString("username"));
				login.setPassword(resultSet.getString("password"));
				listLogin.add(login);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtilLogin.disconnect(conn);
		}
		return listLogin;
	}
	public boolean checkLoGin(String username, String password) {
		String sql = "SELECT * FROM user_login WHERE username = ? AND password = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		boolean flag = false;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()==true) {
				flag = true;
			}else {
				flag = false;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
		return flag;
	}
	public void addTaiKhoan(Login login) {
		String sql = "INSERT INTO user_login VALUES(?,?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,login.getUsername());
			statement.setString(2,login.getPassword());
			statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
	public boolean checkDoiMatKhau(String username, String password) {
		String sql = "SELECT * FROM user_login WHERE (username= ? OR password = ?) AND (username= ? AND password = ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		boolean flag = false;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, username);
			statement.setString(4, password);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()==true) {
				flag = true;
			}else {
				flag = false;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
		return flag;
	}
	public void doiMatKhau(Login login) {
		String sql = "UPDATE user_login SET password = ? WHERE username = ? ";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, login.getPassword());
			statement.setString(2, login.getUsername());
			statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connectUtil.disconnect(conn);
		}
	}
}
