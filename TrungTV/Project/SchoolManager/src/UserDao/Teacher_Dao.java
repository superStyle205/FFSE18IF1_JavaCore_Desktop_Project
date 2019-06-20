package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Database.Teacher;
import SchoolManager.ConnectUtil;

public class Teacher_Dao {
	public List<Teacher> getAllTeacher() {
		String sql = "SELECT * FROM teacher";
		List<Teacher> listTeacher = new ArrayList<Teacher>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Teacher teacher;
			while (result.next()) {
				teacher = new Teacher();
				teacher.setTeacherID(result.getString("Teacher_ID"));
				teacher.setName(result.getString("Name"));
				teacher.setSubjectID(result.getString("Subject_ID"));
				teacher.setLevel(result.getString("Level"));
				teacher.setPhonenumber(result.getString("Phone_No"));
				listTeacher.add(teacher);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnection(conn);
		}

		return listTeacher;
	}
	public void addTeacher(Teacher teacher) {
		String sql = "INSERT INTO teacher VALUES(?, ?, ?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, teacher.getTeacherID());
			statement.setString(2, teacher.getName());
			statement.setString(3, teacher.getSubjectID());
			statement.setString(4, teacher.getLevel());
			statement.setString(5, teacher.getPhonenumber());

			statement.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "This ID has existed", "ERROR!", 2);
		} finally {
			connectUtil.disconnection(conn);
		}
	}
	public void updateTeacher(Teacher teacher) {
		String sql = "UPDATE teacher SET Name = ?, Subject_ID = ?, Level = ?, Phone_No = ? WHERE Teacher_ID = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(5, teacher.getTeacherID());
			statement.setString(1, teacher.getName());
			statement.setString(2, teacher.getSubjectID());
			statement.setString(3, teacher.getLevel());
			statement.setString(4, teacher.getPhonenumber());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnection(conn);
		}
	}
	public void deleteTeacher (String id) {
		String sql = "DELETE FROM teacher WHERE Teacher_ID = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			statement.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Teacher is studying", "ERROR!", 2);
		} finally {
			connectUtil.disconnection(conn);
		}
	}
}
