package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Database.Mark;
import SchoolManager.ConnectUtil;

public class Mark_Dao {
	public List<Mark> getAllMark() {
		String sql = "SELECT * FROM mark";
		List<Mark> listMark = new ArrayList<Mark>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Mark mark;
			while (result.next()) {
				mark = new Mark();
				mark.setSubjectID(result.getString("Subject_ID"));
				mark.setId(result.getString("ID"));
				mark.setMidtest(Double.parseDouble(result.getString("Mid_test")));
				mark.setFinaltest(Double.parseDouble(result.getString("Final_test")));
				listMark.add(mark);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnection(conn);
		}

		return listMark;
	}
	public void addMark(Mark mark) {
		String sql = "INSERT INTO mark VALUES(?, ?, ?, ?)";
		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, mark.getSubjectID());
			statement.setString(2, mark.getId());
			statement.setDouble(3, mark.getMidtest());
			statement.setDouble(4, mark.getFinaltest());
			
			statement.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "The student has mark before", "ERROR!", 2);
		} finally {
			connectUtil.disconnection(conn);
		}
	}
}
