package com.bnw.taskcinema.facade.common;

import com.bnw.taskcinema.dto.common.IDto;

import java.util.List;
import java.util.stream.Collectors;

public interface IReadFacade<T extends IDto> extends IFacade<T> {

    default List<T> findAll() {
        return service().findAll().stream().map(e -> (T) converter().toDto(e)).collect(Collectors.toList());
    }

    default T findById(Integer id) {
        return (T) converter().toDto(service().findById(id));
    }

}
