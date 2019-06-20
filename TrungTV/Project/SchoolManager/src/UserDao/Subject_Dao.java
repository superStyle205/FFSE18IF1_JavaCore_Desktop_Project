package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Database.Subject;
import SchoolManager.ConnectUtil;

public class Subject_Dao {
	public List<Subject> getAllSubject() {
		String sql = "SELECT * FROM subjects";
		List<Subject> listSubject = new ArrayList<Subject>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Subject subject;
			while (result.next()) {
				subject = new Subject();
				subject.setSubjectID(result.getString("Subject_ID"));
				subject.setSubject(result.getString("Subject"));
				subject.setCredits(Integer.parseInt(result.getString("Credits")));
				
				listSubject.add(subject);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnection(conn);
		}

		return listSubject;
	}
	public void addSubject(Subject subject) {
		String sql = "INSERT INTO subjects VALUES(?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, subject.getSubjectID());
			statement.setString(2, subject.getSubject());
			statement.setInt(3, subject.getCredits());


			statement.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "This ID has existed", "ERROR!", 2);
		} finally {
			connectUtil.disconnection(conn);
		}
	}
	public void updateSubject(Subject subject) {
		String sql = "UPDATE subjects SET Subject = ?, Credits = ? WHERE Subject_ID= ?";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(3, subject.getSubjectID());
			statement.setString(1, subject.getSubject());
			statement.setInt(2, subject.getCredits());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnection(conn);
		}
	}
	public List<Subject> searchSub(String subjectName) {
		String sql = "SELECT * FROM subjects WHERE Subject = ?";
		List<Subject> listSubject = new ArrayList<Subject>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		Subject subject;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, subjectName);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				subject = new Subject();
				subject.setSubjectID(result.getString("Subject_ID"));
				subject.setSubject(result.getString("Subject"));
				subject.setCredits(Integer.parseInt(result.getString("Credits")));
				
				listSubject.add(subject);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnection(conn);
		}

		return listSubject;
	}
}
