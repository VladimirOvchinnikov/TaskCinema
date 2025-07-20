package com.bnw.taskcinema.model.common;

public class IntegerFieldValue extends FieldValue<Integer> {

    public IntegerFieldValue() {
        super(Integer.class);
    }


    public IntegerFieldValue(Integer val) {
        super(val, Integer.class);
    }

}
