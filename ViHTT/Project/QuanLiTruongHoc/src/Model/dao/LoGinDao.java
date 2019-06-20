package Model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectUtil.ConnectUtil;
import Model.bean.LoGin;
import Model.bean.ThongTinHocSinh;

public class LoGinDao {
	public boolean getAll(String username,String password){
		String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		boolean flag = false;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			statement.setString(1, username);
			statement.setString(2, password);
			if(resultSet.next()== true) {
				flag = true;
			}
			else {
				flag = false;
			}
				
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		
			connectUtil.disconnect(conn);
		}
		return flag;
	}
	
	
	
}
