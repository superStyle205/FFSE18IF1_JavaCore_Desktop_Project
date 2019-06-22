package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.database.ConnectData;


public class LoginDao {
	public boolean LoginJframe(String TaiKhoan, String MatKhau){
		boolean flag = false;
		String sql = " SELECT * FROM dangnhap WHERE TaiKhoan = ? AND MatKhau = ?";
		
		ConnectData connect = new ConnectData();
		Connection conn = connect.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, TaiKhoan);
			statement.setString(2, MatKhau);
			ResultSet result = statement.executeQuery();
			if(result.next() == true){
				flag = true;
			}
			else{
				flag = false;
			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connect.disconnect(conn);
		}
		
		return flag;
		
	}
}