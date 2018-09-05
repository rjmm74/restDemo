package com.robert.millar.hebDemo.Dao;

import com.robert.millar.hebDemo.Utils.ConnectionFactory;
import com.robert.millar.hebDemo.model.Inventory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//TODO add interface
//todo add logging
//todo add metrics

public class InventoryDao {
    final String PRODUCT_COLUMNS = "id, department, last_sold, shelf_life, description, price, unit, x_for, cost ";

    public List<Inventory> getInventory() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        ResultSet rs = null;
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT ".concat(PRODUCT_COLUMNS).concat(" FROM products "));
            List<Inventory> myInventory = new ArrayList();
            while (rs.next()) {
                Inventory inventory = setInventory(rs);
                myInventory.add(inventory);
            }
            return myInventory;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Inventory> getInventory(String value) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Inventory> myInventory = new ArrayList();
        try {
            stmt = connection.prepareStatement("SELECT ".concat(PRODUCT_COLUMNS)
                    .concat(" FROM products where department = ?"));
            stmt.setString(1, value);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Inventory inventory = setInventory(rs);
                myInventory.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (connection != null)
                connection.close();
        }
        return myInventory;
    }

    public List<String> getDepartment() throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        List<String> list = new ArrayList();
        ResultSet rs = null;
        Statement stmt = connection.createStatement();
        try {
            rs = stmt.executeQuery("SELECT distinct department FROM products ");
            while (rs.next()) {
                list.add(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null)
            rs.close();
            if (stmt != null)
            stmt.close();
            if (connection != null)
            connection.close();
        }
        return list;
    }

    public Inventory setInventory(ResultSet rs) {
        Inventory inventory = new Inventory();
        try {
            inventory.setId(rs.getInt("id"));
            inventory.setDepartment(rs.getString("department"));
            inventory.setLastSold(rs.getDate("last_sold"));
            inventory.setShelfLife(rs.getString("shelf_life"));
            inventory.setDescription(rs.getString("description"));
            inventory.setPrice(rs.getDouble("price"));
            inventory.setUnit(rs.getString("unit"));
            inventory.setxFor(rs.getInt("x_for"));
            inventory.setCost(rs.getDouble("cost"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventory;
    }
}
