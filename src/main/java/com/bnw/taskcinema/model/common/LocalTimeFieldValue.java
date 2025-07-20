package com.bnw.taskcinema.model.common;

import java.time.LocalTime;

public class LocalTimeFieldValue extends FieldValue<LocalTime> {

    public LocalTimeFieldValue() {
        super(LocalTime.class);
    }

    public LocalTimeFieldValue(LocalTime val) {
        super(val, LocalTime.class);
    }

}
