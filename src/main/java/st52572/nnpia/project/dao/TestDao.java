package st52572.nnpia.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import st52572.nnpia.project.model.Test;

public interface TestDao extends JpaRepository<Test, Integer> {
}
