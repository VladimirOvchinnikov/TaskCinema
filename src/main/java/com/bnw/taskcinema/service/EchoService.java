package com.bnw.taskcinema.service;

import com.bnw.taskcinema.model.Echo;
import com.bnw.taskcinema.repository.EchoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EchoService {

    @Autowired
    private EchoRepository testRepository;

    public List<Echo> findAll() {
        return testRepository.findAll();
    }

    public Echo findById(Integer id) {
        return testRepository.findById(id).orElse(null);
    }

    public Echo save(Echo entity) {
        return testRepository.save(entity);
    }

    public Echo update(Echo entity) {
        return testRepository.save(entity);
    }


    public void delete(Integer id) {
        testRepository.deleteById(id);
    }

}
