/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.DBConnection;
import java.sql.*;

public class UserDAO {

    public User validateUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                User u = new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
                u.setUserId(rs.getInt("user_id"));
                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean createUser(User user) {
        String sql = "INSERT INTO users "
                + "(username, password, role, first_name, last_name, email) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, "Assistant"); // 🔒 ignore combo box
            pst.setString(4, user.getFirstName());
            pst.setString(5, user.getLastName());
            pst.setString(6, user.getEmail());

            return pst.executeUpdate() > 0;

        } catch (SQLIntegrityConstraintViolationException ex) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
