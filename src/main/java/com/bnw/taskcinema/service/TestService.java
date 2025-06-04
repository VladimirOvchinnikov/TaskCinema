package com.bnw.taskcinema.service;

import com.bnw.taskcinema.model.Test;
import com.bnw.taskcinema.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public List<Test> findAll() {
        return testRepository.findAll();
    }

    public Test findById(Integer id) {
        return testRepository.findById(id).orElse(null);
    }

    public Test save(Test entity) {
        return testRepository.save(entity);
    }

    public Test update(Test entity) {
        return testRepository.save(entity);
    }


    public void delete(Integer id) {
        testRepository.deleteById(id);
    }

}
