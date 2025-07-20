package com.bnw.taskcinema.facade.common;

import com.bnw.taskcinema.dto.common.IDto;
import com.bnw.taskcinema.model.AbstractEntity;


public interface ICreateFacade<T extends IDto> extends IFacade<T> {

    default T create(T dto) {
        AbstractEntity entity = converter().toEntity(dto);
        entity = service().save(entity);
        return (T) converter().toDto(entity);
    }


}
