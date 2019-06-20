package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ClassStudent;
import model.Diem;
import model.Mon;
import model.Student;
import model.Teacher;
import view.AppView;

public class SchoolDao {
	Student student;
	Teacher teacher;
	ClassStudent classStudent;
	AppView appView;
	Diem diem;
	Mon mon;

	
	// sau đây các hàm getll
	public ArrayList<Student> getAllStudent() {
		String sql = "SELECT hocsinh.maHocSinh, hocsinh.tenHocSinh, hocsinh.ngaySinhHS, hocsinh.gioiTinhHS, hocsinh.queQuanHS, hocsinh.SDTHocSinh, hocsinh.maLop, hocsinh.hoTenCha, "
				+ "hocsinh.hoTenMe, hocsinh.SDTPhuHuynh, hocsinh.diaChiLienHe, lop.tenLop, hocsinh.ghiChuHS FROM hocsinh,lop WHERE lop.maLop = hocsinh.maLop;";
		ArrayList<Student> litsStudent = new ArrayList<Student>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Student student;
			while (result.next()) {
				student = new Student();
				student.setMaHocSinh(result.getString("maHocSinh"));
				student.setTenHocSinh(result.getString("tenHocSinh"));
				student.setNgaySinhHS(result.getString("ngaySinhHS"));
				student.setGioiTinhHS(result.getString("gioiTinhHS"));
				student.setQueQuanHS(result.getString("queQuanHS"));
				student.setSDTHocSinh(result.getString("SDTHocSinh"));
				student.setMaLop(result.getString("maLop"));
				student.setHoTenCha(result.getString("hoTenCha"));
				student.setHoTenMe(result.getString("hoTenMe"));
				student.setSDTPhuHuynh(result.getString("SDTPhuHuynh"));
				student.setDiaChiLienHe(result.getString("diaChiLienHe"));
				student.setTenLop(result.getString("tenLop"));
				student.setGhiChuHS(result.getString("ghiChuHS"));
				litsStudent.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		return litsStudent;
	}

	public ArrayList<Teacher> getAllTeacher() {
		String sql = "SELECT * FROM giaovien";
		ArrayList<Teacher> litsTeacher = new ArrayList<Teacher>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Teacher teacher;
			while (result.next()) {
				teacher = new Teacher();
				teacher.setMaGV(result.getString("maGiaoVien"));
				teacher.setTenGV(result.getString("tenGiaoVien"));
				teacher.setNgaySinhGV(result.getString("ngaySinhGV"));
				;
				teacher.setGioiTinhGV(result.getString("gioiTinhGV"));
				teacher.setQueQuanGV(result.getString("queQuanGV"));
				teacher.setSDTGV(result.getString("SDTGV"));
				teacher.setTrinhDo(result.getString("trinhDo"));
				teacher.setEmail(result.getString("email"));
				teacher.setGhiChuGV(result.getString("ghiChuGV"));
				;

				litsTeacher.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		return litsTeacher;
	}

	public ArrayList<ClassStudent> getAllClassStudent() {
		String sql = "SELECT lop.maLop, lop.tenLop, lop.maGiaoVien, giaovien.tenGiaoVien, lop.ghiChuLop FROM lop, giaovien WHERE lop.maGiaoVien = giaovien.maGiaoVien;";
		ArrayList<ClassStudent> litsClass = new ArrayList<ClassStudent>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			ClassStudent classStudent;
			while (result.next()) {
				classStudent = new ClassStudent();
				classStudent.setMaLop(result.getString("maLop"));
				classStudent.setTenLop(result.getString("tenLop"));
				classStudent.setMaGiaoVien_lop(result.getString("maGiaoVien"));
				;
				classStudent.setTenGiaoVien_lop(result.getString("tenGiaoVien"));
				classStudent.setGhiChuLop(result.getString("ghiChuLop"));

				litsClass.add(classStudent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		return litsClass;
	}
	
	public ArrayList<Diem> getAllDiem() {
		String sql = "SELECT bangdiem.maHocSinh, hocsinh.tenHocSinh, hocsinh.maLop, lop.tenLop, bangdiem.maMonHoc, monhoc.tenMonHoc, bangdiem.diem15P1, bangdiem.diem15p2, "
				+ "bangdiem.diem1T, bangdiem.diemCuoiKy1, bangdiem.diemCuoiKy2, bangdiem.tongDiem FROM bangdiem, hocsinh, monhoc, lop WHERE bangdiem.maHocSinh = hocsinh.maHocSinh "
				+ "and hocsinh.maLop = lop.maLop and bangdiem.maMonHoc = monhoc.maMonHoc";
		ArrayList<Diem> litsDiem = new ArrayList<Diem>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Diem diem;
			while (result.next()) {
				diem = new Diem();
				diem.setMaHoSinh(result.getInt("maHocSinh"));
				diem.setTenHocSinh_Diem(result.getString("tenHocSinh"));
				diem.setMaLop(result.getString("maLop"));
				diem.setTenLop_Diem(result.getString("tenLop"));
				diem.setMaMon(result.getString("maMonHoc"));
				diem.setTenMon_Diem(result.getString("tenMonHoc"));
				diem.setDiem15P1(result.getFloat("diem15P1"));
				diem.setDiem15P2(result.getFloat("diem15P2"));
				diem.setDiem1T(result.getFloat("diem1T"));
				diem.setDiemHocKy1(result.getFloat("diemCuoiKy1"));
				diem.setDiemHocKy2(result.getFloat("diemCuoiKy2"));
				diem.setTongDiem(result.getFloat("tongDiem"));
				
				litsDiem.add(diem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		return litsDiem;
	}
	
	public ArrayList<Mon> getAllMon() {
		String sql = "SELECT monhoc.maMonHoc, monhoc.tenMonHoc, monhoc.maGiaoVien, giaovien.tenGiaoVien, monhoc.ghiChuMon FROM monhoc, giaovien WHERE monhoc.maGiaoVien = giaovien.maGiaoVien;";
		ArrayList<Mon> litsMon = new ArrayList<Mon>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Mon mon ;
			while (result.next()) {
				mon = new Mon();
				
				mon.setMaMon_Mon(result.getString("maMonHoc"));
				mon.setTenMon_Mon(result.getString("tenMonHoc"));
				mon.setMaGiaoVien_Mon(result.getString("maGiaoVien"));
				mon.setTenGiaoVien_Mon(result.getString("tenGiaoVien"));
				mon.setGhiChuMon(result.getString("ghiChuMon"));

				litsMon.add(mon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
		return litsMon;
	}

	//sau đây là các hàm add
	public void addTeacherDao(Teacher teacher) {
		String sql = " INSERT INTO giaovien VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, teacher.getTenGV());
			statement.setString(2, teacher.getNgaySinhGV());
			statement.setString(3, teacher.getGioiTinhGV());
			statement.setString(4, teacher.getQueQuanGV());
			statement.setString(5, teacher.getSDTGV());
			statement.setString(6, teacher.getTrinhDo());
			statement.setString(7, teacher.getEmail());
			statement.setString(8, teacher.getGhiChuGV());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void addStudentDao(Student student) {
		String sql = " INSERT INTO hocsinh VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, student.getTenHocSinh());
			statement.setString(2, student.getNgaySinhHS());
			statement.setString(3, student.getGioiTinhHS());
			statement.setString(4, student.getQueQuanHS());
			statement.setString(5, student.getSDTHocSinh());
			statement.setString(6, student.getMaLop());
			statement.setString(7, student.getHoTenCha());
			statement.setString(8, student.getHoTenMe());
			statement.setString(9, student.getSDTPhuHuynh());
			statement.setString(10, student.getDiaChiLienHe());
			statement.setString(11, student.getGhiChuHS());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void addClassStudentDao(ClassStudent classStudent) {
		String sql = " INSERT INTO lop VALUES ( ?, ?, ?, ?)";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, classStudent.getMaLop());
			statement.setString(2, classStudent.getTenLop());
			statement.setString(3, classStudent.getMaGiaoVien_lop());
			statement.setString(4, classStudent.getGhiChuLop());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	
	public void addDiemDao(Diem diem) {
		String sql = " INSERT INTO bangdiem VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, diem.getMaHoSinh());
			statement.setString(2, diem.getMaMon());
			statement.setFloat(3, diem.getDiem15P1());
			statement.setFloat(4, diem.getDiem15P2());
			statement.setFloat(5, diem.getDiem1T());
			statement.setFloat(6, diem.getDiemHocKy1());
			statement.setFloat(7, diem.getDiemHocKy2());
			statement.setFloat(8, diem.getTongDiem());
			

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	
	public void addMonDao(Mon mon) {
		String sql = " INSERT INTO monhoc VALUES ( ?, ?, ?, ?)";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, mon.getMaMon_Mon());
			statement.setString(2, mon.getTenMon_Mon());
			statement.setString(3, mon.getMaGiaoVien_Mon());
			statement.setString(4, mon.getGhiChuMon());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	//sau đây là các hàm update
	public void updateStusentDao(Student student) {
		String sql = "UPDATE hocsinh SET tenHocSinh = ? , ngaySinhHS = ? , gioiTinhHS = ? , queQuanHS = ? , "
				+ "SDTHocSinh = ? , maLop = ? , hoTenCha = ? , hoTenMe = ? , SDTPhuHuynh = ? , diaChiLienHe = ? , "
				+ "ghiChuHS = ? WHERE maHocSinh = ? ";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, student.getTenHocSinh());
			statement.setString(2, student.getNgaySinhHS());
			statement.setString(3, student.getGioiTinhHS());
			statement.setString(4, student.getQueQuanHS());
			statement.setString(5, student.getSDTHocSinh());
			statement.setString(6, student.getMaLop());
			statement.setString(7, student.getHoTenCha());
			statement.setString(8, student.getHoTenMe());
			statement.setString(9, student.getSDTPhuHuynh());
			statement.setString(10, student.getDiaChiLienHe());
			statement.setString(11, student.getGhiChuHS());
			statement.setString(12, student.getMaHocSinh());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void updateTeacherDao(Teacher teacher) {
		String sql = "UPDATE giaovien SET tenGiaoVien = ? , ngaySinhGV = ? , gioiTinhGV = ? , queQuanGV = ? , SDTGV = ? , trinhDo = ? ,email = ? , ghiChuGV = ? WHERE maGiaoVien = ? ";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, teacher.getTenGV());
			statement.setString(2, teacher.getNgaySinhGV());
			statement.setString(3, teacher.getGioiTinhGV());
			statement.setString(4, teacher.getQueQuanGV());
			statement.setString(5, teacher.getSDTGV());
			statement.setString(6, teacher.getTrinhDo());
			statement.setString(7, teacher.getEmail());
			statement.setString(8, teacher.getGhiChuGV());
			statement.setString(9, teacher.getMaGV());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void updateClassStudentDao(ClassStudent classStudent) {
		String sql = ("UPDATE lop SET tenLop = ? , maGiaoVien = ? , ghiChuLop = ? WHERE maLop = ? ");

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, classStudent.getTenLop());
			statement.setString(2, classStudent.getMaGiaoVien_lop());
			statement.setString(3, classStudent.getGhiChuLop());
			statement.setString(4, classStudent.getMaLop());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	
	public void updateDiemDao(Diem diem) {
		String sql = ("UPDATE bangdiem SET  maMonHoc = ? , diem15P1 = ? , diem15P2 = ? , diem1T = ? , diemCuoiKy1 = ? , diemCuoiKy2 = ? , tongDiem = ? WHERE maHocSinh = ? ");

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, diem.getMaMon());
			statement.setFloat(2, diem.getDiem15P1());
			statement.setFloat(3, diem.getDiem15P2());
			statement.setFloat(4, diem.getDiem1T());
			statement.setFloat(5, diem.getDiemHocKy1());
			statement.setFloat(6, diem.getDiemHocKy2());
			statement.setFloat(7, diem.getTongDiem());
			statement.setFloat(8, diem.getMaHoSinh());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	
	public void updateMonDao(Mon mon) {
		String sql = ("UPDATE monhoc SET tenMonHoc = ? , maGiaoVien = ? , ghiChuMon = ? WHERE maMonHoc = ? ");

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, mon.getTenMon_Mon());
			statement.setString(2, mon.getMaGiaoVien_Mon());
			statement.setString(3, mon.getGhiChuMon());
			statement.setString(4, mon.getMaMon_Mon());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	//sau đây là các hàm delete
	public void deleteStudentDao(String maHocSinh) {
		String sql = "DELETE FROM hocsinh  WHERE maHocSinh = ? ";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, maHocSinh);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void deleteTeacherDao(String maGiaoVien) {
		String sql = "DELETE FROM giaovien  WHERE maGiaoVien = ? ";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, maGiaoVien);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void deleteClassStudentDao(String maLop) {
		String sql = "DELETE FROM lop  WHERE maLop = ? ";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, maLop);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	public void deleteDiemDao(String maHocSinh, String maMonHoc) {
		String sql = "DELETE FROM bangdiem  WHERE maHocSinh = ? and maMonHoc = ?";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, maHocSinh);
			statement.setString(2, maMonHoc);
			
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}
	
	public void deleteMonDao(String maMonHoc) {
		String sql = "DELETE FROM monhoc  WHERE maMonHoc = ? ";

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, maMonHoc);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}
	}

	// sau đây là các hàm tìm kiếm
	public ArrayList<Student> searchStudent(String tenHocSinh) {
		String sql = "SELECT hocsinh.maHocSinh, hocsinh.tenHocSinh, hocsinh.ngaySinhHS, hocsinh.gioiTinhHS, hocsinh.queQuanHS, hocsinh.SDTHocSinh, hocsinh.maLop, hocsinh.hoTenCha,"
				+ " hocsinh.hoTenMe, hocsinh.SDTPhuHuynh, hocsinh.diaChiLienHe, lop.tenLop, hocsinh.ghiChuHS FROM hocsinh,lop WHERE lop.maLop = hocsinh.maLop and tenHocSinh = ?";
		ArrayList<Student> listStudentSearch = new ArrayList<Student>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		Student student;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tenHocSinh);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				student = new Student();
				student.setMaHocSinh(result.getString("maHocSinh"));
				student.setTenHocSinh(result.getString("tenHocSinh"));
				student.setNgaySinhHS(result.getString("ngaySinhHS"));
				student.setGioiTinhHS(result.getString("gioiTinhHS"));
				student.setQueQuanHS(result.getString("queQuanHS"));
				student.setSDTHocSinh(result.getString("SDTHocSinh"));
				student.setMaLop(result.getString("maLop"));
				student.setHoTenCha(result.getString("hoTenCha"));
				student.setHoTenMe(result.getString("hoTenMe"));
				student.setSDTPhuHuynh(result.getString("SDTPhuHuynh"));
				student.setDiaChiLienHe(result.getString("diaChiLienHe"));
				student.setTenLop(result.getString("tenLop"));
				student.setGhiChuHS(result.getString("ghiChuHS"));
				
				listStudentSearch.add(student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listStudentSearch;
	}
	
	public ArrayList<Teacher> searchTeacher(String tenGiaoVien) {
		String sql = "SELECT * FROM giaovien WHERE tenGiaoVien = ?";
		ArrayList<Teacher> listTeacherSearch = new ArrayList<Teacher>();

		ConnectUtil connectUtil = new ConnectUtil();
		Connection conn = connectUtil.connect();
		Teacher teacher;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tenGiaoVien);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				teacher = new Teacher();
				teacher.setMaGV(result.getString("maGiaoVien"));
				teacher.setTenGV(result.getString("tenGiaoVien"));
				teacher.setNgaySinhGV(result.getString("ngaySinhGV"));
				;
				teacher.setGioiTinhGV(result.getString("gioiTinhGV"));
				teacher.setQueQuanGV(result.getString("queQuanGV"));
				teacher.setSDTGV(result.getString("SDTGV"));
				teacher.setTrinhDo(result.getString("trinhDo"));
				teacher.setEmail(result.getString("email"));
				teacher.setGhiChuGV(result.getString("ghiChuGV"));
				;

				listTeacherSearch.add(teacher);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectUtil.disconnect(conn);
		}

		return listTeacherSearch;
	}
}
