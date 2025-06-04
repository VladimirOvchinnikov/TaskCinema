package com.bnw.taskcinema.controller;

import com.bnw.taskcinema.facade.TestFacade;
import com.bnw.taskcinema.model.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class EchoController {

    private static final Logger LOG = LoggerFactory.getLogger(EchoController.class);


    @Autowired
    private TestFacade testFacade;


    @GetMapping("/echo")
    public ResponseEntity<String> echo() {
        LOG.info("info echo");
        LOG.debug("debug echo");
        return ResponseEntity.ok("echo");
    }


    @GetMapping("/test")
    public ResponseEntity<List<Test>> test() {

        return ResponseEntity.ok(testFacade.findAll());
    }


}
