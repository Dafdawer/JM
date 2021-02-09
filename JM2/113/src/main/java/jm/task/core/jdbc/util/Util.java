package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String pass = "123";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(url, user, pass);
//            System.out.println("Connection established");
        } catch (SQLException e) {
            System.out.println("driver hasn't been found or connection failed");
            e.printStackTrace();
        }
        return connection;
    }
}

//public class Util {
//
//    private static final String driver = "com.mysql.cj.jdbc.Driver";
//    private static final String url = "jdbc:mysql://localhost:3306/test";
//    private static final String username = "root";
//    private static final String pass = "123";
//
//    public static void getConnection() {
//        Connection connection;
//
//        try {
//            Class.forName(driver); // the same with the registerDriver(new Driver())
//            DriverManager.registerDriver(new Driver());
//            System.out.println("The driver has been registered");
//
//            connection = DriverManager.getConnection(url, username, pass);
//
//            if(!connection.isClosed()) {
//                System.out.println("Connection established");
//            }
//
//            connection.close();
//
//            if(connection.isClosed()) {
//                System.out.println("Connection closed");
//            }
//
//
//        } catch (ClassNotFoundException | SQLException e) {
//            System.err.println("Driver wasn't loaded or connection wasn't secured");
//        }
//    }
//}
