package com.bridgelabz;

import java.sql.*;
import java.util.Enumeration;

public class ConnectionMain {

    public static void main(String[] args) throws SQLException {
       EmployeePayrollService service = new EmployeePayrollService();
       service.setConnection();
        service.showData();
        service.getConnection().close();

//        String sql = "UPDATE employee_payroll SET salary = '30000000' WHERE id = 2";
//        stmt.executeUpdate(sql);
//        ResultSet ms = stmt.executeQuery("select * from employee_payroll");
//        while (ms.next())
//        {
//            //to fetch value from a column having number type of value
//            int x = rs.getInt("id");
//            //to fetch value from a column having varchar/text type of value
//            String y = rs.getString("name");
//            //to fetch value from a column having number type of value
//            int z = rs.getInt("salary");
//            System.out.println(x + "   " + y + " " + z);
//        }

    }


}
