package zohre.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zohre.entity.User;
import zohre.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        return service.getUserById(id);
    }

    @PostMapping
    public User createOrUpdateUser(User user) {
        return service.createOrUpdateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        service.deleteUser(id);
    }
//    @RequestMapping("/register")
//    public User register(@RequestParam(value="username") String username,
//                         @RequestParam(value="email") String email,
//                         @RequestParam(value="password") String password){
//        return service.register(username, email, password);
//    }
//
//    @RequestMapping("/login")
//    public String login(@RequestParam(value="username") String username,
//                        @RequestParam(value="password") String password) {
//        return service.login(username, password);
//    }
//
//    @RequestMapping("/users")
//    public List<User> login() {
//        return service.getAllUsers();
//    }
}
