package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Autowired
   private HibernateTransactionManager transactionManager;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public User getUserByCar(String carModel, int series) {
      User user = null;
      Long carID;

      String hql = "from Car where model = :paramCarModel and series = :paramSeries";
      Session session = transactionManager.getSessionFactory().getCurrentSession();
      Query query = session.createQuery(hql);
      query.setParameter("paramCarModel", carModel);
      query.setParameter("paramSeries", series);
      carID = ((Car) query.list().toArray()[0]).getId();

      String hql1 = "from User where car_id = :paramID";
      query = session.createQuery(hql1);
      query.setParameter("paramID", carID);
      user = ((User) query.list().toArray()[0]);

      return user;
   }
}
