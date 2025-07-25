package com.bnw.taskcinema.facade;

import com.bnw.taskcinema.converter.common.EntityToDtoConverter;
import com.bnw.taskcinema.dto.EchoDto;
import com.bnw.taskcinema.facade.common.ICrudFacade;
import com.bnw.taskcinema.model.Echo;
import com.bnw.taskcinema.service.EchoService;
import com.bnw.taskcinema.service.common.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EchoFacade implements ICrudFacade<EchoDto> {

    private static final Logger LOG = LoggerFactory.getLogger(EchoFacade.class);

    @Autowired
    private EchoService service;

    @Autowired
    private EntityToDtoConverter<Echo, EchoDto> converter;

    @Override
    public IService<Echo> service() {
        return service;
    }

    @Override
    public EntityToDtoConverter<Echo, EchoDto> converter() {
        return converter;
    }

    @Override
    public Logger log() {
        return LOG;
    }
}
