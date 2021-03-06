package st52572.nnpia.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import st52572.nnpia.project.dao.QuestionDao;
import st52572.nnpia.project.model.Question;
import st52572.nnpia.project.service.IAnswersChecker;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/questions")
public class QuestionController {


    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private IAnswersChecker iAnswersChecker;


    @GetMapping
    public List<Question> getQuestions() {
        List<Question> questions = questionDao.findAll();
        questions.stream().forEach(question -> question.setAnswer(""));
        return questions;
    }

    @GetMapping("/{id}")
    public List<Question> getQuestions(@PathVariable int id) {
        List<Question> questions = questionDao.findAllByTest_Id(id);
        questions.stream().forEach(question -> question.setAnswer(""));
        return questions;
    }

    /*@PostMapping("/save")
    public Question addQuestion(@RequestBody Question question) {
        questionDao.save(question);
        return question;
    }*/

    @PostMapping("/checkTest")
    public double checkTest(@RequestBody List<Question> answers) {
        System.out.println(answers);
        List<Question> rightAnswers = questionDao.findByTestId(answers.get(0).getTest().getId());
        return iAnswersChecker.getRightPercentage(rightAnswers,answers);
    }

    @PostMapping("/save")
    public List<Question> addQuestions(@RequestBody List<Question> questions) {
        questionDao.saveAll(questions);
        return questions;
    }

}
