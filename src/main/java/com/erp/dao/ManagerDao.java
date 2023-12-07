package com.erp.dao;

import com.erp.Database.Database;
import com.erp.entity.Quotations;

import java.sql.*;

public class ManagerDao {


    public boolean addQuotations(String email, Quotations obj) {
        Database dataAccess = new Database();
        try(Connection connection = dataAccess.getConnection())
        {
            String storedProcedureCall = "{call InsertQuotation(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                callableStatement.setString(1, email);
                callableStatement.setInt(2, obj.getMaterial1());
                callableStatement.setInt(3, obj.getQuantity1());
                callableStatement.setInt(4, obj.getPrice1());
                callableStatement.setInt(5, obj.getMaterial2());
                callableStatement.setInt(6, obj.getQuantity2());
                callableStatement.setInt(7, obj.getPrice2());
                callableStatement.setInt(8, obj.getMaterial3());
                callableStatement.setInt(9, obj.getQuantity3());
                callableStatement.setInt(10, obj.getPrice3());
                callableStatement.setDate(11, java.sql.Date.valueOf(java.time.LocalDate.now()));

                callableStatement.execute();

                return true;
            }catch (SQLException e) {
                System.out.println(e);
                // Handle SQLException and show an error message
                e.printStackTrace();
                return false;
            }

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet viewRatigns() throws SQLException {

        Database dataAccess = new Database();
        Connection connection = dataAccess.getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT * FROM ratings");
    }



    public boolean deleteRating(int empid, int managerId) {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "{CALL DeleteRating(?,?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setInt(1, empid);
                callableStatement.setInt(2, managerId);

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
}
