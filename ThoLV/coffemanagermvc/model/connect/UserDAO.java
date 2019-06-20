package coffemanagermvc.model.connect;

import coffemanagermvc.model.bean.User;
import coffemanagermvc.model.connect.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public boolean isExistUser(String name,String password){
        String sql = "SELECT * FROM user WHERE NameLogin = ? and PassLogin = ?";

        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();
            return result.next();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
        return false;
    }

    public String getRole(String name){
        String sql = "SELECT * FROM user WHERE NameLogin = ?";

        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,name);

            ResultSet result = statement.executeQuery();
            while (result.next()){
                return result.getString("Role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connectUtil.disconnect(conn);
        }
        return null;
    }

    public String getFullName(String name){
        String sql = "SELECT * FROM user WHERE NameLogin = ?";

        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,name);

            ResultSet result = statement.executeQuery();
            while (result.next()){
                return result.getString("TenNhanVien");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connectUtil.disconnect(conn);
        }
        return null;
    }

    public List<User> getAllUser() {
        String sql = "SELECT * FROM user";
        List<User> listUser = new ArrayList<User>();

        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            User user;
            while (result.next()) {
                user = new User();
                user.setId(result.getString("MaNhanVien"));
                user.setFullName(result.getString("TenNhanVien"));
                user.setName(result.getString("NameLogin"));
                user.setPassword(result.getString("PassLogin"));
                user.setRole(result.getString("Role"));
                listUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
        return listUser;
    }

    public void addUser(User user){
        String sql = "INSERT INTO user VALUES(NULL , ?, ?, ?, ?)";
        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
    }

    public void updateUser(User user){
        String sql = "UPDATE user SET TenNhanVien = ?, NameLogin = ?, PassLogin = ?, Role = ? WHERE MaNhanVien = ?";
        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole());
            statement.setString(5, user.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
    }


    public void deleteUser(String name){
        String sql = "DELETE FROM user WHERE NameLogin = ?";
        ConnectUtil connectUtil = new ConnectUtil();
        Connection conn = connectUtil.connect();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectUtil.disconnect(conn);
        }
    }
}
