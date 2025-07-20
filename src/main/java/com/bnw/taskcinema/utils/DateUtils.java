package com.bnw.taskcinema.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {


    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(SystemConst.TIMESTAMP_FORMAT);

    public static String getTimestampStr(LocalDateTime time) {
        return FORMATTER.format(time);
    }

}
