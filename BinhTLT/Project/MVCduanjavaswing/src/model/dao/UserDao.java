package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.database.ConnectionUntil;

public class UserDao {	
	public boolean isLogint(String username, String password) {
		String sql = "SELECT * FROM user WHERE username = ? and password = ? ";
		ConnectionUntil connnect = new ConnectionUntil();
		Connection conn = connnect.connect();
		try {
			PreparedStatement stsm = conn.prepareStatement(sql);
			stsm.setString(1, username);
			stsm.setString(2, password);
			ResultSet result = stsm.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connnect.disconnect(conn);
		}
		return false;
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
