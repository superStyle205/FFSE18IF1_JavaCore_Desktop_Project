package view;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import view.component.ManagerHomePanel;
import view.component.ManagerStudentClassPanel;
import view.component.ManagerStudentInfoPanel;
import view.component.ManagerStudentScorePanel;
import view.component.ManagerStudentSubjectPanel;
import view.component.ManagerStudentTeacherPanel;

public class ApplicationFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTabbedPane contentPanel;
	private ManagerHomePanel managerHomePanel;
	private ManagerStudentInfoPanel managerStudentInfoPanel;
	private ManagerStudentScorePanel managerStudentScorePanel;
	private ManagerStudentClassPanel managerStudentClassPanel;
	private ManagerStudentSubjectPanel managerStudentSubjectPanel;
	private ManagerStudentTeacherPanel managerStudentTeacherPanel;

	public ApplicationFrame() {
		super("Quản Lý Trường Học");
		setBounds(60, 50, 1800, 965);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		Container container = getContentPane();
		contentPanel = new JTabbedPane();
		container.add(contentPanel);

		managerHomePanel = new ManagerHomePanel();
		contentPanel.addTab(ManagerHomePanel.TAB_NAME, ManagerHomePanel.TAB_ICON, managerHomePanel);

		managerStudentInfoPanel = new ManagerStudentInfoPanel();
		contentPanel.addTab(ManagerStudentInfoPanel.TAB_NAME, ManagerStudentInfoPanel.TAB_ICON,
				managerStudentInfoPanel);

		managerStudentClassPanel = new ManagerStudentClassPanel();
		contentPanel.addTab(ManagerStudentClassPanel.TAB_NAME, ManagerStudentClassPanel.TAB_ICON,
				managerStudentClassPanel);

		managerStudentTeacherPanel = new ManagerStudentTeacherPanel();
		contentPanel.addTab(ManagerStudentTeacherPanel.TAB_NAME, ManagerStudentTeacherPanel.TAB_ICON,
				managerStudentTeacherPanel);

		managerStudentSubjectPanel = new ManagerStudentSubjectPanel();
		contentPanel.addTab(ManagerStudentSubjectPanel.TAB_NAME, ManagerStudentSubjectPanel.TAB_ICON,
				managerStudentSubjectPanel);

		managerStudentScorePanel = new ManagerStudentScorePanel();
		contentPanel.addTab(ManagerStudentScorePanel.TAB_NAME, ManagerStudentScorePanel.TAB_ICON,
				managerStudentScorePanel);

	}

	public void main(String[] args) {

		ApplicationFrame application = new ApplicationFrame();
		application.setVisible(true);
	}

}
