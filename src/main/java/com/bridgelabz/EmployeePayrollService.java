package com.bridgelabz;

import java.sql.*;
import java.util.Enumeration;

public class EmployeePayrollService {

    private  Statement statement;
    private  Connection connection;
    public void setConnection(){
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

    }
    public Connection getConnection(){


        return connection;
    }
    private static void listDrivers(){
        Enumeration<Driver> driverlist = DriverManager.getDrivers();
        while (driverlist.hasMoreElements()){
            Driver driver = driverlist.nextElement();
            System.out.println(" "+driver.getClass().getName());

        }
    }
}
