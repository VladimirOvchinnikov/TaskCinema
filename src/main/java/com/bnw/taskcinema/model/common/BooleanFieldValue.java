package com.bnw.taskcinema.model.common;

public class BooleanFieldValue extends FieldValue<Boolean> {

    public BooleanFieldValue() {
        super(Boolean.class);
    }


    public BooleanFieldValue(Boolean val) {
        super(val, Boolean.class);
    }
}
