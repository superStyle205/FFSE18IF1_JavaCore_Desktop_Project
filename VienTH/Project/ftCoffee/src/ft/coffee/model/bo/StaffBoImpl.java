package ft.coffee.model.bo;

import java.sql.SQLException;

import ft.coffee.model.bean.Staff;
import ft.coffee.model.dao.StaffDao;
import ft.coffee.model.dao.StaffDaoImpl;

public class StaffBoImpl implements StaffBo {

	private StaffDao staffDao = new StaffDaoImpl();

	@Override
	public boolean isExistStaff(String username) throws SQLException {
		return staffDao.getStaff(username) != null;
	}

	@Override
	public void addNewAdminAccount() throws SQLException {
		Staff staff = new Staff();
		staff.setUserName("admin");
		staff.setPassword("");
		staff.setRole(1);
		staffDao.addStaff(staff);
	}

	@Override
	public boolean isExistStaff(String username, String password) throws SQLException {
		return staffDao.getStaff(username, password) != null;
	}

}
