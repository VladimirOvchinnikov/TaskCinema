package com.bnw.taskcinema.facade.common;

import com.bnw.taskcinema.dto.common.IDto;

public interface ICrudFacade<T extends IDto> extends IReadFacade<T>, ICreateFacade<T>, IUpdateFacade<T>, IDeleteFacade<T> {


}
