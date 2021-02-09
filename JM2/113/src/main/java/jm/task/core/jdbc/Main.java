package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserService us = new UserService();

        us.createUsersTable();

        us.saveUser("John", "Doe", (byte) 45);
        us.saveUser("Joe", "Smith", (byte) 58);
        us.saveUser("Harry", "Neville", (byte) 37);
        us.saveUser("Bob", "Red", (byte) 12);

        System.out.println("\nThe base contains data of the following users:");

        List<User> users = us.getAllUsers();
        for (User user : users) {
            System.out.println(user.toString());;
        }

        us.cleanUsersTable();
        us.dropUsersTable();
    }
}
