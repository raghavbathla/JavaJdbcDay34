package com.bridgelabz;

import java.sql.*;
import java.util.Enumeration;

public class ConnectionMain {
    private static Statement statement = null;
   private static Connection connection;
    public static void main(String[] args) throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/PayrollService?useSSl=false";
        String userName = "root";
        String password = "Password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        listDrivers();
        try {
            System.out.println("Connecting to database" + jdbcUrl);
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            System.out.println("Connection is successfull"+connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Statement stmt = connection.createStatement();
        //Step-4
        ResultSet rs = stmt.executeQuery("select * from employee_payroll");
        //Fetching data from ResultSet and display

        while (rs.next())
        {
            //to fetch value from a column having number type of value
            int x = rs.getInt("id");
            //to fetch value from a column having varchar/text type of value
            String y = rs.getString("name");
            //to fetch value from a column having number type of value
            int z = rs.getInt("salary");
            System.out.println(x + "   " + y + " " + z);
        }
        //Step-5
        connection.close();
    }
    private static void listDrivers(){
        Enumeration<Driver> driverlist = DriverManager.getDrivers();
        while (driverlist.hasMoreElements()){
            Driver driver = driverlist.nextElement();
            System.out.println(" "+driver.getClass().getName());

        }
    }

}
