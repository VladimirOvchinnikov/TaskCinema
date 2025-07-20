package com.bnw.taskcinema.controller.common;

import com.bnw.taskcinema.dto.common.IDto;

public interface ICrudController<T extends IDto> extends IGetController<T>, IPostController<T>, IPutController<T>, IDeleteController<T> {


}
