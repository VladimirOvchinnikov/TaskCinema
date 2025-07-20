package com.bnw.taskcinema.converter;

import com.bnw.taskcinema.converter.common.EntityToDtoConverter;
import com.bnw.taskcinema.dto.SummonerDto;
import com.bnw.taskcinema.model.Echo;
import com.bnw.taskcinema.model.Summoner;
import org.springframework.stereotype.Component;

@Component
public class SummonerToDtoConverter implements EntityToDtoConverter<Summoner, SummonerDto> {
    @Override
    public Summoner toEntity(SummonerDto dto) {
        Summoner entity = new Summoner();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        Echo echo = new Echo();
        echo.setId(dto.getEchoId());
        entity.setEcho(echo);
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }

    @Override
    public SummonerDto toDto(Summoner entity) {
        SummonerDto dto = new SummonerDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEchoId(entity.getEcho().getId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setEchoName(entity.getEcho().getName());//Вроде как я ожидаю, что тут упадет
        return dto;
    }
}
