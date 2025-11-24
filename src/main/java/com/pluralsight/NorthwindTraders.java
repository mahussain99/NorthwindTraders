package com.pluralsight;

import java.sql.*;

public class NorthwindTraders {
    public static void main(String[] args) throws SQLException {

        //  Step 1 connecting with database

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind",
                                                            "root",
                                                            "yearup");

        // Step 1: create statement and the statement is tied to the open connection

        Statement statement = connection.createStatement();

        // Step 3: define your query
        String query = "SELECT ProductName, UnitPrice FROM products" ;

        // Step 4: Execute your query
        ResultSet results = statement.executeQuery(query);

        // Step 5: process the results
        while (results.next()) {
            String ProductName = results.getString("ProductName");
            double UnitPrice = results.getDouble("UnitPrice");
            System.out.println(ProductName + ": " + UnitPrice);
        }
// 3. Very important part is Close the connection
        connection.close();
    }


}
