package com.bnw.taskcinema.model.common;

import java.time.LocalDateTime;

public class LocalDateTimeFieldValue extends FieldValue<LocalDateTime> {

    public LocalDateTimeFieldValue() {
        super(LocalDateTime.class);
    }

    public LocalDateTimeFieldValue(LocalDateTime val) {
        super(val, LocalDateTime.class);
    }

}
