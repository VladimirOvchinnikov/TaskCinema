package com.bnw.taskcinema.facade;

import com.bnw.taskcinema.converter.common.EntityToDtoConverter;
import com.bnw.taskcinema.dto.SummonerDto;
import com.bnw.taskcinema.facade.common.ICrudFacade;
import com.bnw.taskcinema.model.Summoner;
import com.bnw.taskcinema.service.SummonerService;
import com.bnw.taskcinema.service.common.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SummonerFacade implements ICrudFacade<SummonerDto> {
    private static final Logger LOG = LoggerFactory.getLogger(SummonerFacade.class);

    @Autowired
    private SummonerService service;

    @Autowired
    private EntityToDtoConverter<Summoner, SummonerDto> converter;

    @Override
    public IService<Summoner> service() {
        return service;
    }

    @Override
    public EntityToDtoConverter converter() {
        return converter;
    }

    @Override
    public Logger log() {
        return LOG;
    }
}
