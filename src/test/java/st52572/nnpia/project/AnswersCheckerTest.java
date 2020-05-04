package st52572.nnpia.project;

import org.junit.Test;

import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import st52572.nnpia.project.model.Question;
import st52572.nnpia.project.service.AnswersChecker;
import st52572.nnpia.project.service.IAnswersChecker;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AnswersCheckerTest {

    @Test
    public void getRightPercentageTest(){
        Question question1 = new Question();
        question1.setAnswer("a1");
        Question question2 = new Question();
        question2.setAnswer("a2");
        List<Question> list1 = new ArrayList<>();
        list1.add(question1);
        list1.add(question2);

        Question question3 = new Question();
        question3.setAnswer("a3");
        Question question4 = new Question();
        question4.setAnswer("a2");
        List<Question> list2 = new ArrayList<>();
        list2.add(question3);
        list2.add(question4);

        IAnswersChecker iAnswersChecker = new AnswersChecker();

        assertEquals(0.5,iAnswersChecker.getRightPercentage(list1,list2),10);

    }
}
