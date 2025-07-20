package com.bnw.taskcinema.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DefaultValueConst {

    public static final String STRING_DEF_VAL = "";
    public static final Boolean BOOL_DEF_VAL = false;
    public static final Integer INT_DEF_VAL = 0;
    public static final Short SHORT_DEF_VAL = 0;
    public static final Byte BYTE_DEF_VAL = 0;
    public static final Long LONG_DEF_VAL = 0L;
    public static final Double DOUBLE_DEF_VAL = 0.0;
    public static final Float FLOAT_DEF_VAL = 0.0F;
    public static final LocalTime TIME_DEF_VAL = LocalTime.of(0, 0, 0, 0);
    public static final LocalDate DATE_DEF_VAL = LocalDate.of(1, 1, 1);
    public static final LocalDateTime TIMESTAMP_DEF_VAL = LocalDateTime.of(DATE_DEF_VAL, TIME_DEF_VAL);
    public static final Object NULL_DEF_VAL = null;

    public static final String FLOAT_DEF_VAL_STR = "0";


    public static final Integer PAGE_SIZE = 50;
    public static final String PAGE_SIZE_STR = "50";
    public static final String PAGE_SIZE_HEADER = "Cinema-Page-Size";
    public static final String PAGE_TOTAL_HEADER = "Cinema-Page-Total";
    public static final Integer PAGE = 0;
    public static final String PAGE_STR = "0";
    public static final String PAGE_HEADER = "Cinema-Page";
    public static final String REQUEST_ID_HEADER = "Cinema-Req-Id";
    public static final String REQUEST_DATE_HEADER = "Cinema-Req-Date";

    public static final String RESPONSE_ID_HEADER = "Cinema-Resp-Id";
    public static final String RESPONSE_DATE_HEADER = "Cinema-Resp-Date";


}
