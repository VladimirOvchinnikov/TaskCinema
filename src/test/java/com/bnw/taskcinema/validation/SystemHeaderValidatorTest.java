package com.bnw.taskcinema.validation;

import com.bnw.taskcinema.dto.common.SystemHeaderDto;
import com.bnw.taskcinema.exception.ValidationException;
import com.bnw.taskcinema.utils.ExceptionMsgConst;
import org.junit.jupiter.api.Test;

import static com.bnw.taskcinema.utils.DefaultValueConst.STRING_DEF_VAL;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SystemHeaderValidatorTest {

    SystemHeaderValidator validator = new SystemHeaderValidator();

    @Test
    public void t_validate_id_01() {
        SystemHeaderDto headers = new SystemHeaderDto();
        headers.setId("123123");
        validator.validate(headers);
        assertDoesNotThrow(() -> validator.validate(headers));
    }

    @Test
    public void t_validate_id_02() {
        SystemHeaderDto headers = new SystemHeaderDto();
        headers.setId(STRING_DEF_VAL);
        ValidationException exception = assertThrows(ValidationException.class, () -> validator.validate(headers));
        assertEquals(ExceptionMsgConst.VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

}