package app.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import app.security.dao.UserDao;
import app.security.model.Role;
import app.security.model.User;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void editUser(User user) {
        String encrypted = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encrypted);
        userDao.editUser(user);
    }

    @Override
    public void saveUser(User user) {
        String encrypted = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encrypted);
        user.setRoles(Collections.singleton(new Role(2L, "USER"))); //"ROLE_USER"?
        userDao.saveUser(user);
    }

    @Override
    public User findByUsername(String login) {
        return userDao.findByUsername(login);
    }

    @Override
    public void deleteUser(long id ) {
        userDao.deleteUser(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException(String.format("Пользователь %s в базе отсутствует", username));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}
