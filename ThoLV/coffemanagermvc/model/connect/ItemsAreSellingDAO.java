package coffemanagermvc.model.connect;

import coffemanagermvc.model.bean.ItemsAreSelling;
import coffemanagermvc.model.connect.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemsAreSellingDAO {

    public boolean checkSameItem(ItemsAreSelling itemsAreSelling, String idTable){
        List<ItemsAreSelling> itemsAreSellings = new ArrayList<>();
        String sql = "SELECT * FROM itemsareselling WHERE MaBan = ? AND MaDoUong = ? AND GhiChu = ?";
        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,idTable);
            statement.setString(2,itemsAreSelling.getIdItem());
            statement.setString(3,itemsAreSelling.getNote());

            ResultSet result = statement.executeQuery();
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
        return false;
    }

    public List<ItemsAreSelling> getAllItems(){
        List<ItemsAreSelling> itemsAreSellings = new ArrayList<>();
        String sql = "SELECT * FROM itemsareselling";
        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet result = statement.executeQuery();
            while (result.next()){
                ItemsAreSelling itemsAreSelling = new ItemsAreSelling();
                itemsAreSelling.setIdTable(result.getString("MaBan"));
                itemsAreSelling.setIdItem(result.getString("MaDoUong"));
                itemsAreSelling.setNoItem(result.getInt("SoLuong"));
                itemsAreSelling.setNote(result.getString("GhiChu"));

                itemsAreSellings.add(itemsAreSelling);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
        return itemsAreSellings;
    }

    public List<ItemsAreSelling> getAllItemsByTable(String idTable){
        List<ItemsAreSelling> itemsAreSellings = new ArrayList<>();
        String sql = "SELECT * FROM itemsareselling WHERE MaBan = ?";
        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,idTable);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                ItemsAreSelling itemsAreSelling = new ItemsAreSelling();
                itemsAreSelling.setIdTable(idTable);
                itemsAreSelling.setIdItem(result.getString("MaDoUong"));
                itemsAreSelling.setNoItem(result.getInt("SoLuong"));
                itemsAreSelling.setNote(result.getString("GhiChu"));

                itemsAreSellings.add(itemsAreSelling);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
        return itemsAreSellings;
    }

    public void addItem(ItemsAreSelling itemsAreSelling) {
        String sql = "INSERT INTO itemsareselling VALUES(?, ?, ?, ?)";
        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, itemsAreSelling.getIdTable());
            statement.setString(2, itemsAreSelling.getIdItem());
            statement.setInt(3, itemsAreSelling.getNoItem());
            statement.setString(4, itemsAreSelling.getNote());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
    }

    public Integer noItem(ItemsAreSelling itemsAreSelling){
        String sql = "SELECT * FROM itemsareselling WHERE MaBan = ? and MaDoUong = ? and GhiChu = ?";
        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, itemsAreSelling.getIdTable());
            statement.setString(2, itemsAreSelling.getIdItem());
            statement.setString(3,itemsAreSelling.getNote());

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                return result.getInt("SoLuong");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
        return null;
    }

    public void plusItemInTable(ItemsAreSelling itemsAreSelling){
        String sql = "UPDATE itemsareselling SET SoLuong = ? WHERE MaBan = ? AND MaDoUong = ?  AND GhiChu =  ?";
        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, noItem(itemsAreSelling) + itemsAreSelling.getNoItem());
            statement.setString(2, itemsAreSelling.getIdTable());
            statement.setString(3, itemsAreSelling.getIdItem());
            statement.setString(4, itemsAreSelling.getNote());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
    }

    public void deleteItemInTable(ItemsAreSelling itemsAreSelling) {
        String sql = "UPDATE itemsareselling SET SoLuong = ? WHERE MaBan = ? AND MaDoUong = ? AND GhiChu = ?";
        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, noItem(itemsAreSelling) - itemsAreSelling.getNoItem());
            statement.setString(2, itemsAreSelling.getIdTable());
            statement.setString(3, itemsAreSelling.getIdItem());
            statement.setString(4,itemsAreSelling.getNote());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
    }

    public void deleteRowItemInTable(ItemsAreSelling itemsAreSelling) {
        String sql = "DELETE FROM itemsareselling WHERE MaBan = ? AND MaDoUong = ? AND GhiChu = ?";
        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, itemsAreSelling.getIdTable());
            statement.setString(2, itemsAreSelling.getIdItem());
            statement.setString(3,itemsAreSelling.getNote());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
    }

    public void deleteAllItemInTable(String idTable) {
        String sql = "DELETE FROM itemsareselling WHERE MaBan = ? ";
        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, idTable);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
    }

}
