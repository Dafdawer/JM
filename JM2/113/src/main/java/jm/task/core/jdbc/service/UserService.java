package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDao {

    @Override
    public void createUsersTable() {
        Connection connection = Util.getConnection();
        String sql = "CREATE TABLE `test`.`users` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `lastName` VARCHAR(45) NOT NULL,\n" +
                "  `age` INT(2) NULL,\n" +
                "  PRIMARY KEY (`id`));";

        try {
            System.out.println("Attempting to create a new table...");
            connection.createStatement().executeUpdate(sql);
            System.out.println("The database has been successfully created\n");
        } catch (SQLSyntaxErrorException e){
            System.out.println("Creation failure: the table already exists");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        Connection connection = Util.getConnection();
        String sql = "drop table users";

        try {
            System.out.println("\nAttempting to drop the table...");
            connection.createStatement().executeUpdate(sql);
            System.out.println("The table has been dropped");
        } catch (SQLSyntaxErrorException e){
            System.out.println("Failure: the table doesn't exist");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Connection connection = Util.getConnection();
        User user = new User(name, lastName, age);

        PreparedStatement preparedStatement = null;
        String sql = "insert into users (name, lastName, age) values (?, ?, ?);";

        try {               // todo: change id autoincrement to firsts empty cell id
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAge());

            preparedStatement.executeUpdate();
            System.out.printf("User с именем %s %s успешно добавлен в базу\n", user.getName(), user.getLastName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                    e.printStackTrace();
            }
        }
    }

    @Override
    public void removeUserById(long id) {

        Connection connection = Util.getConnection();
        String sql = String.format("delete from users where id = %d", id);

        try {
            connection.createStatement().executeUpdate(sql);
            System.out.printf("The user with id %d has been deleted from the database\n", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        Connection connection = Util.getConnection();
        String sql = "select id, name, lastName, age from users";

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge((byte) resultSet.getInt("age"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Connection connection = Util.getConnection();
        String sql = "delete from users";

        try {
            System.out.println("\nAttempting to clear the table...");
            connection.createStatement().executeUpdate(sql);
            System.out.println("The table has been cleared");
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

//public interface UserService {
//    void createUsersTable();
//
//    void dropUsersTable();
//
//    void saveUser(String name, String lastName, byte age);
//
//    void removeUserById(long id);
//
//    List<User> getAllUsers();
//
//    void cleanUsersTable();
//}
