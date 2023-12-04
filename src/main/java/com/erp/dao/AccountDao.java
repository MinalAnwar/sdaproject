package com.erp.dao;

import com.erp.Database.Database;

import java.sql.*;

public class AccountDao {
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

    public String getDesignation(String username, String password) {
        String designation=null;
        Database dataAccess = new Database();
        String query = "SELECT designation FROM user WHERE username = ? AND password = ?";
        try {
                connection = new Database().getConnection();
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next())
                   designation= resultSet.getString("designation");
;        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return designation;
    }
}

