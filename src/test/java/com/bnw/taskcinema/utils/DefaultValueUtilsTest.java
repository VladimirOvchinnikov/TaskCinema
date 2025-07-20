package com.bnw.taskcinema.utils;

import com.bnw.taskcinema.exception.NotDefaultValueException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultValueUtilsTest {

    @Test
    public void t_get_01() {
        Integer val = DefaultValueUtils.get(Integer.class);
        assertEquals(DefaultValueConst.INT_DEF_VAL, val);
    }

    @Test
    public void t_get_02() {
        String val = DefaultValueUtils.get(String.class);
        assertEquals(DefaultValueConst.STRING_DEF_VAL, val);
    }

    @Test
    public void t_get_03() {
        Boolean val = DefaultValueUtils.get(Boolean.class);
        assertEquals(DefaultValueConst.BOOL_DEF_VAL, val);
    }

    @Test
    public void t_get_04() {
        Short val = DefaultValueUtils.get(Short.class);
        assertEquals(DefaultValueConst.SHORT_DEF_VAL, val);
    }

    @Test
    public void t_get_05() {
        Byte val = DefaultValueUtils.get(Byte.class);
        assertEquals(DefaultValueConst.BYTE_DEF_VAL, val);
    }

    @Test
    public void t_get_06() {
        Long val = DefaultValueUtils.get(Long.class);
        assertEquals(DefaultValueConst.LONG_DEF_VAL, val);
    }

    @Test
    public void t_get_07() {
        Double val = DefaultValueUtils.get(Double.class);
        assertEquals(DefaultValueConst.DOUBLE_DEF_VAL, val);
    }

    @Test
    public void t_get_08() {
        Float val = DefaultValueUtils.get(Float.class);
        assertEquals(DefaultValueConst.FLOAT_DEF_VAL, val);
    }

    @Test
    public void t_get_09() {
        LocalTime val = DefaultValueUtils.get(LocalTime.class);
        assertEquals(DefaultValueConst.TIME_DEF_VAL, val);
    }


    @Test
    public void t_get_10() {
        LocalDate val = DefaultValueUtils.get(LocalDate.class);
        assertEquals(DefaultValueConst.DATE_DEF_VAL, val);
    }

    @Test
    public void t_get_11() {
        LocalDateTime val = DefaultValueUtils.get(LocalDateTime.class);
        assertEquals(DefaultValueConst.TIMESTAMP_DEF_VAL, val);
    }


    @Test
    public void t_get_12() {
        NotDefaultValueException exception = assertThrows(NotDefaultValueException.class, () -> DefaultValueUtils.get(Object.class));
        assertEquals(ExceptionMsgConst.NO_DEF_VAL_MSG + Object.class, exception.getMessage());
    }


    @Test
    public void t_get_13() {
        NotDefaultValueException exception = assertThrows(NotDefaultValueException.class, () -> DefaultValueUtils.get(null));
        assertEquals(ExceptionMsgConst.NO_DEF_VAL_MSG + null, exception.getMessage());
    }

}