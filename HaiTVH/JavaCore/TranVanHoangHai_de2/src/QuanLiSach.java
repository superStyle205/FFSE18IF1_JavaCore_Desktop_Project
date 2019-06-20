import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLiSach {
	ArrayList<Sach> quanlisach = new ArrayList<Sach>();
	public Scanner sc = new Scanner(System.in);

	public void menu() {
		System.out.println("1. Thêm sách");
		System.out.println("2. Cập nhật thông tin sách theo ID ");
		System.out.println("3. In ra thông tin sách theo ID  ");
		System.out.println("4. Xóa sách theo ID   ");
		System.out.println("5. In sách theo năm ");
		System.out.println("6. Tổng giá bán");
		System.out.println("7. Sắp xếp theo giá");
		int choose;
		choose = Integer.parseInt(sc.nextLine());
		switch (choose) {
		case 1:
			addSach(inputSach());
			break;
		case 2:
			updateSach();
			break;
		case 3:
			thongTinSach();
			break;
		case 4:
			xoaSach();
			break;
		case 5:
			inSachTheoNam();
			break;
		case 6:
			tongGiaBan();
			break;
		case 7:
			sapXepTheoGia();
			outputSach();
			break;
		default:
			break;
		}
	}

	public Sach inputSach() {
		System.out.print("Nhập id : ");
		int id = Integer.parseInt(sc.nextLine());

		System.out.print("Nhập tên sách : ");
		String ten = sc.nextLine();

		System.out.print("Nhập tác giả : ");
		String tacGia = sc.nextLine();

		System.out.print("Nhập năm xuất bản: ");
		int namXuatBan = Integer.parseInt(sc.nextLine());

		System.out.print("Nhập giá cả : ");
		double giaCa = Double.parseDouble(sc.nextLine());

		return new Sach(id, ten, tacGia, namXuatBan, giaCa);
	}

	public void addSach(Sach qls) {
		if (qls != null) {
			quanlisach.add(qls);
		}
	}

	public void updateSach() {
		if (quanlisach.size() == 0) {
			System.out.println("Mảng rỗng");
			System.exit(0);
		}
		System.out.println("Nhập id cần tìm để update");
		int id = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < quanlisach.size(); i++) {
			if (id == quanlisach.get(i).getId()) {

				System.out.print("Nhập tên cần update : ");
				String ten = sc.nextLine();
				quanlisach.get(i).setTen(ten);

				System.out.print("Nhập tác giả cần update : ");
				String tacGia = sc.nextLine();
				quanlisach.get(i).setTacGia(tacGia);

				System.out.print("Nhập năm cần update : ");
				int namXuatBan = Integer.parseInt(sc.nextLine());
				quanlisach.get(i).setNamXuatBan(namXuatBan);

				System.out.print("Nhập giá cần update : ");
				double giaCa = Double.parseDouble(sc.nextLine());
				quanlisach.get(i).setGiaCa(giaCa);

			} else {
				System.out.println("Không tồn tại id sách cần update ");
			}
		}
	}

	public void thongTinSach() {
		System.out.print("Nhập id sách cần in : ");
		if (quanlisach.size() == 0) {
			System.out.println("Mảng rỗng");
		}
		int id = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < quanlisach.size(); i++) {
			if (quanlisach.get(i).getId() == id) {
				System.out.print("ID sách: " + quanlisach.get(i).getId() + ",    ");
				System.out.print("Tên sách : " + quanlisach.get(i).getTen() + ",    ");
				System.out.print("Tên tác giả : " + quanlisach.get(i).getTacGia() + ",   ");
				System.out.print("Năm xuất bản : " + quanlisach.get(i).getNamXuatBan() + ",   ");
				System.out.print("Giá cả  : " + quanlisach.get(i).getGiaCa() + "\n");
			} else {
				System.out.println("không tồn tại id sách");

			}
		}
	}

	public void xoaSach() {
		System.out.println("Nhập id sách cần xóa");
		if (quanlisach.size() == 0) {
			System.out.println("Mảng rỗng");
		}
		int id = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < quanlisach.size(); i++) {
			if (quanlisach.get(i).getId() == id) {
				quanlisach.remove(i);
				System.out.println("đã xóa ! ");
			} else {
				System.out.println("id sách không tồn tại ");
			}
		}
	}

	public void inSachTheoNam() {
		System.out.println("Nhập năm cần in : ");
		if (quanlisach.size() == 0) {
			System.out.println("Mảng rỗng");
		}
		int namXuatBan = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < quanlisach.size(); i++) {
			if (quanlisach.get(i).getNamXuatBan() == namXuatBan) {
				System.out.print("ID sách: " + quanlisach.get(i).getId() + ",    ");
				System.out.print("Tên sách : " + quanlisach.get(i).getTen() + ",    ");
				System.out.print("Tên tác giả : " + quanlisach.get(i).getTacGia() + ",   ");
				System.out.print("Năm xuất bản : " + quanlisach.get(i).getNamXuatBan() + ",   ");
				System.out.print("Giá cả  : " + quanlisach.get(i).getGiaCa() + "\n");
			} else {
				System.out.println("Năm xuất bản không tồn tại");
			}
		}
	}

	public void tongGiaBan() {
		int tongGiaBan = 0;
		for (int i = 0; i < quanlisach.size(); i++) {
			tongGiaBan += quanlisach.get(i).getGiaCa();
		}
		System.out.println("tổng tiền phải trả "+tongGiaBan);
	}

	public void sapXepTheoGia() {
		Collections.sort(quanlisach, new Comparator<Sach>() {
			@Override

			public int compare(Sach quanlisach2, Sach quanlisach1) {
				if (quanlisach1.getGiaCa() < quanlisach2.getGiaCa() ) {
					return 1;
				} else {
					if (quanlisach1.getGiaCa()  == quanlisach2.getGiaCa() ) {
						return
								0;
					} else {
						return -1;
						 
					}
				}
			}

		});
	}

	public void outputSach() {
		for (int i = 0; i < quanlisach.size(); i++) {
			System.out.print("ID sách: " + quanlisach.get(i).getId() + ",    ");
			System.out.print("Tên sách : " + quanlisach.get(i).getTen() + ",    ");
			System.out.print("Tên tác giả : " + quanlisach.get(i).getTacGia() + ",   ");
			System.out.print("Năm xuất bản : " + quanlisach.get(i).getNamXuatBan() + ",   ");
			System.out.print("Giá cả  : " + quanlisach.get(i).getGiaCa() + "\n");

		}
	}

}
