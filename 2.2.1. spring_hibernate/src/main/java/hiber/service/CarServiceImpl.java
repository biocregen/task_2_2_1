package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    public CarDao carDao;
    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Car> listCars() {
        return carDao.listCars();
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public User getUserByCar(String model, int series) {
        return carDao.getUserByCar(model,series);
    }
}
