package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import SchoolManager.ConnectUtil;

public class Class_Dao {
	public List<Database.Class> getAllClass() {
		String sql = "SELECT * FROM class";
		List<Database.Class> listClass = new ArrayList<Database.Class>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Database.Class class1;
			while (result.next()) {
				class1 = new Database.Class();
				class1.setClassID(result.getString("Class_ID"));
				class1.setClassName(result.getString("Name_of_class"));
				class1.setTeacherID(result.getString("Teacher_ID"));
				class1.setSchoolYear(Integer.parseInt(result.getString("School_year")));
				listClass.add(class1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnection(conn);
		}

		return listClass;
	}
	public void addClass(Database.Class class1) {
		String sql = "INSERT INTO class VALUES(?, ?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, class1.getClassID());
			statement.setString(2, class1.getClassName());
			statement.setString(3, class1.getTeacherID());
			statement.setInt(4, class1.getSchoolYear());


			statement.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "This ID has existed", "ERROR!", 2);
		} finally {
			connectUtil.disconnection(conn);
		}
	}
	public void updateClass(Database.Class class1) {
		String sql = "UPDATE class SET Name_of_class = ?, Teacher_ID = ?, School_year = ? WHERE Class_ID= ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(4, class1.getClassID());
			statement.setString(1, class1.getClassName());
			statement.setString(2, class1.getTeacherID());
			statement.setInt(3, class1.getSchoolYear());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnection(conn);
		}
	}
	public void deleteClass (String classID) {
		String sql = "DELETE FROM class WHERE Class_ID = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, classID);
			statement.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Class is having students", "ERROR!", 2);
		} finally {
			connectUtil.disconnection(conn);
		}
	}
}
