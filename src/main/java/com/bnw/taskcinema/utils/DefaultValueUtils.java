package com.bnw.taskcinema.utils;

import com.bnw.taskcinema.exception.NotDefaultValueException;
import com.bnw.taskcinema.model.Echo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class DefaultValueUtils {

    public static <T> T get(Object type) {
        if (Objects.equals(type, String.class)) {
            return (T) DefaultValueConst.STRING_DEF_VAL;
        }
        if (Objects.equals(type, Boolean.class)) {
            return (T) DefaultValueConst.BOOL_DEF_VAL;
        }
        if (Objects.equals(type, Integer.class)) {
            return (T) DefaultValueConst.INT_DEF_VAL;
        }
        if (Objects.equals(type, Short.class)) {
            return (T) DefaultValueConst.SHORT_DEF_VAL;
        }
        if (Objects.equals(type, Byte.class)) {
            return (T) DefaultValueConst.BYTE_DEF_VAL;
        }
        if (Objects.equals(type, Long.class)) {
            return (T) DefaultValueConst.LONG_DEF_VAL;
        }
        if (Objects.equals(type, Double.class)) {
            return (T) DefaultValueConst.DOUBLE_DEF_VAL;
        }
        if (Objects.equals(type, Float.class)) {
            return (T) DefaultValueConst.FLOAT_DEF_VAL;
        }

        if (Objects.equals(type, LocalTime.class)) {
            return (T) DefaultValueConst.TIME_DEF_VAL;
        }

        if (Objects.equals(type, LocalDate.class)) {
            return (T) DefaultValueConst.DATE_DEF_VAL;
        }

        if (Objects.equals(type, LocalDateTime.class)) {
            return (T) DefaultValueConst.TIMESTAMP_DEF_VAL;
        }

//        if (Objects.equals(type, Echo.class)) {
//            return (T) Echo.DEFAULT;
//        }

        throw new NotDefaultValueException(ExceptionMsgConst.NO_DEF_VAL_MSG + type);
//        return (T) DefaultValueConst.NULL_DEF_VAL;
    }
}
