package com.bnw.taskcinema.controller;



import com.bnw.taskcinema.controller.common.ICrudController;
import com.bnw.taskcinema.converter.HeaderToSystemHeaderConverter;
import com.bnw.taskcinema.dto.SummonerDto;
import com.bnw.taskcinema.facade.common.IFacade;
import com.bnw.taskcinema.facade.SummonerFacade;
import com.bnw.taskcinema.validation.SystemHeaderValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${base.url}/summoner")
public class SummonerController implements ICrudController<SummonerDto> {

    private static final Logger LOG = LoggerFactory.getLogger(SummonerController.class);

    @Autowired
    private SummonerFacade facade;

    @Autowired
    private HeaderToSystemHeaderConverter headerToSystemHeaderConverter;

    @Autowired
    private SystemHeaderValidator headerValidator;

    @Override
    public IFacade<SummonerDto> facade() {
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
