package com.bnw.taskcinema.facade.common;

import com.bnw.taskcinema.dto.common.IDto;

public interface IDeleteFacade<T extends IDto> extends IFacade<T> {

    default void delete(Integer id) {
        service().delete(id);
    }


}
