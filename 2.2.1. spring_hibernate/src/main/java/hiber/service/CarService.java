package hiber.service;



import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarService {
    void add(Car user);

    List<Car> listCars();
    public User getUserByCar(String model, int series);
}
