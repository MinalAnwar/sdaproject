package com.erp.dao;

import com.erp.Database.Database;
import com.erp.entity.Task;

import java.sql.*;

public class TaskDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    public ResultSet viewAllTasks() throws SQLException {
        Database dataAccess = new Database();
        Connection connection = dataAccess.getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT * FROM tasks");
    }

    public boolean deleteTask(int taskID) {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "{CALL DeleteTask(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setInt(1, taskID);
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

    public boolean updateTask(int oldID, Task obj) {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "CALL updateTask(?, ?, ?, ?, ?, ?)";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setInt(1,obj.getTaskId());
                callableStatement.setString(2, obj.getName());
                callableStatement.setString(3, obj.getDescription());
                callableStatement.setString(4, obj.getStatus());
                callableStatement.setString(5, obj.getDeadline());
                callableStatement.setInt(6, oldID);
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

    public boolean addTask(Task obj) {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "CALL InsertTask(?, ?, ?, ?, ?)";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setInt(1,obj.getTaskId());
                callableStatement.setString(2, obj.getName());
                callableStatement.setString(3, obj.getDescription());
                callableStatement.setString(4, obj.getStatus());
                callableStatement.setString(5, obj.getDeadline());
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

    public boolean assignTask(String date, String orderId, int employeeId) {
        boolean checkorderId = false;
        boolean checkemployeeId = false;
        String query = "SELECT OrderNumber FROM orders WHERE  OrderNumber= ?";
        try {
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                checkorderId = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query1 = "SELECT employeeId FROM employee WHERE  employeeId= ?";
        try {
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setInt(1, employeeId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                checkemployeeId = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(checkorderId && checkemployeeId)
        {
            String query2 = "INSERT INTO assignTask (taskDate, orderId, employeeId) VALUES (?,?,?)";
            try {
                connection = new Database().getConnection();
                preparedStatement = connection.prepareStatement(query2);
                preparedStatement.setString(1, date);
                preparedStatement.setString(2, orderId);
                preparedStatement.setInt(3, employeeId);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public ResultSet viewAssignedTasks() throws SQLException {
        Database dataAccess = new Database();
        Connection connection = dataAccess.getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT * FROM assignTask");
    }

    public boolean deleteAssignedTask(String orderId, int employeeId) {
        String query = "DELETE FROM assignTask WHERE employeeId = ? AND orderId = ?";

        try {
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);

            // Set values for parameters
            preparedStatement.setInt(1, employeeId);
            preparedStatement.setString(2, orderId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAssignTask(String date, String orderid, int employeeid, String oldOrderid, int oldEmployeeid) {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "CALL UpdateAssignTask(?, ?, ?, ?, ?)";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setString(1,date);
                callableStatement.setString(2, orderid);
                callableStatement.setInt(3, employeeid);
                callableStatement.setString(4, oldOrderid);
                callableStatement.setInt(5, oldEmployeeid);
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
