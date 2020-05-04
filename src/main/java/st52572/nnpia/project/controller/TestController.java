package st52572.nnpia.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import st52572.nnpia.project.dao.TestDao;
import st52572.nnpia.project.model.Test;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/tests")
public class TestController {


    @Autowired
    private TestDao testDao;

    @PostMapping
    public List<Test> getTests() {
        return testDao.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Test getTest(@PathVariable int id) {
        Test test = testDao.getOne(id);
        return test;
    }

    @PostMapping("/add")
    public Integer addTest(@RequestBody Test test) {
        System.out.println(test);
        testDao.save(test);
        return test.getId();
    }


}