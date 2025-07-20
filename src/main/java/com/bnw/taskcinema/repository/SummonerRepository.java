package com.bnw.taskcinema.repository;

import com.bnw.taskcinema.model.Summoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummonerRepository extends JpaRepository<Summoner, Integer> {
}
