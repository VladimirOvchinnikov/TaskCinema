package com.bnw.taskcinema.repository;

import com.bnw.taskcinema.model.Echo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EchoRepository extends JpaRepository<Echo, Integer> {
}
