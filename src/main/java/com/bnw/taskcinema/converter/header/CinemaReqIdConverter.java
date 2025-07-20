package com.bnw.taskcinema.converter.header;


import com.bnw.taskcinema.exception.HeaderParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static com.bnw.taskcinema.utils.DefaultValueConst.REQUEST_ID_HEADER;
import static com.bnw.taskcinema.utils.ExceptionMsgConst.VALID_ACCESS_DENIED_MSG;
import static com.bnw.taskcinema.utils.ResponseCodeConst.HEADER_ID_INVALID;

@Component
public class CinemaReqIdConverter {


    public String converter(HttpHeaders headers) {

        List<String> values = headers.get(REQUEST_ID_HEADER);
        if (Objects.isNull(values) || values.isEmpty()) {
            throw new HeaderParseException("", HEADER_ID_INVALID, VALID_ACCESS_DENIED_MSG);
        }
        return values.getFirst();
    }
}
