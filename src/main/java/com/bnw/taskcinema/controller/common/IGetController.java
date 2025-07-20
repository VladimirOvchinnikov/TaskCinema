package com.bnw.taskcinema.controller.common;

import com.bnw.taskcinema.dto.common.IDto;
import com.bnw.taskcinema.dto.common.RequestDto;
import com.bnw.taskcinema.dto.common.ResponseDto;
import com.bnw.taskcinema.dto.common.SystemHeaderDto;
import com.bnw.taskcinema.facade.common.IReadFacade;
import com.bnw.taskcinema.utils.HeaderUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import static com.bnw.taskcinema.utils.DefaultValueConst.*;

public interface IGetController<T extends IDto> extends IController<T> {


    @GetMapping("/list")
    default ResponseEntity<ResponseDto<T>> findList(@RequestHeader HttpHeaders headers) {
        SystemHeaderDto systemHeaderDto = headerConverter().converter(headers);
        headerValidator().validate(systemHeaderDto);

        RequestDto<T> request = new RequestDto<>();
        request.setId(systemHeaderDto.getId());
        request.setData(null);//такое себе решение, надо бы заглуку пульнуть сюда
        System.out.println("reqId=" + systemHeaderDto.getId() + " page=" + systemHeaderDto.getPage() + " pageSize=" + systemHeaderDto.getPageSize() + " date=" + systemHeaderDto.getTimestamp());
        System.out.println(systemHeaderDto);
        List<T> data = ((IReadFacade<T>) facade()).findAll();
        ResponseDto<T> response = new ResponseDto<>();
        response.setId(request.getId());
        response.getData().addData(data);

        HttpHeaders httpHeaders = HeaderUtils.responseHeaders(response, systemHeaderDto.getPage(), systemHeaderDto.getPageSize());

        return ResponseEntity.ok().headers(httpHeaders).body(response);
    }


    @GetMapping("/{id}")
    default ResponseEntity<ResponseDto<T>> findById(@PathVariable(value = "id", required = true) Integer id) {
        ResponseDto<T> response = new ResponseDto<>();
        response.setId("1");
        T data = ((IReadFacade<T>) facade()).findById(id);
        response.getData().addData(data);
        return ResponseEntity.ok(response);
    }
}
