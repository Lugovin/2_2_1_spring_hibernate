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

        userService.add(new User("KOlya", "lugovin", "user1@mail.ru", new Car("Honda", 2000)));
        userService.add(new User("Misha", "Ivanov", "user2@mail.ru", new Car("LC", 300)));
        userService.add(new User("Vasya", "Petrov", "user3@mail.ru", new Car("FIAT", 500)));
        userService.add(new User("Oleg", "Sidorov", "user4@mail.ru", new Car("VAZ", 2106)));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println(user.getCar());
            System.out.println();
        }


        System.out.println(userService.getUserByCar("FIAT", 500));


        context.close();
    }
}
