package com.bnw.taskcinema.controller.common;

import com.bnw.taskcinema.dto.common.IDto;
import com.bnw.taskcinema.facade.common.IDeleteFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IDeleteController<T extends IDto> extends IController<T> {

    @DeleteMapping("/{id}")
    default ResponseEntity<Void> delete(@PathVariable(value = "id", required = true) Integer id) {
        ((IDeleteFacade<T>) facade()).delete(id);
        return ResponseEntity.ok().build();
    }
}
