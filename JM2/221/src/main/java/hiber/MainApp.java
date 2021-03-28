package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Kek", "Mek", "jojo@1");
      User user2 = new User("John", "Doe", "new@2");
      User user3 = new User("Pete", "Walker", "gy@w");
      User user4 = new User("Harry", "Smith", "vf@kjh");

      user1.setCar(new Car("Toyota", 222));
      user2.setCar(new Car("VW", 87));
      user3.setCar(new Car("Honda", 18));
      user4.setCar(new Car("Honda", 520));
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      try {
         User us = userService.getUserByCar("Honda", 18);
         System.out.println("The requested car is owned by user:");
         System.out.println(("Id: " + us.getId() + ", "
                 + "first Name: = " + us.getFirstName() + ", "
                 + "last name: " + us.getLastName() + ", "
                 + "email = " + us.getEmail()));
      } catch (Exception e) {
         System.out.println("query failed");
         System.out.println(e.getCause());
      }

      context.close();
   }
}
