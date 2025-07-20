package com.bnw.taskcinema.facade.common;

import com.bnw.taskcinema.converter.common.EntityToDtoConverter;
import com.bnw.taskcinema.dto.common.IDto;
import com.bnw.taskcinema.model.AbstractEntity;
import com.bnw.taskcinema.service.common.IService;
import org.slf4j.Logger;


public interface IFacade<T extends IDto> {

    <E extends AbstractEntity> IService<E> service();

    EntityToDtoConverter converter();

    Logger log();

}
