package com.bnw.taskcinema.dto;

import com.bnw.taskcinema.dto.common.IDto;

import java.time.LocalDateTime;
import java.util.Random;

public class Test1Dto implements IDto {
    private Integer id = new Random().nextInt();
    private String name = "testArch";
    private Boolean isTest = true;
    private LocalDateTime created = LocalDateTime.now();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getTest() {
        return isTest;
    }

    public void setTest(Boolean test) {
        isTest = test;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
