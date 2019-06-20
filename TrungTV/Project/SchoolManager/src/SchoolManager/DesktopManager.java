package SchoolManager;

import javax.swing.JFrame;
import java.awt.Color;

import java.awt.Font;
import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.Class;
import Database.Mark;
import Database.Student;
import Database.Subject;
import Database.Teacher;
import UserDao.Class_Dao;
import UserDao.Mark_Dao;
import UserDao.Student_Dao;
import UserDao.Subject_Dao;
import UserDao.Teacher_Dao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class DesktopManager extends JFrame implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;

	private JPanel studentManager;
	private JPanel teacherManager;
	private JPanel classManager;
	private JPanel markManager;

	private DefaultTableModel tableModelStudent;
	private DefaultTableModel tableModelTeacher;
	private DefaultTableModel tableModelSubject;
	private DefaultTableModel tableModelClass;
	private DefaultTableModel tableModelMark;

	private JScrollPane jScrollPane;
	private JScrollPane scrollPane_1;

	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClean;
	private JButton btnExit;
	private JButton btnAddTeacher;
	private JButton btnUpdateTeacher;
	private JButton btnDeleteTeacher;
	private JButton btnCleanTeacher;
	private JButton btnAddSub;
	private JButton btnUpdateSub;
	private JButton btnCleanSub;
	private JButton btnSearch;
	private JButton btnAddClass;
	private JButton btnUpdateClass;
	private JButton btnDeleteClass;
	private JButton btnCleanClassInfor;
	private JButton btnAddMark;
	private JButton btnUpdateMark;
	private JButton btnDeleteMark;
	private JButton btnCleanMarkInfor;

	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private ButtonGroup groupSex;

	private JTable jTableStudent;
	private JTable jTableTeacher;
	private JTable jTableSubject;
	private JTable jTableClass;
	private JTable jTableMark;

	private JLabel lblNewLabel_1;
	private JLabel lblFirstname;
	private JLabel lblLastname;
	private JLabel lblBirdthday;
	private JLabel lblSex;
	private JLabel lblCountry;
	private JLabel lblClassId;
	private JLabel label_ID;
	private JLabel label_Lastname;
	private JLabel label_Firstname;
	private JLabel label_Birthday;
	private JLabel label_Sex;
	private JLabel label_Country;
	private JLabel label_ClassID;
	private JTextField txtID;
	private JTextField txtLastname;
	private JTextField txtFirstname;
	private JTextField txtBirthday;
	private JTextField txtCountry;
	private JLabel lblName;
	private JLabel lblSubjectsId;
	private JLabel lblLevel;
	private JLabel lblPhoneNumber;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JTextField txtPhoneNum;
	private JTextField txtName;
	private JTextField txtTeacherID;
	private JLabel lblSubjectID;
	private JLabel lblSubject;
	private JLabel lblCredit;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_9;
	private JTextField txtSubjectID;
	private JTextField txtSubject;
	private JTextField txtCredits;
	private JTextField txtSearch;
	private JComboBox<String> ccbClassID;
	private JPanel panelInfor_1;
	private JLabel lblMaLop;
	private JLabel lblTnLp;
	private JLabel lblGioVinCh;
	private JLabel lblNinKha;
	private JPanel panelBtn;
	private JPanel panelTableClass;

	private Student_Dao student_Dao = new Student_Dao();
	private Teacher_Dao teacher_Dao = new Teacher_Dao();
	private Subject_Dao subject_Dao = new Subject_Dao();
	private Class_Dao class_Dao = new Class_Dao();
	private Mark_Dao mark_Dao = new Mark_Dao();

	private JTextField txtClassID;
	private JTextField txtClass;
	private JTextField txtSeniorMaster;
	private JTextField txtYear;
	private JTextField txtStudentID;
	private JTextField txtMidTest;
	private JTextField txtFinalText;
	private JTextField txtSearchStudent;
	private JScrollPane scrollPaneClass;
	private JScrollPane scrollPaneMark;

	private JComboBox<String> ccbSubjectID;
	private JComboBox<String> cbbSubjectID;
	JComboBox<String> cbbLevel;

	public DesktopManager() {
		super("School Manager");
		setType(Type.POPUP);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		getContentPane().setBackground(new Color(224, 255, 255));
		getContentPane().setLayout(null);

		JTabbedPane schoolManager = new JTabbedPane(JTabbedPane.TOP);
		schoolManager.setFont(new Font("Arial", Font.BOLD, 22));
		schoolManager.setBounds(0, 0, 993, 700);
		schoolManager.setBackground(new Color(255, 240, 245));
		schoolManager.setForeground(new Color(0, 0, 205));
		getContentPane().add(schoolManager);

		// Create Panel Student : //

		Border borderSI = BorderFactory.createLineBorder(new Color(192, 192, 192));
		TitledBorder titleSI = BorderFactory.createTitledBorder(borderSI, "Student Information");

		studentManager = new JPanel();
		studentManager.setBackground(new Color(224, 255, 255));
		schoolManager.addTab("Student",
				new ImageIcon("C:\\Users\\Hi\\Desktop\\JavaCore\\baitap\\SchoolManager\\bin\\student.png"),
				studentManager, null);
		schoolManager.setEnabledAt(0, true);
		studentManager.setLayout(null);

		// Create Table Student : //

		tableModelStudent = new DefaultTableModel();
		tableModelStudent.addColumn("ID");
		tableModelStudent.addColumn("Last Name");
		tableModelStudent.addColumn("First Name");
		tableModelStudent.addColumn("Birthday");
		tableModelStudent.addColumn("Sex");
		tableModelStudent.addColumn("Country");
		tableModelStudent.addColumn("Class ID");

		jTableStudent = new JTable(tableModelStudent);
		jTableStudent.setFillsViewportHeight(true);
		jTableStudent.setBackground(new Color(240, 255, 255));
		jScrollPane = new JScrollPane(jTableStudent);
		jScrollPane.setBounds(15, 16, 943, 357);

		studentManager.add(jScrollPane);
		jTableStudent.addMouseListener(this);

		// Create buttons student //

		btnAdd = new JButton(" ADD");
		btnAdd.setIcon(new ImageIcon("C:\\Users\\Hi\\Desktop\\JavaCore\\baitap\\SchoolManager\\bin\\employee.png"));
		btnAdd.addActionListener(this);
		btnAdd.setBounds(40, 379, 200, 40);
		studentManager.add(btnAdd);

		btnUpdate = new JButton("UPDATE");
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\Hi\\Desktop\\JavaCore\\baitap\\SchoolManager\\bin\\refresh.png"));
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(40, 435, 200, 40);
		studentManager.add(btnUpdate);

		btnDelete = new JButton("DELETE");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\Hi\\Desktop\\JavaCore\\baitap\\SchoolManager\\bin\\user (1).png"));
		btnDelete.addActionListener(this);
		btnDelete.setBounds(40, 491, 200, 40);
		studentManager.add(btnDelete);

		btnClean = new JButton("CLEAN");
		btnClean.setIcon(new ImageIcon("C:\\Users\\Hi\\Desktop\\JavaCore\\baitap\\SchoolManager\\bin\\broom.png"));
		btnClean.addActionListener(this);
		btnClean.setBounds(40, 547, 200, 40);
		studentManager.add(btnClean);

		btnExit = new JButton("EXIT");
		btnExit.setIcon(new ImageIcon("C:\\Users\\Hi\\Desktop\\JavaCore\\baitap\\SchoolManager\\bin\\logout.png"));
		btnExit.addActionListener(this);
		btnExit.setBounds(40, 603, 200, 40);
		studentManager.add(btnExit);

		// Create panel student's information //

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(224, 255, 255));

		panel_2.setBorder(titleSI);
		panel_2.setBounds(255, 379, 699, 262);
		studentManager.add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(35, 45, 95, 24);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		panel_2.add(lblNewLabel_1);

		lblFirstname = new JLabel("Lastname");
		lblFirstname.setFont(new Font("Arial", Font.BOLD, 20));
		lblFirstname.setBounds(35, 85, 95, 24);
		panel_2.add(lblFirstname);

		lblLastname = new JLabel("Firstname");
		lblLastname.setFont(new Font("Arial", Font.BOLD, 20));
		lblLastname.setBounds(35, 125, 95, 24);
		panel_2.add(lblLastname);

		lblBirdthday = new JLabel("Birdthday");
		lblBirdthday.setFont(new Font("Arial", Font.BOLD, 20));
		lblBirdthday.setBounds(35, 165, 95, 24);
		panel_2.add(lblBirdthday);

		lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Arial", Font.BOLD, 20));
		lblSex.setBounds(35, 205, 95, 24);
		panel_2.add(lblSex);

		lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Arial", Font.BOLD, 20));
		lblCountry.setBounds(347, 165, 95, 24);
		panel_2.add(lblCountry);

		lblClassId = new JLabel("Class ID");
		lblClassId.setFont(new Font("Arial", Font.BOLD, 20));
		lblClassId.setBounds(347, 205, 95, 24);
		panel_2.add(lblClassId);

		label_ID = new JLabel(":");
		label_ID.setFont(new Font("Arial", Font.BOLD, 20));
		label_ID.setBounds(132, 45, 19, 24);
		panel_2.add(label_ID);

		label_Lastname = new JLabel(":");
		label_Lastname.setFont(new Font("Arial", Font.BOLD, 20));
		label_Lastname.setBounds(132, 85, 19, 24);
		panel_2.add(label_Lastname);

		label_Firstname = new JLabel(":");
		label_Firstname.setFont(new Font("Arial", Font.BOLD, 20));
		label_Firstname.setBounds(132, 125, 19, 24);
		panel_2.add(label_Firstname);

		label_Birthday = new JLabel(":");
		label_Birthday.setFont(new Font("Arial", Font.BOLD, 20));
		label_Birthday.setBounds(132, 165, 19, 24);
		panel_2.add(label_Birthday);

		label_Sex = new JLabel(":");
		label_Sex.setFont(new Font("Arial", Font.BOLD, 20));
		label_Sex.setBounds(132, 205, 19, 24);
		panel_2.add(label_Sex);

		label_Country = new JLabel(":");
		label_Country.setFont(new Font("Arial", Font.BOLD, 20));
		label_Country.setBounds(435, 165, 19, 24);
		panel_2.add(label_Country);

		label_ClassID = new JLabel(":");
		label_ClassID.setFont(new Font("Arial", Font.BOLD, 20));
		label_ClassID.setBounds(435, 205, 19, 24);
		panel_2.add(label_ClassID);

		txtID = new JTextField();
		txtID.setFont(new Font("Arial", Font.PLAIN, 18));
		txtID.setBounds(145, 45, 520, 26);
		panel_2.add(txtID);
		txtID.setColumns(10);

		txtLastname = new JTextField();
		txtLastname.setFont(new Font("Arial", Font.PLAIN, 18));
		txtLastname.setColumns(10);
		txtLastname.setBounds(145, 85, 520, 26);
		panel_2.add(txtLastname);

		txtFirstname = new JTextField();
		txtFirstname.setFont(new Font("Arial", Font.PLAIN, 18));
		txtFirstname.setColumns(10);
		txtFirstname.setBounds(145, 125, 520, 26);
		panel_2.add(txtFirstname);

		txtBirthday = new JTextField();
		txtBirthday.setFont(new Font("Arial", Font.PLAIN, 18));
		txtBirthday.setColumns(10);
		txtBirthday.setBounds(145, 165, 187, 26);
		panel_2.add(txtBirthday);

		txtCountry = new JTextField();
		txtCountry.setFont(new Font("Arial", Font.PLAIN, 18));
		txtCountry.setColumns(10);
		txtCountry.setBounds(457, 165, 208, 26);
		panel_2.add(txtCountry);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(224, 255, 255));
		rdbtnMale.setBounds(155, 204, 80, 29);
		panel_2.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(224, 255, 255));
		rdbtnFemale.setBounds(242, 204, 89, 29);
		panel_2.add(rdbtnFemale);

		groupSex = new ButtonGroup();
		groupSex.add(rdbtnMale);
		groupSex.add(rdbtnFemale);

		ccbClassID = new JComboBox<String>();
		ccbClassID.setBackground(new Color(224, 255, 255));
		ccbClassID.setFont(new Font("Arial", Font.PLAIN, 16));
		ccbClassID.setBounds(457, 205, 208, 26);
		panel_2.add(ccbClassID);

		// Create panel Teacher - Subject : //

		teacherManager = new JPanel();
		teacherManager.setBackground(new Color(224, 255, 255));
		teacherManager.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		schoolManager.addTab("Teacher - Subject",
				new ImageIcon("C:\\Users\\Hi\\Desktop\\JavaCore\\baitap\\SchoolManager\\bin\\books-stack-of-three.png"),
				teacherManager, null);
		schoolManager.setEnabledAt(1, true);

		JPanel panelTeacher = new JPanel();
		panelTeacher.setBackground(new Color(224, 255, 255));
		panelTeacher.setBorder(new TitledBorder(new LineBorder(new Color(160, 160, 160), 2, true),
				"Teacher Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		panelTeacher.setBounds(15, 16, 514, 624);
		teacherManager.add(panelTeacher);
		panelTeacher.setLayout(null);
		// Create Table Teacher //
		tableModelTeacher = new DefaultTableModel();
		tableModelTeacher.addColumn("Teacher's ID");
		tableModelTeacher.addColumn("Name");
		tableModelTeacher.addColumn("Subject's ID");
		tableModelTeacher.addColumn("Level");
		tableModelTeacher.addColumn("Phone.No");
		teacherManager.setLayout(null);

		jTableTeacher = new JTable(tableModelTeacher);
		jTableTeacher.setFillsViewportHeight(true);
		jTableTeacher.setBackground(new Color(240, 255, 255));
		scrollPane_1 = new JScrollPane(jTableTeacher);
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBounds(15, 254, 484, 354);
		panelTeacher.add(scrollPane_1);
		jTableTeacher.addMouseListener(this);

		// Create Teacher Information //

		JLabel lblTeachersId = new JLabel("Teacher's ID");
		lblTeachersId.setFont(new Font("Arial", Font.BOLD, 20));
		lblTeachersId.setBounds(15, 27, 135, 30);
		panelTeacher.add(lblTeachersId);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.BOLD, 20));
		lblName.setBounds(15, 73, 135, 20);
		panelTeacher.add(lblName);

		lblSubjectsId = new JLabel("Subject's ID");
		lblSubjectsId.setFont(new Font("Arial", Font.BOLD, 20));
		lblSubjectsId.setBounds(15, 109, 135, 20);
		panelTeacher.add(lblSubjectsId);

		lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Arial", Font.BOLD, 20));
		lblLevel.setBounds(15, 145, 135, 20);
		panelTeacher.add(lblLevel);

		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 20));
		lblPhoneNumber.setBounds(15, 182, 147, 20);
		panelTeacher.add(lblPhoneNumber);

		label_4 = new JLabel(":");
		label_4.setFont(new Font("Arial", Font.BOLD, 20));
		label_4.setBounds(165, 32, 20, 20);
		panelTeacher.add(label_4);

		label_5 = new JLabel(":");
		label_5.setFont(new Font("Arial", Font.BOLD, 20));
		label_5.setBounds(165, 73, 20, 20);
		panelTeacher.add(label_5);

		label_6 = new JLabel(":");
		label_6.setFont(new Font("Arial", Font.BOLD, 20));
		label_6.setBounds(165, 109, 20, 20);
		panelTeacher.add(label_6);

		label_7 = new JLabel(":");
		label_7.setFont(new Font("Arial", Font.BOLD, 20));
		label_7.setBounds(165, 146, 20, 20);
		panelTeacher.add(label_7);

		label_8 = new JLabel(":");
		label_8.setFont(new Font("Arial", Font.BOLD, 20));
		label_8.setBounds(165, 182, 20, 20);
		panelTeacher.add(label_8);

		cbbLevel = new JComboBox<String>();
		cbbLevel.setForeground(Color.BLACK);
		cbbLevel.setBackground(Color.WHITE);
		cbbLevel.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Doctor", "Professor", "Manter" }));
		cbbLevel.setFont(new Font("Arial", Font.PLAIN, 18));
		cbbLevel.setBounds(200, 143, 299, 26);
		panelTeacher.add(cbbLevel);

		cbbSubjectID = new JComboBox<String>();
		cbbSubjectID.setBackground(Color.WHITE);
		cbbSubjectID.setForeground(Color.BLACK);
		cbbSubjectID.setFont(new Font("Arial", Font.PLAIN, 18));
		cbbSubjectID.setBounds(200, 107, 299, 26);
		panelTeacher.add(cbbSubjectID);

		txtPhoneNum = new JTextField();
		txtPhoneNum.setBounds(200, 180, 299, 26);
		panelTeacher.add(txtPhoneNum);
		txtPhoneNum.setColumns(10);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(200, 71, 299, 26);
		panelTeacher.add(txtName);

		txtTeacherID = new JTextField();
		txtTeacherID.setColumns(10);
		txtTeacherID.setBounds(200, 30, 299, 26);
		panelTeacher.add(txtTeacherID);
		// Create Buttons Teacher //
		btnAddTeacher = new JButton("ADD");
		btnAddTeacher.setIcon(new ImageIcon("C:\\Users\\Hi\\Desktop\\JavaCore\\baitap\\SchoolManager\\bin\\add.png"));
		btnAddTeacher.setBounds(15, 218, 110, 29);
		btnAddTeacher.addActionListener(this);
		panelTeacher.add(btnAddTeacher);

		btnUpdateTeacher = new JButton("UPDATE");
		btnUpdateTeacher.setFont(new Font("Arial", Font.PLAIN, 14));
		btnUpdateTeacher
				.setIcon(new ImageIcon("C:\\Users\\Hi\\Desktop\\JavaCore\\baitap\\SchoolManager\\bin\\refresh.png"));
		btnUpdateTeacher.addActionListener(this);
		btnUpdateTeacher.setBounds(135, 219, 121, 29);
		panelTeacher.add(btnUpdateTeacher);

		btnDeleteTeacher = new JButton("DELETE");
		btnDeleteTeacher.setIcon(new ImageIcon("D:\\delete.png"));
		btnDeleteTeacher.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDeleteTeacher.setBounds(265, 218, 121, 29);
		btnDeleteTeacher.addActionListener(this);
		panelTeacher.add(btnDeleteTeacher);

		btnCleanTeacher = new JButton("CLEAN");
		btnCleanTeacher
				.setIcon(new ImageIcon("C:\\Users\\Hi\\Desktop\\JavaCore\\baitap\\SchoolManager\\bin\\broom.png"));
		btnCleanTeacher.addActionListener(this);
		btnCleanTeacher.setBounds(390, 218, 110, 29);
		panelTeacher.add(btnCleanTeacher);
		// Create Subject Inform //
		JPanel panelSubject = new JPanel();
		panelSubject.setBackground(new Color(224, 255, 255));
		panelSubject.setBorder(new TitledBorder(new LineBorder(new Color(160, 160, 160), 2, true), "Subject",
				TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panelSubject.setBounds(544, 16, 414, 624);
		teacherManager.add(panelSubject);
		panelSubject.setLayout(null);

		lblSubjectID = new JLabel("Subject's ID");
		lblSubjectID.setFont(new Font("Arial", Font.BOLD, 20));
		lblSubjectID.setBounds(30, 30, 120, 29);
		panelSubject.add(lblSubjectID);

		lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Arial", Font.BOLD, 20));
		lblSubject.setBounds(30, 75, 120, 29);
		panelSubject.add(lblSubject);

		lblCredit = new JLabel("Credits");
		lblCredit.setFont(new Font("Arial", Font.BOLD, 20));
		lblCredit.setBounds(30, 120, 120, 29);
		panelSubject.add(lblCredit);

		label_2 = new JLabel(":");
		label_2.setFont(new Font("Arial", Font.BOLD, 20));
		label_2.setBounds(165, 35, 20, 20);
		panelSubject.add(label_2);

		label_3 = new JLabel(":");
		label_3.setFont(new Font("Arial", Font.BOLD, 20));
		label_3.setBounds(165, 80, 20, 20);
		panelSubject.add(label_3);

		label_9 = new JLabel(":");
		label_9.setFont(new Font("Arial", Font.BOLD, 20));
		label_9.setBounds(165, 125, 20, 20);
		panelSubject.add(label_9);

		txtSubjectID = new JTextField();
		txtSubjectID.setBounds(200, 32, 146, 26);
		panelSubject.add(txtSubjectID);
		txtSubjectID.setColumns(10);

		txtSubject = new JTextField();
		txtSubject.setColumns(10);
		txtSubject.setBounds(200, 77, 146, 26);
		panelSubject.add(txtSubject);

		txtCredits = new JTextField();
		txtCredits.setColumns(10);
		txtCredits.setBounds(200, 122, 146, 26);
		panelSubject.add(txtCredits);

		// Create Buttons Subjects//

		btnAddSub = new JButton("ADD");
		btnAddSub.setIcon(new ImageIcon("D:\\add-circular-button.png"));
		btnAddSub.setBounds(15, 218, 110, 29);
		btnAddSub.addActionListener(this);
		panelSubject.add(btnAddSub);

		btnUpdateSub = new JButton("UPDATE");
		btnUpdateSub.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdateSub.setIcon(new ImageIcon("D:\\rotate.png"));
		btnUpdateSub.addActionListener(this);
		btnUpdateSub.setBounds(140, 218, 120, 29);
		panelSubject.add(btnUpdateSub);

		btnCleanSub = new JButton("CLEAN");
		btnCleanSub.setIcon(new ImageIcon("D:\\broom.png"));
		btnCleanSub.setBounds(276, 218, 110, 29);
		btnCleanSub.addActionListener(this);
		panelSubject.add(btnCleanSub);

		// Create Table Subject //

		tableModelSubject = new DefaultTableModel();
		tableModelSubject.addColumn("Subject ID");
		tableModelSubject.addColumn("Subject");
		tableModelSubject.addColumn("Credits");

		jTableSubject = new JTable(tableModelSubject);
		jTableSubject.setFillsViewportHeight(true);
		jTableSubject.setBackground(new Color(240, 255, 255));
		JScrollPane scrollPaneSubject = new JScrollPane(jTableSubject);
		scrollPaneSubject.setBounds(30, 256, 356, 352);
		panelSubject.add(scrollPaneSubject);
		jTableSubject.addMouseListener(this);

		txtSearch = new JTextField();
		txtSearch.setText("Search subject");
		txtSearch.setToolTipText("");
		txtSearch.setFont(new Font("Arial", Font.ITALIC, 20));
		txtSearch.setBounds(15, 165, 322, 37);
		panelSubject.add(txtSearch);
		txtSearch.setColumns(10);

		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon("C:\\Users\\Hi\\Desktop\\JavaCore\\baitap\\SchoolManager\\bin\\magnifier.png"));
		btnSearch.setBounds(352, 164, 34, 35);
		btnSearch.addActionListener(this);
		panelSubject.add(btnSearch);

		// Create Class Manager //

		classManager = new JPanel();
		classManager.setBackground(new Color(224, 255, 255));
		schoolManager.addTab("Class",
				new ImageIcon("C:\\Users\\Hi\\Desktop\\JavaCore\\baitap\\SchoolManager\\bin\\classroom.png"),
				classManager, null);
		classManager.setLayout(null);

		panelBtn = new JPanel();
		panelBtn.setBounds(15, 16, 200, 628);
		classManager.add(panelBtn);
		panelBtn.setBackground(new Color(250, 250, 210));
		panelBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBtn.setLayout(null);

		btnAddClass = new JButton("ADD");
		btnAddClass.setBounds(15, 42, 170, 71);
		btnAddClass.addActionListener(this);
		panelBtn.add(btnAddClass);

		btnUpdateClass = new JButton("UPDATE");
		btnUpdateClass.setBounds(15, 178, 170, 71);
		btnUpdateClass.addActionListener(this);
		panelBtn.add(btnUpdateClass);

		btnDeleteClass = new JButton("DELETE");
		btnDeleteClass.setBounds(15, 323, 170, 71);
		btnDeleteClass.addActionListener(this);
		panelBtn.add(btnDeleteClass);

		btnCleanClassInfor = new JButton("CLEAN");
		btnCleanClassInfor.setBounds(15, 471, 170, 71);
		btnCleanClassInfor.addActionListener(this);
		panelBtn.add(btnCleanClassInfor);

		panelInfor_1 = new JPanel();
		panelInfor_1.setBounds(237, 397, 721, 233);
		classManager.add(panelInfor_1);
		panelInfor_1.setBackground(new Color(224, 255, 255));
		panelInfor_1
				.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfor_1.setLayout(null);

		lblMaLop = new JLabel("Class ID :");
		lblMaLop.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaLop.setBounds(70, 39, 120, 28);
		panelInfor_1.add(lblMaLop);

		lblTnLp = new JLabel("Class :");
		lblTnLp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnLp.setBounds(70, 83, 120, 28);
		panelInfor_1.add(lblTnLp);

		lblGioVinCh = new JLabel("Senior Master:");
		lblGioVinCh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGioVinCh.setBounds(39, 129, 151, 28);
		panelInfor_1.add(lblGioVinCh);

		lblNinKha = new JLabel("Year :");
		lblNinKha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNinKha.setBounds(39, 173, 151, 28);
		panelInfor_1.add(lblNinKha);

		txtClassID = new JTextField();
		txtClassID.setBounds(205, 40, 501, 26);
		panelInfor_1.add(txtClassID);
		txtClassID.setColumns(10);

		txtClass = new JTextField();
		txtClass.setColumns(10);
		txtClass.setBounds(205, 84, 501, 26);
		panelInfor_1.add(txtClass);

		txtSeniorMaster = new JTextField();
		txtSeniorMaster.setColumns(10);
		txtSeniorMaster.setBounds(205, 128, 501, 26);
		panelInfor_1.add(txtSeniorMaster);

		txtYear = new JTextField();
		txtYear.setColumns(10);
		txtYear.setBounds(205, 174, 501, 26);
		panelInfor_1.add(txtYear);
		// Create Table Class //
		panelTableClass = new JPanel();
		panelTableClass.setBounds(235, 16, 723, 363);
		classManager.add(panelTableClass);
		panelTableClass.setBorder(new LineBorder(new Color(0, 0, 0)));

		tableModelClass = new DefaultTableModel();
		tableModelClass.addColumn("Class ID");
		tableModelClass.addColumn("Class");
		tableModelClass.addColumn("Teacher's ID");
		tableModelClass.addColumn("Teacher");
		tableModelClass.addColumn("School Year");
		panelTableClass.setLayout(null);

		jTableClass = new JTable(tableModelClass);
		jTableClass.setFillsViewportHeight(true);
		scrollPaneClass = new JScrollPane(jTableClass);
		scrollPaneClass.setBounds(0, 0, 723, 363);
		panelTableClass.add(scrollPaneClass);
		jTableClass.addMouseListener(this);

		// Create Panel Mark //

		markManager = new JPanel();
		markManager.setBackground(new Color(224, 255, 255));
		schoolManager.addTab("Mark", new ImageIcon("D:\\seven.png"), markManager, null);
		markManager.setLayout(null);

		JPanel mark = new JPanel();
		mark.setBackground(new Color(240, 255, 255));
		mark.setBorder(new LineBorder(new Color(0, 0, 0)));
		mark.setBounds(15, 16, 771, 257);
		markManager.add(mark);
		mark.setLayout(null);

		// Mark Information //

		JLabel lblSubjectId = new JLabel("Subject ID    :");
		lblSubjectId.setFont(new Font("Arial", Font.BOLD, 18));
		lblSubjectId.setBounds(15, 51, 175, 36);
		mark.add(lblSubjectId);

		JLabel lblStudentsId = new JLabel("Student's ID :");
		lblStudentsId.setFont(new Font("Arial", Font.BOLD, 18));
		lblStudentsId.setBounds(15, 120, 175, 36);
		mark.add(lblStudentsId);

		JLabel lblMidTest = new JLabel("Mid test :");
		lblMidTest.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMidTest.setFont(new Font("Arial", Font.BOLD, 18));
		lblMidTest.setBounds(383, 51, 140, 36);
		mark.add(lblMidTest);

		JLabel lblFinalExam = new JLabel("Final exam :");
		lblFinalExam.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFinalExam.setFont(new Font("Arial", Font.BOLD, 18));
		lblFinalExam.setBounds(383, 120, 140, 36);
		mark.add(lblFinalExam);

		txtStudentID = new JTextField();
		txtStudentID.setFont(new Font("Arial", Font.PLAIN, 20));
		txtStudentID.setColumns(10);
		txtStudentID.setBounds(179, 115, 225, 45);
		mark.add(txtStudentID);

		txtMidTest = new JTextField();
		txtMidTest.setFont(new Font("Arial", Font.PLAIN, 20));
		txtMidTest.setColumns(10);
		txtMidTest.setBounds(531, 45, 225, 45);
		mark.add(txtMidTest);

		txtFinalText = new JTextField();
		txtFinalText.setFont(new Font("Arial", Font.PLAIN, 20));
		txtFinalText.setColumns(10);
		txtFinalText.setBounds(531, 115, 225, 45);
		mark.add(txtFinalText);

		txtSearchStudent = new JTextField();
		txtSearchStudent.setFont(new Font("Arial", Font.PLAIN, 20));
		txtSearchStudent.setBounds(277, 205, 389, 36);
		mark.add(txtSearchStudent);
		txtSearchStudent.setColumns(10);

		JLabel lblNewLabel = new JLabel("Search :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(120, 205, 142, 36);
		mark.add(lblNewLabel);

		ccbSubjectID = new JComboBox<String>();
		ccbSubjectID.setForeground(Color.BLACK);
		ccbSubjectID.setFont(new Font("Arial", Font.PLAIN, 18));
		ccbSubjectID.setBackground(Color.WHITE);
		ccbSubjectID.setBounds(179, 45, 225, 45);
		mark.add(ccbSubjectID);

		// Mark button //

		JPanel markTable = new JPanel();
		markTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		markTable.setBounds(15, 289, 958, 355);
		markManager.add(markTable);
		markTable.setLayout(null);

		btnAddMark = new JButton("ADD");
		btnAddMark.setBounds(802, 16, 171, 41);
		btnAddMark.addActionListener(this);
		markManager.add(btnAddMark);

		btnUpdateMark = new JButton("UPDATE");
		btnUpdateMark.setBounds(801, 84, 171, 41);
		btnUpdateMark.addActionListener(this);
		markManager.add(btnUpdateMark);

		btnDeleteMark = new JButton("DELETE");
		btnDeleteMark.setBounds(801, 158, 171, 41);
		btnDeleteMark.addActionListener(this);
		markManager.add(btnDeleteMark);

		btnCleanMarkInfor = new JButton("CLEAN");
		btnCleanMarkInfor.setBounds(801, 230, 171, 41);
		btnCleanMarkInfor.addActionListener(this);
		markManager.add(btnCleanMarkInfor);
		// Create Table Mark //
		panelTableClass = new JPanel();
		panelTableClass.setBounds(235, 16, 723, 363);
		classManager.add(panelTableClass);
		panelTableClass.setBorder(new LineBorder(new Color(0, 0, 0)));

		tableModelMark = new DefaultTableModel();
		tableModelMark.addColumn("Subject ID");
		tableModelMark.addColumn("Student's ID");
		tableModelMark.addColumn("Mid Test");
		tableModelMark.addColumn("Final Exam");
		tableModelMark.addColumn("Average");
		tableModelMark.addColumn("Classification");
		markTable.setLayout(null);

		jTableMark = new JTable(tableModelMark);
		jTableMark.setFillsViewportHeight(true);
		scrollPaneMark = new JScrollPane(jTableMark);
		scrollPaneMark.setBounds(0, 0, 958, 355);
		markTable.add(scrollPaneMark);
		jTableMark.addMouseListener(this);
		// *
		// *
		setBackground(new Color(224, 255, 255));
		setSize(1000, 740);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Start //
		ccbSubjectID.removeAllItems();
		cbbSubjectID.removeAllItems();
		ccbClassID.removeAllItems();
		getIdClass();
		getIdSubject();
		loadData();

	}

	// Function necessary //

	// Load data for table //

	private void loadData() {
		tableModelStudent.setRowCount(0);
		tableModelTeacher.setRowCount(0);
		tableModelSubject.setRowCount(0);
		tableModelClass.setRowCount(0);
		tableModelMark.setRowCount(0);

		List<Student> listStudent = student_Dao.getAllStudent();
		List<Teacher> listTeacher = teacher_Dao.getAllTeacher();
		List<Subject> listSubject = subject_Dao.getAllSubject();
		List<Database.Class> listClass = class_Dao.getAllClass();
		List<Mark> listMark = mark_Dao.getAllMark();

		for (Student student : listStudent) {
			tableModelStudent.addRow(new String[] { student.getId(), student.getLastname(), student.getFirstname(),
					student.getBirthday(), student.getSex(), student.getCountry(), student.getClassid() });
		}
		for (Teacher teacher : listTeacher) {
			tableModelTeacher.addRow(new String[] { teacher.getTeacherID(), teacher.getName(), teacher.getSubjectID(),
					teacher.getLevel(), teacher.getPhonenumber() });
		}
		for (Subject subject : listSubject) {
			tableModelSubject
					.addRow(new String[] { subject.getSubjectID(), subject.getSubject(), "" + subject.getCredits() });
		}
		for (Class class1 : listClass) {
			tableModelClass.addRow(new String[] { class1.getClassID(), class1.getClassName(), class1.getTeacherID(),
					this.searchTeacher(class1.getTeacherID()), "" + class1.getSchoolYear() });
		}
		for (Mark mark : listMark) {
			tableModelMark.addRow(new String[] { mark.getSubjectID(), mark.getId(), "" + mark.getMidtest(),
					"" + mark.getFinaltest(), "" + this.getAverage(mark.getMidtest(), mark.getFinaltest()),
					"" + this.getClassification(this.getAverage(mark.getMidtest(), mark.getFinaltest())) });
		}

	}

	private void loadSearchData() {
		tableModelSubject.setRowCount(0);

		List<Subject> searchSubject = subject_Dao.searchSub(txtSearch.getText());

		if (searchSubject.isEmpty()) {
			JOptionPane.showMessageDialog(null, "The list is Empty", "ERROR!", 2);
		} else {
			for (Subject subject : searchSubject) {
				tableModelSubject.addRow(
						new String[] { subject.getSubjectID(), subject.getSubject(), "" + subject.getCredits() });
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (studentManager.isShowing()) {
			if (action == btnAdd) {
				addStudent();
				loadData();
			} else if (action == btnUpdate) {
				updateStudent();
				loadData();
			} else if (action == btnDelete) {
				deleteStudent();
				loadData();
			} else if (action == btnClean) {
				clearInputStudent();
			} else {
				System.exit(0);
			}
		} else if (teacherManager.isShowing()) {
			if (action == btnAddTeacher) {
				addTeacher();
				loadData();
			} else if (action == btnUpdateTeacher) {
				updateTeacher();
				loadData();
			} else if (action == btnDeleteTeacher) {
				deleteTeacher();
				loadData();
			} else if (action == btnCleanTeacher) {
				clearInputTeacher();
			} else if (action == btnAddSub) {
				addSub();
				cbbSubjectID.removeAllItems();
				getIdSubject();
				loadData();
			} else if (action == btnUpdateSub) {
				updateSub();
				cbbSubjectID.removeAllItems();
				getIdSubject();
				loadData();
			} else if (action == btnCleanClassInfor) {
				cleanInputSub();
				loadData();
			} else if (action == btnSearch) {
				subject_Dao.searchSub(txtSearch.getText());
				loadSearchData();
			}
		} else if (classManager.isShowing()) {
			if (action == btnAddClass) {
				addClass();
				loadData();
			} else if (action == btnUpdateClass) {
				updateClass();
				loadData();
			} else if (action == btnDeleteClass) {
				deleteClass();
				loadData();
			} else if (action == btnCleanClassInfor) {
				cleanInputClass();
			}
		} else if (markManager.isShowing()) {
			if (action == btnAddMark) {
				addMark();
				loadData();
			} else if (action == btnUpdateMark) {
//				updateMark();
				loadData();
			} else if (action == btnDeleteMark) {
//				deleteMark();
				loadData();
			} else if (action == btnCleanMarkInfor) {
//				clearInputMark();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (studentManager.isShowing()) {
			int rowSelected = jTableStudent.getSelectedRow();
			txtID.setText((String) jTableStudent.getValueAt(rowSelected, 0));
			txtLastname.setText((String) jTableStudent.getValueAt(rowSelected, 1));
			txtFirstname.setText((String) jTableStudent.getValueAt(rowSelected, 2));
			txtBirthday.setText((String) jTableStudent.getValueAt(rowSelected, 3));
			if (jTableStudent.getValueAt(rowSelected, 4).equals("Nam")) {
				rdbtnFemale.setSelected(true);
				rdbtnMale.setSelected(false);
			} else {
				rdbtnFemale.setSelected(false);
				rdbtnMale.setSelected(true);
			}
			txtCountry.setText((String) jTableStudent.getValueAt(rowSelected, 5));
			ccbClassID.setSelectedItem((String) jTableStudent.getValueAt(rowSelected, 6));
		}
		if (teacherManager.isShowing() && jTableTeacher.getSelectedRow() != -1) {
			int rowSelected = jTableTeacher.getSelectedRow();
			txtTeacherID.setText((String) jTableTeacher.getValueAt(rowSelected, 0));
			txtName.setText((String) jTableTeacher.getValueAt(rowSelected, 1));
			cbbSubjectID.setSelectedItem((String) jTableTeacher.getValueAt(rowSelected, 2));
			cbbLevel.setSelectedItem((String) jTableTeacher.getValueAt(rowSelected, 3));
			txtPhoneNum.setText((String) jTableTeacher.getValueAt(rowSelected, 4));

		}
		if (teacherManager.isShowing() && jTableSubject.getSelectedRow() != -1) {
			int rowSelectedSubject = jTableSubject.getSelectedRow();
			txtSubjectID.setText((String) jTableSubject.getValueAt(rowSelectedSubject, 0));
			txtSubject.setText((String) jTableSubject.getValueAt(rowSelectedSubject, 1));
			txtCredits.setText((String) jTableSubject.getValueAt(rowSelectedSubject, 2));
		}
		if (classManager.isShowing() && jTableClass.getSelectedRow() != -1) {
			int rowSelected = jTableClass.getSelectedRow();
			txtClassID.setText((String) jTableClass.getValueAt(rowSelected, 0));
			txtClass.setText((String) jTableClass.getValueAt(rowSelected, 1));
			txtSeniorMaster.setText((String) jTableClass.getValueAt(rowSelected, 2));
			txtYear.setText((String) jTableClass.getValueAt(rowSelected, 4));
		}
		if (markManager.isShowing()) {
			int rowSelected = jTableMark.getSelectedRow();
			ccbSubjectID.setSelectedItem((String) jTableMark.getValueAt(rowSelected, 0));
			txtStudentID.setText((String) jTableMark.getValueAt(rowSelected, 1));
			txtMidTest.setText((String) jTableMark.getValueAt(rowSelected, 2));
			txtFinalText.setText((String) jTableMark.getValueAt(rowSelected, 3));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	// Function about ComboBox Item//

	public void getIdSubject() {

		String sql = "SELECT * FROM subjects";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				// Display comboBox set from databse
				ccbSubjectID.addItem(result.getString("Subject_ID"));
				cbbSubjectID.addItem(result.getString("Subject_ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnection(conn);
		}

	}

	public void getIdClass() {

		String sql = "SELECT * FROM class";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				// Display comboBox set from databse
				ccbClassID.addItem(result.getString("Class_ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnection(conn);
		}
	}

	public void getIdTeacher() {

		String sql = "SELECT * FROM teacher";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				// Display comboBox set from databse
				ccbClassID.addItem(result.getString("Class_ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnection(conn);
		}
	}

	// Function at Student Panel //

	private void clearInputStudent() {
		txtID.setText("");
		txtLastname.setText("");
		txtFirstname.setText("");
		txtBirthday.setText("");
		txtCountry.setText("");
		ccbClassID.setSelectedIndex(1);
	}

	private void deleteStudent() {
		String id = (String) jTableStudent.getValueAt(jTableStudent.getSelectedRow(), 0);
		student_Dao.deleteStudent(id);
	}

	private void updateStudent() {
		Student student = new Student();

		student.setId(txtID.getText());
		student.setLastname(txtLastname.getText());
		student.setFirstname(txtFirstname.getText());
		student.setBirthday(txtBirthday.getText());
		student.setSex(this.sex());
		student.setCountry(txtCountry.getText());
		student.setClassid(ccbClassID.getSelectedItem().toString());

		student_Dao.updateStudent(student);
	}

	private void addStudent() {
		Student student = new Student();

		student.setId(txtID.getText());
		student.setLastname(txtLastname.getText());
		student.setFirstname(txtFirstname.getText());
		student.setBirthday(txtBirthday.getText());
		student.setSex(this.sex());
		student.setCountry(txtCountry.getText());
		student.setClassid(ccbClassID.getSelectedItem().toString());

		student_Dao.addStudent(student);
	}

	public String sex() {
		String sex = null;
		if (rdbtnMale.isSelected()) {
			sex = "Nữ";
		} else {
			sex = "Nam";
		}
		return sex;
	}

	// Function at Teacher - Subject Panel//

	private void addTeacher() {
		Teacher teacher = new Teacher();

		teacher.setTeacherID(txtTeacherID.getText());
		teacher.setName(txtName.getText());
		teacher.setSubjectID(cbbSubjectID.getSelectedItem().toString());
		teacher.setLevel(cbbLevel.getSelectedItem().toString());
		teacher.setPhonenumber(txtPhoneNum.getText());

		teacher_Dao.addTeacher(teacher);
	}

	private void updateTeacher() {
		Teacher teacher = new Teacher();

		teacher.setTeacherID(txtTeacherID.getText());
		teacher.setName(txtName.getText());
		teacher.setSubjectID(cbbSubjectID.getSelectedItem().toString());
		teacher.setLevel(cbbLevel.getSelectedItem().toString());
		teacher.setPhonenumber(txtPhoneNum.getText());

		teacher_Dao.updateTeacher(teacher);
	}

	private void deleteTeacher() {
		String teacherID = (String) jTableTeacher.getValueAt(jTableTeacher.getSelectedRow(), 0);
		teacher_Dao.deleteTeacher(teacherID);
	}

	private void clearInputTeacher() {
		txtTeacherID.setText("");
		txtName.setText("");
		cbbSubjectID.setSelectedIndex(0);
		cbbLevel.setSelectedIndex(0);
		txtPhoneNum.setText("");
	}

	// Function about Subject in Teacher - Subject Panel //
	private void addSub() {
		Subject subject = new Subject();

		subject.setSubjectID(txtSubjectID.getText());
		subject.setSubject(txtSubject.getText());
		subject.setCredits(Integer.parseInt(txtCredits.getText()));

		subject_Dao.addSubject(subject);
	}

	private void updateSub() {
		Subject subject = new Subject();

		subject.setSubjectID(txtSubjectID.getText());
		subject.setSubject(txtSubject.getText());
		subject.setCredits(Integer.parseInt(txtCredits.getText()));

		subject_Dao.updateSubject(subject);
	}

	private void cleanInputSub() {
		txtSubjectID.setText("");
		txtSubject.setText("");
		txtCredits.setText("");
		txtSearch.setText("");
	}

	// Function at Class Panel //

	private void addClass() {
		Class class1 = new Class();

		class1.setClassID(txtClassID.getText());
		class1.setClassName(txtClass.getText());
		class1.setTeacherID(txtTeacherID.getText());
		class1.setSchoolYear(Integer.parseInt(txtYear.getText()));

		class_Dao.addClass(class1);
	}

	private void updateClass() {
		Class class1 = new Class();

		class1.setClassID(txtClassID.getText());
		class1.setClassName(txtClass.getText());
		class1.setTeacherID(txtTeacherID.getText());
		class1.setSchoolYear(Integer.parseInt(txtYear.getText()));

		class_Dao.updateClass(class1);
	}

	private void deleteClass() {
		String classID = (String) jTableClass.getValueAt(jTableClass.getSelectedRow(), 0);
		class_Dao.deleteClass(classID);
	}

	private void cleanInputClass() {
		txtClassID.setText("");
		txtClass.setText("");
		txtSeniorMaster.setText("");
		txtYear.setText("");
	}
	
	// Function at Mark Panel //
	
	private void addMark() {
		Mark mark = new Mark();

		mark.setSubjectID(ccbSubjectID.getSelectedItem().toString());
		mark.setId(txtStudentID.getText());
		mark.setMidtest(Double.parseDouble(txtMidTest.getText()));
		mark.setFinaltest(Double.parseDouble(txtFinalText.getText()));

		mark_Dao.addMark(mark);
	}
	
	// Average Mark for Student and Classification //

	public double getAverage(Double midTest, Double finalExam) {
		double average = (midTest * 2 + finalExam * 3) / 5;
		return average;
	}

	public String getClassification(Double average) {
		String classification = null;
		if (average >= 8.5 && average <= 10.0) {
			classification = "Excellent";
		} else if (average >= 7.0 && average < 8.5) {
			classification = "Good";
		} else if (average >= 5.5 && average < 7.0) {
			classification = "Normal";
		} else if (average >= 4.0 && average < 5.5) {
			classification = "Weak";
		} else if (average < 4.0) {
			classification = "Need try hard !!";
		}
		return classification;
	}

	// Search teacher name //

	public String searchTeacher(String teacherID) {

		String sql = "SELECT * FROM teacher WHERE Teacher_ID = ?";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		String name = null;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, teacherID);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return name = resultSet.getString("Name");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnection(conn);
		}
		return name;
	}
}
