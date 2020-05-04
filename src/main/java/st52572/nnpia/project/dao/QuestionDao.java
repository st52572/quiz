package st52572.nnpia.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import st52572.nnpia.project.model.Question;
import st52572.nnpia.project.model.User;

import java.util.List;
import java.util.Optional;

public interface QuestionDao extends JpaRepository<Question, Integer> {

    public List<Question> findByTestId(int testId);

    public List<Question> findAllByTest_Id(int id);
}
