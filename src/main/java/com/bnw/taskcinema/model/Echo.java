package com.bnw.taskcinema.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "echo")
public class Echo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "is_loves_Narcissus")
    private Boolean isLovesNarcissus;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "start_check")
    private LocalTime startCheck;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "repeat")
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
