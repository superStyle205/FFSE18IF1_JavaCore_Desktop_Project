package ft.coffee.model.dao;

import java.sql.SQLException;

import ft.coffee.model.bean.Staff;

public interface StaffDao {

	public Staff getStaff(String username) throws SQLException;

	public Staff getStaff(String username, String password) throws SQLException;

	public boolean addStaff(Staff staff) throws SQLException;

}
