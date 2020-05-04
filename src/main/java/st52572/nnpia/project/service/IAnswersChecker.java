package st52572.nnpia.project.service;

import st52572.nnpia.project.model.Question;

import java.util.List;

public interface IAnswersChecker {

    public double getRightPercentage(List<Question> questions, List<Question> answers);
}
