package ft.coffee.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ft.coffee.common.ConnectUtil;
import ft.coffee.model.bean.Staff;

public class StaffDaoImpl implements StaffDao {

	@Override
	public Staff getStaff(String username) throws SQLException {
		String sql = "select * from staff where userName = ?";
		Staff staff = null;

		Connection connection = ConnectUtil.getConnect();
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			resultset = statement.executeQuery();
			if (resultset.next()) {
				staff = new Staff();
				staff.setUserName(resultset.getString("userName"));
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			ConnectUtil.closeResultSet(resultset);
			ConnectUtil.closeStatement(statement);
			ConnectUtil.closeConnect(connection);
		}
		return staff;
	}

	@Override
	public boolean addStaff(Staff staff) throws SQLException {
		String sqlLockTableStaff = "Lock tables staff write;";
		String sqlGetTotalRecord = "set @id = (SELECT ( total + 1 ) FROM ( SELECT COUNT( staffId ) AS total FROM staff ) AS TMPTABLE);";
		String sqlAddStaff = "insert into staff(userName, password, staffCode, role) value(?, ?, CONCAT('NV', @id), ?);";
		String sqlUnlockTableStaff = "unlock tables;";
		Connection connection = ConnectUtil.getConnect();
		PreparedStatement statement = null;
		try {
			connection.setAutoCommit(false);

			statement = connection.prepareStatement(sqlLockTableStaff);
			statement.execute();
			ConnectUtil.closeStatement(statement);

			statement = connection.prepareStatement(sqlGetTotalRecord);
			statement.execute();
			ConnectUtil.closeStatement(statement);

			statement = connection.prepareStatement(sqlAddStaff);
			statement.setString(1, staff.getUserName());
			statement.setString(2, staff.getPassword());
			statement.setInt(3, staff.getRole());
			int changeCount = statement.executeUpdate();

			statement = connection.prepareStatement(sqlUnlockTableStaff);
			statement.execute();
			ConnectUtil.closeStatement(statement);

			connection.commit();
			if (changeCount != 0) {
				return true;
			}
		} catch (SQLException e) {
			connection.rollback();
			throw new SQLException(e.getMessage());
		} finally {
			ConnectUtil.closeConnect(connection);
		}
		return false;
	}

	@Override
	public Staff getStaff(String username, String password) throws SQLException {
		String sql = "select * from staff where userName = ? and password = ?";
		Staff staff = null;
		Connection connection = ConnectUtil.getConnect();
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			resultset = statement.executeQuery();
			if (resultset.next()) {
				staff = new Staff();
				staff.setUserName(resultset.getString("userName"));
				staff.setPassword(resultset.getString("password"));
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			ConnectUtil.closeResultSet(resultset);
			ConnectUtil.closeStatement(statement);
			ConnectUtil.closeConnect(connection);
		}
		return staff;
	}

}
