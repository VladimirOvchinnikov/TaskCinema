package com.bnw.taskcinema.dto;

import com.bnw.taskcinema.dto.common.IDto;

import java.time.LocalDateTime;

public class SummonerDto implements IDto {

    private Integer id;
    private String name;
    private Integer echoId;
    private String echoName;
    private LocalDateTime createdAt;

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

    public Integer getEchoId() {
        return echoId;
    }

    public void setEchoId(Integer echoId) {
        this.echoId = echoId;
    }

    public String getEchoName() {
        return echoName;
    }

    public void setEchoName(String echoName) {
        this.echoName = echoName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
