package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public String getUserByCar(String model, int series) {

        Query<User> userQuery = sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u WHERE car.model = :model AND car.series = :series");
        userQuery.setParameter("model", model);
        userQuery.setParameter("series", series);
        User user = userQuery.uniqueResult();

        return "Владелец машины " + model + " " + series + " - " + user.getFirstName() + " " + user.getLastName();
    }

}
