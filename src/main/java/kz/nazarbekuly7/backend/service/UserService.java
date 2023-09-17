package kz.nazarbekuly7.backend.service;

import kz.nazarbekuly7.backend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User addUser(User user);

    public List<User> getUser();

    public User getUserByid(long id);

    public User updateUser(long id , User user);

    public void deleteUser(long id);

}