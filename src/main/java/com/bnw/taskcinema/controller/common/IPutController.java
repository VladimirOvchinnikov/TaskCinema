package com.bnw.taskcinema.controller.common;

import com.bnw.taskcinema.dto.common.IDto;
import com.bnw.taskcinema.dto.common.RequestDto;
import com.bnw.taskcinema.dto.common.ResponseDto;
import com.bnw.taskcinema.facade.common.IUpdateFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IPutController<T extends IDto> extends IController<T> {


    @PutMapping("/{id}")
    default ResponseEntity<ResponseDto<T>> update(@PathVariable(value = "id", required = true) Integer id,
                                                  @RequestBody RequestDto<T> req) {
        req.getData().setId(id);
        T data = ((IUpdateFacade<T>) facade()).update(req.getData());
        ResponseDto<T> response = new ResponseDto<>();
        response.setId(req.getId());
        response.getData().addData(data);
        return ResponseEntity.ok(response);
    }

}
