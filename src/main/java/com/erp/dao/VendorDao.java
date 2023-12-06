package com.erp.dao;

import com.erp.Database.Database;
import com.erp.entity.Vendor;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class VendorDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public List<Vendor> getAllVendors(){
        List<Vendor> vendors = new ArrayList<>();
        String query = "select * from vendor";
        try {
            Connection connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                vendors.add(new Vendor(resultSet.getInt("vendorId"),
                                       resultSet.getString("name"),
                                       resultSet.getInt("rating"),
                                       resultSet.getString("phoneNumber"),
                                       resultSet.getString("email"))
                );
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return vendors;
    }
    public boolean addVendor(Vendor obj) {
        Database dataAccess = new Database();
        try(Connection connection = dataAccess.getConnection())
        {
            String storedProcedureCall = "{CALL Insertvendor( ?, ?, ?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setString(1, obj.getName());
                callableStatement.setInt(2, obj.getRating());
                callableStatement.setString(3, obj.getPhoneNumber());
                callableStatement.setString(4, obj.getEmail());
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
