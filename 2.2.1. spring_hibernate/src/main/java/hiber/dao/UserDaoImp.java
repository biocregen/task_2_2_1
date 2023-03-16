package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from User")
                .getResultList();
    }

    @Override
    public User getUserByCar(String model, int series) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM User AS u WHERE u.empCar.model=: model AND u.empCar.series=: series", User.class)
                .setParameter("model", model)
                .setParameter("series", series)
                .getSingleResult();
    }

}
