package st52572.nnpia.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import st52572.nnpia.project.model.User;


public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String login);

    boolean existsByUsername(String loging);
}
