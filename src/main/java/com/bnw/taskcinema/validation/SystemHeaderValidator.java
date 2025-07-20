package com.bnw.taskcinema.validation;

import com.bnw.taskcinema.dto.common.SystemHeaderDto;
import com.bnw.taskcinema.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.bnw.taskcinema.utils.DefaultValueConst.STRING_DEF_VAL;
import static com.bnw.taskcinema.utils.ExceptionMsgConst.VALID_ACCESS_DENIED_MSG;

@Component
public class SystemHeaderValidator {


    public void validate(SystemHeaderDto headers) {
        if (Objects.equals(STRING_DEF_VAL, headers.getId())) {
            throw new ValidationException(VALID_ACCESS_DENIED_MSG);
        }
    }
}
