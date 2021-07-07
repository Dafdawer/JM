package app.security.service;

import app.security.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    void saveUser(User user);
    void editUser(User user);
    void deleteUser(long id);
    User getUser(long id);
    List<User> getAll();
    User findByUsername(String login);
}
