package st52572.nnpia.project.service;

import st52572.nnpia.project.model.User;
import st52572.nnpia.project.model.UserDto;

import java.util.List;

public interface UserService {

    User save(UserDto user);

    List<User> findAll();

    void delete(int id);

    User findOne(String username);

    User findById(int id);

    UserDto update(UserDto userDto);
}
