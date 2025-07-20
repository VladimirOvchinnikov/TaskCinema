package com.bnw.taskcinema.controller.common;

import com.bnw.taskcinema.converter.HeaderToSystemHeaderConverter;
import com.bnw.taskcinema.dto.common.IDto;
import com.bnw.taskcinema.facade.common.IFacade;
import com.bnw.taskcinema.validation.SystemHeaderValidator;
import org.slf4j.Logger;

public interface IController<T extends IDto> {


    IFacade<T> facade();

    Logger log();

    HeaderToSystemHeaderConverter headerConverter();

    SystemHeaderValidator headerValidator();


}
