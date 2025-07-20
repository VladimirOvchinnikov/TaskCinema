package com.bnw.taskcinema.converter;

import com.bnw.taskcinema.converter.common.EntityToDtoConverter;
import com.bnw.taskcinema.dto.EchoDto;
import com.bnw.taskcinema.model.Echo;
import org.springframework.stereotype.Component;

@Component
public class EchoToDtoConverter implements EntityToDtoConverter<Echo, EchoDto> {


    public Echo toEntity(EchoDto dto) {
        Echo entity = new Echo();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setIsLovesNarcissus(dto.getIsLovesNarcissus());
        entity.setBirthday(dto.getBirthday());
        entity.setStartCheck(dto.getStartCheck());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setRepeat(dto.getRepeat());
        return entity;
    }

    public EchoDto toDto(Echo entity) {
        EchoDto dto = new EchoDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setIsLovesNarcissus(entity.getIsLovesNarcissus());
        dto.setBirthday(entity.getBirthday());
        dto.setStartCheck(entity.getStartCheck());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setRepeat(entity.getRepeat());
        return dto;
    }
}
