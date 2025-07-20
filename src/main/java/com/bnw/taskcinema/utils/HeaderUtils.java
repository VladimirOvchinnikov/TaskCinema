package com.bnw.taskcinema.utils;

import com.bnw.taskcinema.dto.common.ResponseDto;
import com.bnw.taskcinema.dto.common.SystemHeaderDto;
import org.springframework.http.HttpHeaders;

import java.util.Arrays;
import java.util.List;

import static com.bnw.taskcinema.utils.DefaultValueConst.*;

public class HeaderUtils {

    public static HttpHeaders responseHeaders(ResponseDto response, Integer page, Integer pageSize) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(PAGE_HEADER, String.valueOf(page));
        httpHeaders.set(PAGE_SIZE_HEADER, String.valueOf(pageSize));
        httpHeaders.set(RESPONSE_ID_HEADER, response.getId());
        httpHeaders.set(PAGE_TOTAL_HEADER, String.valueOf(response.getData().getSize()));
        httpHeaders.set(RESPONSE_DATE_HEADER, String.valueOf(response.getTimestamp()));
        return httpHeaders;
    }

}
