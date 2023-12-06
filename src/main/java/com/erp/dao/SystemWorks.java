package com.erp.dao;

import com.erp.Database.Database;
import com.erp.entity.User;
import com.erp.entity.Vendor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemWorks {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    public boolean checkCredentials(String email,String password)
    {
        UserDao user = new UserDao();
        return user.checkCredentials(email,password);
    }
    public User getDesignation(String email, String password)
    {
        UserDao obj = new UserDao();
        return obj.getDesignation(email,password);
    }
    public Map<String, List<Integer>> getStatistiks(){
        Map<String, List<Integer>> stats = new HashMap<>();
        List<Integer> Years = new ArrayList<>();
        List<Integer> Orders = new ArrayList<>();
        List<Integer> Profit = new ArrayList<>();
        String query = "select YEAR(dateOrder) as `Years`, COUNT(OrderNumber) as `Orders`, SUM(totalAmount) as `Profit`\n" +
                "from orders\n" +
                "group by `Years`\n" +
                "order by `Years`";
        try {
            Connection connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Years.add(resultSet.getInt("Years"));
                Orders.add(resultSet.getInt("Orders") * 100);
                Profit.add(resultSet.getInt("Profit"));
            }
            stats.put("Years", Years);
            stats.put("Orders", Orders);
            stats.put("Profit", Profit);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return stats;
    }

    public Map<String, Object> getDashboardInfo(){
        Map<String, Object> info = new HashMap<>(); // get all the info needed
        String query = "select \n" +
                "(select SUM(totalQuantity) from product) as `Total Products`,\n" +
                "(select SUM(totalAmount) from orders) as `Revenue`,\n" +
                "(select COUNT(OrderNumber) from orders where orderStatus = 'Completed') as `Completed Orders`,\n" +
                "(select COUNT(OrderNumber) from orders where orderStatus = 'Pending') as `Pending Orders`";
        try {
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                info.put("totalProducts", resultSet.getInt("Total Products"));
                info.put("Revenue", resultSet.getInt("Revenue"));
                info.put("completedOrders", resultSet.getInt("Completed Orders"));
                info.put("pendingOrders", resultSet.getInt("Pending Orders"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return info;
    }
    private static double calculateSlope(List<Integer> x, List<Integer> y) {
        int n = x.size();
        double sumXY = 0, sumX = 0, sumY = 0, sumXSquare = 0;

        for (int i = 0; i < n; i++) {
            sumXY += x.get(i) * y.get(i);
            sumX += x.get(i);
            sumY += y.get(i);
            sumXSquare += x.get(i) * x.get(i);
        }

        return (n * sumXY - sumX * sumY) / (n * sumXSquare - sumX * sumX);
    }
    private static double calculateIntercept(List<Integer> x, List<Integer> y) {
        int n = x.size();
        double slope = calculateSlope(x, y);
        double sumX = 0, sumY = 0;

        for (int i = 0; i < n; i++) {
            sumX += x.get(i);
            sumY += y.get(i);
        }

        return (sumY - slope * sumX) / n;
    }
    private static double predictY(double x, double slope, double intercept) {
        return slope * x + intercept;
    }

    public static int LinearRegression(List<Integer> x, List<Integer> y, double findingX)  {
        //double[] x = {2017, 2018, 2019, 2020, 2021, 2022, 2023};
        //double[] y = {8, 8, 8, 8, 6, 6, 3};

        // Calculate linear regression
        double slope = calculateSlope(x, y);
        double intercept = calculateIntercept(x, y);

        // Extrapolate for x = 2024
        double xToPredict = findingX;
        double predictedY = predictY(xToPredict, slope, intercept);

        // Display results
        System.out.println("Linear Regression Equation: y = " + slope + "x + " + intercept);
        System.out.println("Predicted value for x = " + xToPredict + ": " + predictedY);

        return (int) predictedY;
    }

    public List<Vendor> getAllVendors()
    {
        VendorDao obj = new VendorDao();
        return obj.getAllVendors();
    }

}
