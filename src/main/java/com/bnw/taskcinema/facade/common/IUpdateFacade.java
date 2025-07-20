package com.bnw.taskcinema.facade.common;

import com.bnw.taskcinema.dto.common.IDto;
import com.bnw.taskcinema.model.AbstractEntity;

public interface IUpdateFacade<T extends IDto> extends IFacade<T> {

    default T update(T dto) {
        AbstractEntity entity = converter().toEntity(dto);
        entity = service().update(entity);
        return (T) converter().toDto(entity);
    }

}
