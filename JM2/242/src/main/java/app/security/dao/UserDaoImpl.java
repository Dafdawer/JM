package app.security.dao;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import app.security.    model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        em.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        em.remove(getUser(id));
    }

    @Override
    public User getUser(long id) {
        return em.find(User.class, id);
    }

    @Override
    public User findByUsername(String login){
        Query query = em.createQuery("select u from User u where u.username = :login");
        query.setParameter("login", login);
        return (User) query.getSingleResult();
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
}
