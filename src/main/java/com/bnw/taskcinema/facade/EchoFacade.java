package com.bnw.taskcinema.facade;

import com.bnw.taskcinema.dto.EchoDto;
import com.bnw.taskcinema.model.Echo;
import com.bnw.taskcinema.service.EchoService;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EchoFacade {

    @Autowired
    private EchoService testService;


    public List<EchoDto> findAll() {
        List<Echo> echoes = testService.findAll();

        return echoes.stream()
//                .map(source -> {
//                    EchoDto dto = new EchoDto();
//                    dto.setId(source.getId());
//                    dto.setName(source.getName());
//                    dto.setIsLovesNarcissus(source.getIsLovesNarcissus());
//                    dto.setBirthday(source.getBirthday());
//                    dto.setStartCheck(source.getStartCheck());
//                    dto.setCreatedAt(source.getCreatedAt());
//                    dto.setRepeat(source.getRepeat());
//                    return dto;
//                })
                .map(EchoFacade::toDto)
                .collect(Collectors.toList());
    }

    public Echo findById(Integer id) {
        return testService.findById(id);
    }

//    public Echo save(Echo entity) {
//        return testService.save(entity);
//    }

    public EchoDto update(EchoDto dto) {
        Echo entity = toEntity(dto);
        entity = testService.save(entity);
        return toDto(entity);
    }


    public void delete(Integer id) {
        testService.delete(id);
    }

    public EchoDto create(EchoDto dto) {
        Echo entity = toEntity(dto);
        entity = testService.save(entity);
        return toDto(entity);
    }

    private static EchoDto toDto(Echo entity) {
        EchoDto dto = new EchoDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setIsLovesNarcissus(entity.getIsLovesNarcissus());
        dto.setBirthday(entity.getBirthday());
        dto.setStartCheck(entity.getStartCheck());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setRepeat(entity.getRepeat());
        return dto;
    }

    private static Echo toEntity(EchoDto dto) {
        Echo entity = new Echo();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setIsLovesNarcissus(dto.getIsLovesNarcissus());
        entity.setBirthday(dto.getBirthday());
        entity.setStartCheck(dto.getStartCheck());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setRepeat(dto.getRepeat());
        return entity;
    }
}
