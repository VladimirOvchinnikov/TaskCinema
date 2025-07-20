package com.bnw.taskcinema.model.common;

import java.time.LocalDate;

public class LocalDateFieldValue extends FieldValue<LocalDate> {

    public LocalDateFieldValue() {
        super(LocalDate.class);
    }

    public LocalDateFieldValue(LocalDate val) {
        super(val, LocalDate.class);
    }

}
