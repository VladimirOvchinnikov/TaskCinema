package com.bnw.taskcinema.controller;

import com.bnw.taskcinema.controller.common.ICrudController;
import com.bnw.taskcinema.converter.HeaderToSystemHeaderConverter;
import com.bnw.taskcinema.dto.EchoDto;
import com.bnw.taskcinema.facade.EchoFacade;
import com.bnw.taskcinema.facade.common.IFacade;
import com.bnw.taskcinema.utils.UrlConst;
import com.bnw.taskcinema.validation.SystemHeaderValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConst.FULL_ECHO_URL)
public class EchoController implements ICrudController<EchoDto> {

    private static final Logger LOG = LoggerFactory.getLogger(EchoController.class);

    @Autowired
    private EchoFacade facade;

    @Autowired
    private HeaderToSystemHeaderConverter headerToSystemHeaderConverter;

    @Autowired
    private SystemHeaderValidator headerValidator;

    @Override
    public IFacade<EchoDto> facade() {
        return facade;
    }

    @Override
    public Logger log() {
        return LOG;
    }

    @Override
    public HeaderToSystemHeaderConverter headerConverter() {
        return headerToSystemHeaderConverter;
    }

    @Override
    public SystemHeaderValidator headerValidator() {
        return headerValidator;
    }
}
