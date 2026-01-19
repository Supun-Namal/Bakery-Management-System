/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public boolean insert(Product p) {
        String sql = "INSERT INTO products(name, category, price, qty, alert_level) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, p.getName());
            pst.setString(2, p.getCategory());
            pst.setDouble(3, p.getPrice());
            pst.setInt(4, p.getQty());
            pst.setInt(5, p.getAlertLevel());

            int res = pst.executeUpdate();
            return res > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products ORDER BY product_id DESC";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Product p = new Product(
                    rs.getString("name"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("qty"),
                    rs.getInt("alert_level")
                );
                p.setProductId(rs.getInt("product_id"));
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> searchByName(String keyword) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE name LIKE ? ORDER BY product_id DESC";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, "%" + keyword + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                    rs.getString("name"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("qty"),
                    rs.getInt("alert_level")
                );
                p.setProductId(rs.getInt("product_id"));
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Product> getLowStockProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE qty <= alert_level";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Product p = new Product(
                    rs.getString("name"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("qty"),
                    rs.getInt("alert_level")
                );
                p.setProductId(rs.getInt("product_id"));
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean update(Product p) {
        String sql = "UPDATE products SET name = ?, category = ?, price = ?, qty = ?, alert_level = ? WHERE product_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, p.getName());
            pst.setString(2, p.getCategory());
            pst.setDouble(3, p.getPrice());
            pst.setInt(4, p.getQty());
            pst.setInt(5, p.getAlertLevel());
            pst.setInt(6, p.getProductId());

            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int productId) {
        String sql = "DELETE FROM products WHERE product_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, productId);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
