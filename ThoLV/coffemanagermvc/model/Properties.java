package coffemanagermvc.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Properties {
    /*
    MainWindow
     */
    public static int flowLayoutMainWinDownHgap = 0;
    public static int flowLayoutMainWinDownGgap = 0;
    public static LayoutManager layoutMainWinDown = new FlowLayout(FlowLayout.LEFT, flowLayoutMainWinDownHgap, flowLayoutMainWinDownGgap);
    public static int widthMainWindow = 1080;
    public static int heightMainWindow = 607;
    public static String title = "Coffee Manager";
    public static int widthPanelMainWindown = widthMainWindow - 14;
    public static int heightPanelMainWindown = heightMainWindow - 37;

    /*
    Panel Top
     */
    public static int heightPanelTop = heightPanelMainWindown / 10;
    public static int widthPanelTop = widthPanelMainWindown;
    public static String[] tenBtnTop = {"Sơ đồ bàn", "Thực đơn", "Thống kê", "Quản lí"};
    public static int soBtnTop = 9;
    public static Color colorBackGroundPanelTop = new Color(60, 179, 113);
    public static Font fontNameLogin = new Font("Arial", Font.BOLD, 18);
    public static Color colorNameLogin = new Color(195, 0, 4);


    /*
    Panel Center
     */
    public static int flowLayoutCenterHgap = 5;
    public static int flowLayoutCenterGgap = 5;
    public static LayoutManager layoutCenter = new FlowLayout(FlowLayout.LEFT, flowLayoutCenterHgap, flowLayoutCenterGgap);
    public static int heightPanelCenter = heightPanelMainWindown / 10;
    public static int widthPanelCenter = widthPanelMainWindown;
    public static Color colorBackGroundPanelCenter = new Color(253, 238, 255);
    public static String[] tenKhu = {"Khu A", "Khu B", "Khu C", "Khu D"};
    public static int soBtnCenter = 7;

    /*
    Panle Bot
     */
    public static int flowLayoutBotHgap = 0;
    public static int flowLayoutBotGgap = 0;
    public static LayoutManager layoutBot = new FlowLayout(FlowLayout.LEFT, flowLayoutBotHgap, flowLayoutBotGgap);
    public static int heightPanelBot = heightPanelMainWindown - heightPanelTop - heightPanelCenter;
    public static int widthPanelBot = widthPanelMainWindown;

    //Panel Bot Left

    public static int flowLayoutBotLeftHgap = 10;
    public static int flowLayoutBotLeftGgap = 10;
    public static LayoutManager layoutBotLeft = new FlowLayout(FlowLayout.LEFT, flowLayoutBotLeftHgap, flowLayoutBotLeftGgap);

    public static int heightPanelBotLeft = heightPanelMainWindown - heightPanelTop - heightPanelCenter;
    public static int widthPanelBotLeft = widthPanelMainWindown / 2;

    public static Font fontBtnTable = new Font("Arial", Font.BOLD, 18);
    public static int soBanMoiHang = 5;
    public static String[] tenBan = {"A", "B", "C", "D"};
    public static int[] soBanCuaTungKhu = {6, 10, 2, 6};
    public static ArrayList<String> nameTable = nameTable();

    //Panel Bot Right

    public static int flowLayoutBotRightHgap = 5;
    public static int flowLayoutBotRightGgap = 5;
    public static LayoutManager layoutBotRight = new FlowLayout(FlowLayout.LEFT, flowLayoutBotRightHgap, flowLayoutBotRightGgap);
    public static int heightPanelBotRight = heightPanelBotLeft;
    public static int widthPanelBotRight = widthPanelMainWindown - widthPanelBotLeft;
    //Bot Right Top

    public static int heightPanelBotRightTop = heightPanelBotRight / 2;
    public static int widthPanelBotRightTop = widthPanelBotRight - 20;
    public static LayoutManager layoutContainerBotRightTop = new CardLayout();
    public static int[] tiLeChieuDaiCuaTungCot = {2, 8, 4, 3, 4};
    public static String[] tenCot = {"Stt", "Tên món", "Đơn giá", "Số lượng", "Thành tiền"};
    public static Font fontHeaderTable = new Font("Serif", Font.BOLD, 15);
    public static Font fontTable = new Font("Serif", Font.TRUETYPE_FONT, 15);

    //Bot Right Bot

    public static int flowLayoutBotRightBotHgap = 0;
    public static int flowLayoutBotRightBotGgap = 0;
    public static LayoutManager layoutBotRightBot = new FlowLayout(FlowLayout.LEFT, flowLayoutBotRightBotHgap, flowLayoutBotRightBotGgap);
    public static int heightPanelBotRightBot = heightPanelBotRight - heightPanelBotRightTop;
    public static int widthPanelBotRightBot = widthPanelBotRight;


    //Bot Right Bot Left
    public static int flowLayoutBotRightBotLeftHgap = 20;
    public static int flowLayoutBotRightBotLeftGgap = 10;
    public static LayoutManager layoutBotRightBotLeft = new FlowLayout(FlowLayout.LEFT, flowLayoutBotRightBotLeftHgap, flowLayoutBotRightBotLeftGgap);
    public static int heightPanelBotRightBotLeft = heightPanelBotRight - heightPanelBotRightTop;
    public static int widthPanelBotRightBotLeft = widthPanelBotRight / 2 + 30;


    //Bot Right Bot Right
    public static int flowLayoutBotRightBotRightHgap = 0;
    public static int flowLayoutBotRightBotRightGgap = 10;
    public static LayoutManager layoutBotRightBotRight = new FlowLayout(FlowLayout.LEFT, flowLayoutBotRightBotRightHgap, flowLayoutBotRightBotRightGgap);
    public static int heightPanelBotRightBotRight = heightPanelBotRight - heightPanelBotRightTop;
    public static int widthPanelBotRightBotRight = widthPanelBotRight - widthPanelBotRightBotLeft;

    public static int widthBtnBotRightBot = (widthPanelBotRightBotLeft - 3 * flowLayoutBotRightBotLeftHgap) / 2;
    public static int heightBtnBotRightBot = widthBtnBotRightBot / 2;

    public static Font fontTotal = new Font("Arial", Font.BOLD, 20);
    public static Color colorTotal = new Color(195, 0, 4);

    public static Font fontPay = new Font("Arial", Font.BOLD, 18);
    public static Color colorPay = new Color(195, 0, 4);
    public static int flowLayoutDMTopHgap = 10;


    /*
     * Dialog Menu
     * */
    public static int flowLayoutDMTopGgap = 10;
    public static LayoutManager layoutDMTop = new FlowLayout(FlowLayout.LEFT, flowLayoutDMTopHgap, flowLayoutDMTopGgap);
    public static String[] nameBtnTopDM = {"Tất cả", "Cà phê", "Nước ép", "Đá xoay", "Sữa chua", "Khác"};
    public static String[] columnsNameDM = {"Stt", "Tên món", "Đơn giá", "Số lượng", "Ghi chú"};
    public static String[] columnsCheck = {"Tên món","Số lượng","Ghi chú"};
    public static int[] columnLengthRatioDM = {1, 5, 3, 3, 8};
    public static int[] columnLengthRatioCheck= {5, 3, 8};

    public static int tinhTong(int[] array) {
        int tong = 0;
        for (int i = 0; i < array.length; i++) {
            tong += array[i];
        }
        return tong;
    }

    public static ArrayList<String> nameTable(){
        ArrayList<String> nameTable = new ArrayList<>();
        for (int i = 0; i <tenKhu.length; i++) {
            /*
            tất cả bàn được khai báo chung trong một mảng JButton
            số bắt đầu là (vị trí bắt đầu) của (button bàn đầu tiên) trong (mảng btnBan) của (khu đang khởi tạo)
            ví dụ khu B có số bắt đầu là 20 (vì khu A có 20 bàn), bàn B1 = btnBan[20].
            tương tự với số kết thúc để có thể xác định được vị trí cuối cùng.
            */
            int soBatDau = 0;
            int soKetThuc = 0;
            for (int y = 0; y < i; y++) {
                soBatDau +=soBanCuaTungKhu[y];
            }
            soKetThuc = soBatDau + soBanCuaTungKhu[i];
            for (int y = soBatDau; y < soKetThuc; y++) {
                nameTable.add(tenBan[i] + (y - soBatDau + 1));
            }
        }
        return nameTable;
    }

    /*
    Dialog Table
     */
    public static int widthPanelDialogTableCenterRight = 150;
    public static int heightPanleBot = Properties.heightPanelMainWindown - Properties.heightPanelBotRightTop * 3 / 2 - Properties.heightPanelTop;

    /*
    Panel Manager
     */
    public static String[] nameBtnCenterManager = {"Nhân Viên", "Thực đơn"};

    /*
    Panel Account
     */
    public static Object[] options = {"XÁC NHẬN", "HỦY"};
    public static Object[] role = {"Nhân viên","Quản lí"};
    public static Font fontTF = new Font("aria",Font.BOLD,16);

    /*
    Panle Bot Manager
     */
    public static String[] nameColumnBM = {"Mã nhân viên", "Tên", "Tên đăng nhập", "Mật khẩu", "Chức vụ"};
    public static int[] columnLengthRatioDMBM = {2, 5, 2, 2, 2};

    /*
    For all
     */
    public static Color colorBtnAction = new Color(234, 128, 37);
    public static Color colorBtnTableEmptyItem = new Color(0, 0, 0);

    public static String newToString(String nameItem, String note) {
        /*
        ghép tên và phần ghi chú thành 1 chuỗi
         */
        if (note.equals("")) {
            return nameItem;
        }
        return nameItem + " (" + note + ")";
    }

    public static List<String> separatingCharacterStrings(String string){
        List<String> strings = new ArrayList<String>();
        try {
            strings.add(string.substring(0, string.indexOf("(") - 1));
            strings.add(string.substring(string.indexOf("(")+1, string.lastIndexOf(")")));
        }catch (Exception e){
            strings.add(string);
            strings.add("");
        }
        return strings;
    }
}
