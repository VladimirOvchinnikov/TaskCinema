package com.bnw.taskcinema.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    private final LocalDateTime TEST_TIMESTAMP = LocalDateTime.of(2022, 11, 2, 1, 55, 32, 112233445);
    private final String TEST_TIMESTAMP_STR = "2022-11-02T01:55:32.112233";

    @Test
    public void t_getTimestampStr_01(){
        String val = DateUtils.getTimestampStr(TEST_TIMESTAMP);
        assertEquals(val, TEST_TIMESTAMP_STR);
    }


}