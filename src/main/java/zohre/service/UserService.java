package zohre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Service;
import zohre.dao.UserRepository;
import zohre.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> getAllUsers() {
        List<User> users = repository.findAll();
        if (users.size() > 0) {
            return users;
        } else {
            return new ArrayList<User>();
        }
    }

    public User getUserById(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    public User createOrUpdateUser(User user) {
        Optional<User> persistUser = repository.findById((long)user.getUserId());
        if (persistUser.isPresent()) {
            User newUser = new User(user.getUsername(), user.getPassword(), user.getEmail());
            newUser = repository.save(newUser);
            return newUser;
        }else {
            user = repository.save(user);
            return user;
        }
    }

    public void deleteUser(Long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            repository.deleteById(id);
        }
    }



//
//    public User register(String username, String email, String password) {
//        User user = new User(username, email, password);
//        repository.save(user);
//        return user;
//    }
//
//    public String login(String username, String password) {
//        List<User> users = (List<User>) repository.findAll();
//        String basicToken = "";
//        for (User user : users) {
//            if (user.getUsername().equals(username) && user.getPassword().equals(password))
//                basicToken = (user.getUsername() + user.getEmail() + user.getPassword()).getBytes().toString();
//        }
//        return basicToken;
//    }


}
