package coffemanagermvc.model.connect;

import coffemanagermvc.model.bean.Menu;
import coffemanagermvc.model.connect.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {

    public List<Menu> getAll() {
        String sql = "SELECT * FROM menu";
        List<Menu> listMenu = new ArrayList<Menu>();

        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Menu menu = new Menu();
                menu.setId(result.getString("MaDoUong"));
                menu.setName(result.getString("TenDoUong"));
                menu.setPrice(result.getString("Gia"));
                listMenu.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
        return listMenu;
    }

    public String getIdByName(String nameItem){
        String sql = "SELECT MaDoUong FROM menu WHERE TenDoUong = ?";
        List<Menu> listMenu = new ArrayList<Menu>();

        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,nameItem);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                return result.getString("MaDoUong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }

        return null;
    }

    public String getNameById(String id){
        String sql = "SELECT * FROM menu WHERE MaDoUong = ?";
        List<Menu> listMenu = new ArrayList<Menu>();

        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                return result.getString("TenDoUong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
        return null;
    }

    public Integer getPriceByName(String name){
        String sql = "SELECT * FROM menu WHERE TenDoUong = ?";
        List<Menu> listMenu = new ArrayList<Menu>();

        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,name);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                return result.getInt("Gia");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
        return null;
    }
}
