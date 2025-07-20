package com.bnw.taskcinema.controller.common;

import com.bnw.taskcinema.dto.common.IDto;
import com.bnw.taskcinema.dto.common.RequestDto;
import com.bnw.taskcinema.dto.common.ResponseDto;
import com.bnw.taskcinema.facade.common.ICreateFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IPostController<T extends IDto> extends IController<T> {

    @PostMapping()
    default ResponseEntity<ResponseDto<T>> create(@RequestBody RequestDto<T> req) {
        T data = ((ICreateFacade<T>) facade()).create(req.getData());
        ResponseDto<T> response = new ResponseDto<>();
        response.setId("1");
        response.getData().addData(data);
        return ResponseEntity.ok(response);
    }

}
