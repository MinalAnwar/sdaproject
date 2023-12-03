package com.erp.dao;

import com.erp.Database.Database;
import com.erp.entity.Vendor;

import java.sql.*;

public class VendorDao {
    public boolean addVendor(Vendor obj) {
        Database dataAccess = new Database();
        try(Connection connection = dataAccess.getConnection())
        {
            String storedProcedureCall = "{CALL Insertvendor(?, ?, ?, ?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setInt(1,obj.getVendorId());
                callableStatement.setString(2, obj.getName());
                callableStatement.setInt(3, obj.getRating());
                callableStatement.setString(4, obj.getPhoneNumber());
                callableStatement.setString(5, obj.getEmail());
                callableStatement.execute();
                return true;
            }catch (SQLException e) {
                // Handle SQLException and show an error message
                e.printStackTrace();
                return false;
            }

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateVendor(int oldID,Vendor obj)
    {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "CALL updateVendor(?, ?, ?, ?, ?, ?)";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setInt(1, obj.getVendorId());
                callableStatement.setString(2, obj.getName());
                callableStatement.setInt(3, obj.getRating());
                callableStatement.setString(4, obj.getPhoneNumber());
                callableStatement.setString(5, obj.getEmail());
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
    public ResultSet viewAllVendors() throws SQLException {
        Database dataAccess = new Database();
        Connection connection = dataAccess.getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT * FROM `vendor`");
    }
}
