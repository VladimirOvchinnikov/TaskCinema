package com.bnw.taskcinema.model.common;

public class StringFieldValue extends FieldValue<String> {

    public StringFieldValue() {
        super(String.class);
    }


    public StringFieldValue(String val) {
        super(val, String.class);
    }
}
