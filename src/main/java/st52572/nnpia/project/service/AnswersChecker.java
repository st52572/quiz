package st52572.nnpia.project.service;

import org.springframework.stereotype.Component;
import st52572.nnpia.project.model.Question;

import java.util.List;

@Component
public class AnswersChecker implements IAnswersChecker {

    @Override
    public double getRightPercentage(List<Question> rightAnswers, List<Question> answers) {
        double rights = 0;
        double falses = 0;
        for (int i = 0; i < rightAnswers.size(); i++) {
            System.out.println(rightAnswers.get(i).getAnswer());
            System.out.println(answers.get(i).getAnswer());
            if (rightAnswers.get(i).getAnswer().equals(answers.get(i).getAnswer())) {
                rights++;
                System.out.println("right");
            } else {
                falses++;
                System.out.println("false");
            }
        }
        return rights/(rights+falses);
    }
}
