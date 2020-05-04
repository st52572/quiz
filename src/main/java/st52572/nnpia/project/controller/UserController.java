package st52572.nnpia.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import st52572.nnpia.project.dao.UserDao;
import st52572.nnpia.project.model.User;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {


    @Autowired
    private UserDao userDao;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {

        if (!userDao.existsByLogin(user.getLogin())) {
            //user.setPassword(passwordEncoder.encode(user.getPassword()));
            System.out.println(user);
            userDao.save(user);
            return user;
        }
        return null;
    }

    @GetMapping(value = {"/delete/{id}"})
    public boolean deleteUser(@PathVariable int id) {
        userDao.delete(userDao.getOne(id));
        return true;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        Optional<User> optionalUser = userDao.findByLogin(user.getLogin());
        if (optionalUser.isPresent()) {
            User findedUser = optionalUser.get();
            if (findedUser.getPassword().equals(user.getPassword())) {
                System.out.println("logged");
                findedUser.setPassword(null);
                //session.setAttribute("login", user.getLogin());
                return findedUser;
            }
        }
        return new User();
    }
}
