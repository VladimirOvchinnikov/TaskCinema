package com.bnw.taskcinema.service;

import com.bnw.taskcinema.model.Echo;
import com.bnw.taskcinema.repository.EchoRepository;
import com.bnw.taskcinema.service.common.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EchoService implements IService<Echo> {

    @Autowired
    private EchoRepository testRepository;

    @Override
    public List<Echo> findAll() {
        return testRepository.findAll();
    }

    @Override
    public Echo findById(Integer id) {
        return testRepository.findById(id).orElse(null);
    }

    @Override
    public Echo save(Echo entity) {
        return testRepository.save(entity);
    }

    @Override
    public Echo update(Echo entity) {
        return save(entity);
    }

    @Override
    public void delete(Integer id) {
        testRepository.deleteById(id);
    }

}
