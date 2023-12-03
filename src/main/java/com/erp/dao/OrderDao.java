package com.erp.dao;

import com.erp.Database.Database;
import com.erp.entity.Order;

import java.sql.*;

public class OrderDao {

    public boolean updateOrder(String oldOrderNumber,Order obj)
    {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "CALL updateOrder(?, ?, ?, ?, ?, ?, ?)";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setString(1, obj.getOrderNumber());
                callableStatement.setInt(2, obj.getTotalAmount());
                callableStatement.setString(3, obj.getItems());
                callableStatement.setString(4, obj.getDate());
                callableStatement.setInt(5, obj.getTotalItems());
                callableStatement.setString(6, obj.getOrderStatus());
                callableStatement.setString(7, oldOrderNumber);
                callableStatement.execute();
                return true;
            } catch (SQLException e) {
                // Handle SQLException and show an error message
                e.printStackTrace();
                return false;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public boolean deleteOrder(String id) {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "{CALL DeleteOrder(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setString(1, id);
                callableStatement.execute();
                return true;
            } catch (SQLException e) {
                // Handle SQLException and show an error message
                e.printStackTrace();
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet viewAllOrders() throws SQLException {
        Database dataAccess = new Database();
        Connection connection = dataAccess.getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT * FROM orders");
    }

    public boolean addOrder(Order obj) {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "CALL insertOrder(?, ?, ?, ?, ?, ?)";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setString(1, obj.getOrderNumber());
                callableStatement.setInt(2, obj.getTotalAmount());
                callableStatement.setString(3, obj.getItems());
                callableStatement.setString(4, obj.getDate());
                callableStatement.setInt(5, obj.getTotalItems());
                callableStatement.setString(6, obj.getOrderStatus());
                callableStatement.execute();
                return true;
            } catch (SQLException e) {
                // Handle SQLException and show an error message
                e.printStackTrace();
                return false;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
