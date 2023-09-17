package kz.nazarbekuly7.backend.service;

import kz.nazarbekuly7.backend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User createUser(User user);

    public List<User> getUsers();

    public User getUserById(long id);

    public void  deleteUser(long id);

    public User updateuser(User user, long id);
}
