package com.erp.dao;

import com.erp.Database.Database;
import com.erp.entity.User;

import java.sql.*;

public class UserDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    public boolean checkCredentials(String username, String password) {
        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String credentialCheker = "{ CALL CheckCredentials(?, ?, ?) }"; // make a sql statement for the procedure call
            try (CallableStatement callableStatement = connection.prepareCall(credentialCheker)) {
                // setting the first parameter of query with username sent to this function
                callableStatement.setString(1, username);
                // setting the second parameter of query with password sent to this function
                callableStatement.setString(2, password);

                // setting the out parameter/result sent by stored procedure datatype
                callableStatement.registerOutParameter(3, Types.BOOLEAN);

                // execute the stored procedure
                callableStatement.execute();

                // retrieve the result from the stored procedure using index that was set for the out parameter
                return callableStatement.getBoolean(3);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getDesignation(String username, String password) {
        User user = new User();
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        try {
                connection = new Database().getConnection();
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    user.setUserId(resultSet.getInt("userId"));
                    user.setName(resultSet.getString("name"));
                    user.setUserName(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setDesignation(resultSet.getString("designation"));
                    user.setAddress(resultSet.getString("address"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPhoneNumber(resultSet.getString("phoneNumber"));
                    user.setAge(resultSet.getInt("age"));
                    user.setDateOfBirth(resultSet.getString("dateofbirth"));
                    user.setCnic(resultSet.getString("cnic"));
                    user.setGender(resultSet.getString("gender"));
                }
;        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public boolean updateProfile(int id,String name, String designation, String dateOfBirth, String email, String phoneNumber, String address, String cnic, int age) {

        Database dataAccess = new Database();
        try (Connection connection = dataAccess.getConnection()) {
            String storedProcedureCall = "CALL UpdateProfile(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Set the parameters for the stored procedure
                callableStatement.setInt(1,id);
                callableStatement.setString(2,name);
                callableStatement.setString(3, designation);
                callableStatement.setString(4, dateOfBirth);
                callableStatement.setString(5,email );
                callableStatement.setString(6,phoneNumber );
                callableStatement.setString(7, address);
                callableStatement.setString(8, cnic);
                callableStatement.setInt(9, age);
                callableStatement.executeUpdate();
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

    public boolean changePassword(int id, String oldPassword, String newPassword, String confirmedPassword) {
        String query = "SELECT password FROM user WHERE userId = ?";
        try {
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                String pass = resultSet.getString("password");
                if(oldPassword.equals(pass) && newPassword.equals(confirmedPassword))
                {
                    String query1 ="UPDATE user SET password = ? WHERE userId = ?";
                    try{
                        connection = new Database().getConnection();
                        preparedStatement = connection.prepareStatement(query1);
                        preparedStatement.setString(1, newPassword);
                        preparedStatement.setInt(2, id);
                        preparedStatement.executeUpdate();
                        return true;
                    } catch (SQLException e) {
                        return false;
                    }

                }
                else return false;
            }
            else return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean signUp(String username, String password, String confrimPassword) {
        System.out.println(username+"   " + password+"   "+confrimPassword);
        if(password.equals(confrimPassword))
        {
            String query = "INSERT INTO user (username, password) VALUES (?, ?)";
            try {
                connection = new Database().getConnection();
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2,password);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e) {
              return false;
            }

        }
        return false;
    }
}

