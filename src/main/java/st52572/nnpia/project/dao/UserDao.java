package st52572.nnpia.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import st52572.nnpia.project.model.User;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {

    public Optional<User> findByLogin(String login);

    public boolean existsByLogin(String loging);
}
