package com.bnw.taskcinema.converter.common;

import com.bnw.taskcinema.dto.common.IDto;
import com.bnw.taskcinema.model.AbstractEntity;

public interface EntityToDtoConverter<E extends AbstractEntity, D extends IDto> {
    E toEntity(D dto);

    D toDto(E entity);

}
