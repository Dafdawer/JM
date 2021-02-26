package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import jm.task.core.jdbc.model.User;

public class Util {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String pass = "123";

    private static SessionFactory sessionFactory;

    public static Connection getJDBCConnection() {
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

    public static SessionFactory getSessionFactory() {

        if(sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/test?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "123");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");  // changed from "create-drop"

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                if (sessionFactory != null) {
                    System.out.println("Session is open: " + sessionFactory.isOpen());
                }

            } catch (Exception e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void sessionClose() {
        getSessionFactory().close();
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
