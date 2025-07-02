package jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private DBConnection(){}

    private static final String URL="jdbc:mysql://localhost:3306/StudentManagementSystem";
    private static final String USER="root";
    private static final String PASSWORD="root@user#123";
static {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
//        System.out.println("Driver loaded");

    }catch (ClassNotFoundException e) {

        System.err.println("MySQL JDBC Driver not found.");

    }

}

    private static Connection  connection;

    public static Connection  getConnection() throws SQLException{


        if(connection==null || connection.isClosed()){

            connection= DriverManager.getConnection(URL,USER,PASSWORD);
        }

        return connection;
    }

}
