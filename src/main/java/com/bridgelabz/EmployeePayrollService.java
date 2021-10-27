package com.bridgelabz;

import java.sql.*;
import java.util.Enumeration;

public class EmployeePayrollService {


    private  EmployeePayrollDbService employeePayrollDbService;


    public EmployeePayrollService() {
        employeePayrollDbService = EmployeePayrollDbService.getInstance();
    }

   public void setConnection(){
        employeePayrollDbService.setConnection();
   }
   public Connection getConnection(){
     Connection connection = employeePayrollDbService.getConnection();
     return connection;
    }
    public void showData(){
        employeePayrollDbService.showData();
    }
}
