package st52572.nnpia.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import st52572.nnpia.project.dao.UserDao;
import st52572.nnpia.project.model.ApiResponse;
import st52572.nnpia.project.model.User;
import st52572.nnpia.project.model.UserDto;
import st52572.nnpia.project.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    /*@GetMapping("/users")
    public List<User> getUsers() {
        return userDao.findAll();
    }*/

    @PostMapping("/addUser")
    public ApiResponse<User> saveUser(@RequestBody UserDto user) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.", userService.save(user));
    }

    /*@GetMapping(value = {"/delete/{id}"})
    public boolean deleteUser(@PathVariable int id) {
        userDao.delete(userDao.getOne(id));
        return true;
    }*/

    @PostMapping("/getUser")
    public User getUser(@RequestBody User user) {
        User optionalUser = userDao.findByUsername(user.getUsername());
        if (optionalUser != null) {
            optionalUser.setPassword(null);
            return optionalUser;
        }
        return new User();
    }
}
