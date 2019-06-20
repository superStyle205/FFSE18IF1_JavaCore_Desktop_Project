package ft.coffee;

import ft.coffee.model.bo.StaffBoImpl;
import ft.coffee.view.LoginFrame;

public class MainClass {
	public static void main(String[] args) {
		LoginFrame frame = new LoginFrame(new StaffBoImpl());
		frame.setVisible(true);
		frame.checkExistUser();
	}
}
