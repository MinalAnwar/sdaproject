package com.erp.dao;

import com.erp.Database.Database;
import com.erp.entity.Quotations;
import com.erp.entity.RawMaterial;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuotationDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public void addQuantities(int p1, int p2, int p3, int q1, int q2, int q3){
        String query = "update rawmaterial \n" +
                "set totalQuantity = totalQuantity + ?\n" +
                "where RawMaterialid = ?;";
        try {
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, q1);
            preparedStatement.setInt(2, p1);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, q2);
            preparedStatement.setInt(2, p2);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, q3);
            preparedStatement.setInt(2, p3);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteByID(Integer id){
        String query = "Delete from quotation where `quotationIsd` = ?";
        try {
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Quotations> getAllQuotations(){
        List<Quotations> quotations = new ArrayList<>();
        String query = "SELECT quotationIsd, orderDate, vendor.name,pOne,\n" +
                "pTwo,\n" +
                "pThree,\n" +
                " (select name from rawmaterial where RawMaterialid = pOne) as `oneName`,\n" +
                " pOneQuantity, pOnePrice,\n" +
                " (select name from rawmaterial where RawMaterialid = pTwo) as `twoName`,\n" +
                " pTwoQuantity, pTwoPrice,\n" +
                " (select name from rawmaterial where RawMaterialid = pThree) as `threeName`,\n" +
                " pThreeQuantity, pThreePrice, (pOnePrice*pOneQuantity + pTwoPrice*pTwoQuantity + pThreeQuantity*pThreePrice) as `Total`\n" +
                "FROM sdapro.quotation inner join vendor ON quotation.vendorId = email \n" +
                "where isApproved = 0;";
        try {
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                quotations.add(new Quotations(
                        resultSet.getInt("quotationIsd"),
                        resultSet.getString("name"),
                        resultSet.getInt("pOne"),
                        resultSet.getString("oneName"),
                        resultSet.getInt("pOneQuantity"),
                        resultSet.getInt("pOnePrice"),
                        resultSet.getInt("pTwo"),
                        resultSet.getString("twoName"),
                        resultSet.getInt("pTwoQuantity"),
                        resultSet.getInt("pTwoPrice"),
                        resultSet.getInt("pThree"),
                        resultSet.getString("threeName"),
                        resultSet.getInt("pThreeQuantity"),
                        resultSet.getInt("pThreePrice"),
                        0,
                        resultSet.getInt("Total"),
                        resultSet.getDate("orderDate")
                ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return quotations;
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

    public void placeMaterialOrder(int id, int totalQuantity, int totalPrice) {
        String query = "insert into materialOrders (QID, totalQuantity, totalPrice, orderDate)" +
                "values" +
                "(?, ?, ?, ?)";
        try {
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, totalQuantity);
            preparedStatement.setInt(3, totalPrice);
            preparedStatement.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
            preparedStatement.executeUpdate();
            updateStatus(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void updateStatus(int id){
        String query = "update quotation set isApproved = 1 where `quotationIsd` = ?";
        try {
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
