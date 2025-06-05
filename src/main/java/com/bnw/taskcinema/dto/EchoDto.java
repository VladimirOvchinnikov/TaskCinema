package com.bnw.taskcinema.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EchoDto {


    private Integer id;
    private String name;
    private Boolean isLovesNarcissus;
    private LocalDate birthday;
    private LocalTime startCheck;
    private LocalDateTime createdAt;
    private Integer repeat;



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

    public Boolean getIsLovesNarcissus() {
        return isLovesNarcissus;
    }

    public void setIsLovesNarcissus(Boolean lovesNarcissus) {
        isLovesNarcissus = lovesNarcissus;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalTime getStartCheck() {
        return startCheck;
    }

    public void setStartCheck(LocalTime startCheck) {
        this.startCheck = startCheck;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getRepeat() {
        return repeat;
    }

    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }
}
