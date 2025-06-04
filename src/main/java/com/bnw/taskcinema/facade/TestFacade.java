package com.bnw.taskcinema.facade;

import com.bnw.taskcinema.model.Test;
import com.bnw.taskcinema.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestFacade {

    @Autowired
    private TestService testService;


    public List<Test> findAll() {
        return testService.findAll();
    }

    public Test findById(Integer id) {
        return testService.findById(id);
    }

    public Test save(Test entity) {
        return testService.save(entity);
    }

    public Test update(Test entity) {
        return testService.save(entity);
    }


    public void delete(Integer id) {
        testService.delete(id);
    }

}
