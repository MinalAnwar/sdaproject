package com.erp.dao;

import com.erp.Database.Database;
import com.erp.entity.Product;
import com.erp.entity.RawMaterial;

import java.sql.*;

public class InventoryDao {
    public boolean addRawMaterialDAO(RawMaterial obj) {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "CALL insertMaterial( ?, ?, ?)";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
//                callableStatement.setInt(1, obj.getProductId());
                callableStatement.setString(1, obj.getName());
                callableStatement.setDouble(2, obj.getPrice());
                callableStatement.setInt(3, obj.getTotalQuantity());
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
    public Boolean addProductDAO(Product obj)
    {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "CALL insertProduct( ?, ?, ?)";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setString(1, obj.getName());
                callableStatement.setDouble(2, obj.getPrice());
                callableStatement.setInt(3, obj.getTotalQuantity());
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

    public boolean deleteRowMaterial(int id) {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "{CALL DeleteMaterial(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setInt(1, id);
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


    public boolean deleteProductDao(int id) {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "{CALL DeleteProduct(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setInt(1, id);
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

    public ResultSet viewAllMaterial() throws SQLException {
        Database dataAccess = new Database();
        Connection connection = dataAccess.getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT * FROM rawmaterial");
    }
    public ResultSet viewAllProduct() throws SQLException {
        Database dataAccess = new Database();
        Connection connection = dataAccess.getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT * FROM product");
    }


    public boolean updateRawMaterial(int oldID,RawMaterial obj) {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "CALL updateMaterial(?, ?, ?, ?,?)";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setInt(1, obj.getProductId());
                callableStatement.setString(2, obj.getName());
                callableStatement.setDouble(3, obj.getPrice());
                callableStatement.setInt(4, obj.getTotalQuantity());
                callableStatement.setInt(5, oldID);
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


    public boolean updateProduct(int oldID,Product obj) {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "CALL updateProduct(?, ?, ?, ?,?)";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setInt(1, obj.getProductId());
                callableStatement.setString(2, obj.getName());
                callableStatement.setDouble(3, obj.getPrice());
                callableStatement.setInt(4, obj.getTotalQuantity());
                callableStatement.setInt(5, oldID);
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
