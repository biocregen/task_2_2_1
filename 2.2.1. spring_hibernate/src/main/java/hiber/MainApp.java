package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        User user1 = new User("Aleksei","Ivanov","lehaivanov@mail.ru");
        User user2 = new User("Misha","Zamorin","zamorin.m@google.com");
        User user3 = new User("Nikita","Zakurdaev","zakurdaevnikit@yandex.ru");
        User user4 = new User("Vladimir","Kuznetcov","kuznevova@yahoox.com");

        Car car1 = new Car(1,"Ferrari");
        Car car2 = new Car(2,"BMW");
        Car car3 = new Car(3,"Audi");
        Car car4 = new Car(4,"Mercedes");

        user1.setEmpCar(car1);
        user2.setEmpCar(car2);
        user3.setEmpCar(car3);
        user4.setEmpCar(car4);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        List<Car> cars = carService.listCars();
        for (Car car : cars) {
            System.out.println("Id = "+car.getId());
            System.out.println("Model = "+car.getModel());
            System.out.println("Series = "+car.getSeries());
            System.out.println();
        }

        System.out.println(carService.getUserByCar("BMW",2));



        context.close();
    }
}
