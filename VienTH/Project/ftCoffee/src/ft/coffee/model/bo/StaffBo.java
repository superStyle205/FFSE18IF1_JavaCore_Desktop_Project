package ft.coffee.model.bo;

import java.sql.SQLException;

public interface StaffBo {

	public boolean isExistStaff(String username) throws SQLException;

	public boolean isExistStaff(String username, String password) throws SQLException;

	public void addNewAdminAccount() throws SQLException;

}
