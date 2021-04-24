package ru.hoptar.springcourse.service;

import org.springframework.stereotype.Service;
import ru.hoptar.springcourse.entity.User;
import java.util.List;

@Service
public interface UserService {
    void saveUser(User user);
    void editUser(User user);
    void deleteUser(long id);
    User getUser(long id);
    List<User> getAll();
}
