package com.erp.dao;

import com.erp.Database.Database;
import com.erp.entity.Employee;

import java.sql.*;


public class EmployeeDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
        public boolean addEmployeeDAO(Employee obj)
        {
            Database dataAccess = new Database();
            try(Connection connection = dataAccess.getConnection())
            {
                String storedProcedureCall = "{CALL InsertEmployee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                    // Set the parameters for the stored procedure
                    callableStatement.setString(1, obj.getName());
                    callableStatement.setString(2, obj.getDesignation());
                    callableStatement.setString(3, obj.getAddress());
                    callableStatement.setString(4, obj.getEmail());
                    callableStatement.setString(5, obj.getPhoneNumber());
                    callableStatement.setInt(6, obj.getAge());
                    callableStatement.setString(7, obj.getDateOfBirth());
                    callableStatement.setString(8, obj.getCnic());
                    callableStatement.setString(9, obj.getGender());
                    callableStatement.setString(10, obj.getDateOfJoining());
                    callableStatement.setInt(11, obj.getSalary());

                    // Execute the stored procedure
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
        public boolean deleteEmployee(int id) {
            Database dataAccess = new Database();
            try (Connection connection = dataAccess.getConnection()) {
                String storedProcedureCall = "{CALL DeleteEmployee(?)}";
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
        public ResultSet viewAllEmployees() throws SQLException {
            Database dataAccess = new Database();
            Connection connection = dataAccess.getConnection();
            Statement statement = connection.createStatement();
            return statement.executeQuery("SELECT * FROM employee");
        }

    public void addRating(int managerID, int empID, int rating){

        String query = "insert into ratings (managerID, empID, ratingDate, rating)\n" +
                "values\n" +
                "(?,?,?,?);";
        try {
            Connection connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, managerID);
            preparedStatement.setInt(2, empID);
            preparedStatement.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
            preparedStatement.setInt(4, rating);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
