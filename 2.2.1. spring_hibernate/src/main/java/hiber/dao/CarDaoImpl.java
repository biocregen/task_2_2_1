package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> listCars() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }
    @Override
    public User getUserByCar(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("FROM User AS u WHERE u.empCar.model=: model AND u.empCar.series=: series", User.class);
        User user = query.setParameter("model",model).setParameter("series",series).getSingleResult();
        return user;
    }
}
