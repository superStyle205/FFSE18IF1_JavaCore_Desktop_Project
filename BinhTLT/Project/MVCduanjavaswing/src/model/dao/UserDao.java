package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.database.ConnectionUntil;

public class UserDao {	
	public int isLogint(String username, String password) {
		int flag =0;
		String sql = "SELECT user_roles.roleid FROM user INNER JOIN user_roles ON  user.userid = user_roles.userid WHERE username = ? and password = ? ";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement stsm = conn.prepareStatement(sql);
			stsm.setString(1, username);
			stsm.setString(2, password);
			ResultSet result = stsm.executeQuery();
			if(result.next()){
				flag= Integer.parseInt(result.getString(1));
				System.out.println(flag);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connnect.disconnect(conn);
		}
		return flag;
	}
	
	public String getIdByUserName(String username){
		String sql = "SELECT * FROM user WHERE username = ? ";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement stsm = conn.prepareStatement(sql);
			stsm.setString(1, username);
			ResultSet result = stsm.executeQuery();
			while (result.next()) {
				return result.getString("userid");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connnect.disconnect(conn);
		}
		return null;
	}
	
	public String getRolesId(String idUser){
		String sql = "SELECT * FROM user_roles WHERE userid = ? ";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement stsm = conn.prepareStatement(sql);
			stsm.setString(1, idUser);
			ResultSet result = stsm.executeQuery();
			while (result.next()) {
				return result.getString("rolesid");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connnect.disconnect(conn);
		}
		return null;
	}
	
	public String getRolesNameByRolesId(String idIdRoles){
		String sql = "SELECT * FROM roles WHERE roleid = ? ";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement stsm = conn.prepareStatement(sql);
			stsm.setString(1, idIdRoles);
			ResultSet result = stsm.executeQuery();
			while (result.next()) {
				return result.getString("rolename");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connnect.disconnect(conn);
		}
		return null;
		
	}
	

}
