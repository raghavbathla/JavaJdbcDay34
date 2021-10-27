package com.bridgelabz;

import java.sql.*;
import java.util.Enumeration;

public class EmployeePayrollDbService {
    private static EmployeePayrollDbService employeePayrollDbService;
    private Statement statement;
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
    private  void listDrivers(){
        Enumeration<Driver> driverlist = DriverManager.getDrivers();
        while (driverlist.hasMoreElements()){
            Driver driver = driverlist.nextElement();
            System.out.println(" "+driver.getClass().getName());

        }
    }
    public void showData(){
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("select * from employee_payroll");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        while (true)
        {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }

            int x = 0;
            try {
                x = rs.getInt("id");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String y = null;
            try {
                y = rs.getString("name");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            int z = 0;
            try {
                z = rs.getInt("salary");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(x + "   " + y + " " + z);
        }
    }


    public static EmployeePayrollDbService getInstance(){
        if(employeePayrollDbService==null)
        {
            employeePayrollDbService = new EmployeePayrollDbService();
        }
        return employeePayrollDbService;
    }
}
