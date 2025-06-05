package com.bnw.taskcinema.controller;

import com.bnw.taskcinema.dto.EchoDto;
import com.bnw.taskcinema.facade.EchoFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/cinema")
@RequestMapping("${base.url}/echo")
public class EchoController {

    private static final Logger LOG = LoggerFactory.getLogger(EchoController.class);


    @Autowired
    private EchoFacade facade;


    @GetMapping("/list")
    public ResponseEntity<List<EchoDto>> findList() {
        return ResponseEntity.ok(facade.findAll());
    }


    @PostMapping()
    public ResponseEntity<EchoDto> create(@RequestBody EchoDto dto) {
        return ResponseEntity.ok(facade.create(dto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<EchoDto> update(@PathVariable(value = "id", required = true) Integer id, @RequestBody EchoDto dto) {
        dto.setId(id);
        return ResponseEntity.ok(facade.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id", required = true) Integer id) {
        facade.delete(id);
        return ResponseEntity.ok().build();
    }


}
