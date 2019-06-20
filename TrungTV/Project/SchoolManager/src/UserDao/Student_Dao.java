package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Database.Student;
import SchoolManager.ConnectUtil;

public class Student_Dao {
	public List<Student> getAllStudent() {
		String sql = "SELECT * FROM student";
		List<Student> listStudent = new ArrayList<Student>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Student student;
			while (result.next()) {
				student = new Student();
				student.setId(result.getString("ID"));
				student.setLastname(result.getString("Last_name"));
				student.setFirstname(result.getString("First_name"));
				student.setBirthday(result.getString("Birthday"));
				student.setSex(result.getString("Sex"));
				student.setCountry(result.getString("Country"));
				student.setClassid(result.getString("Class_ID"));
				listStudent.add(student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnection(conn);
		}

		return listStudent;
	}
	public void addStudent(Student student) {
		String sql = "INSERT INTO student VALUES(?, ?, ?, ?, ?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, student.getId());
			statement.setString(2, student.getLastname());
			statement.setString(3, student.getFirstname());
			statement.setString(4, student.getBirthday());
			statement.setString(5, student.getSex());
			statement.setString(6, student.getCountry());
			statement.setString(7, student.getClassid());

			statement.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "This ID has existed", "ERROR!", 2);
		} finally {
			connectUtil.disconnection(conn);
		}
	}
	public void updateStudent(Student student) {
		String sql = "UPDATE student SET Last_name = ?, First_name = ?, Birthday = ?, Sex = ?, Country = ?, Class_ID = ? WHERE ID = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(7, student.getId());
			statement.setString(1, student.getLastname());
			statement.setString(2, student.getFirstname());
			statement.setString(3, student.getBirthday());
			statement.setString(4, student.getSex());
			statement.setString(5, student.getCountry());
			statement.setString(6, student.getClassid());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnection(conn);
		}
	}
	public void deleteStudent (String id) {
		String sql = "DELETE FROM student WHERE ID = ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			statement.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "You must delete from Mark table before.", "ERROR!", 2);
		} finally {
			connectUtil.disconnection(conn);
		}
	}
}
