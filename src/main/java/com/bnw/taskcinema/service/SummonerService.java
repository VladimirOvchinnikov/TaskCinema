package com.bnw.taskcinema.service;

import com.bnw.taskcinema.model.Summoner;
import com.bnw.taskcinema.repository.SummonerRepository;
import com.bnw.taskcinema.service.common.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummonerService implements IService<Summoner> {

    @Autowired
    private SummonerRepository repository;

    @Override
    public List<Summoner> findAll() {
        return repository.findAll();
    }

    public Summoner save(Summoner entity) {
        return repository.save(entity);
    }
}
