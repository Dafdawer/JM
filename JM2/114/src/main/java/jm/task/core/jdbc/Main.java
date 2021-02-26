package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

            userService.saveUser("A", "W", (byte) 20);
            userService.saveUser("B", "X", (byte) 25);
            userService.saveUser("C", "Y", (byte) 35);
            userService.saveUser("D", "Z", (byte) 70);

        userService.removeUserById(2);

//        userService.cleanUsersTable();

        List <User> users = userService.getAllUsers();
        System.out.println("Printing out user list:");

        for (User user : users) {
            System.out.println(user.toString());
        }


//        userService.dropUsersTable();
    }

}
