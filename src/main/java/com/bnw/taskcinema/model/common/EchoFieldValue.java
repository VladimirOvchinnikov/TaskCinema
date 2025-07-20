package com.bnw.taskcinema.model.common;

import com.bnw.taskcinema.model.Echo;

public class EchoFieldValue extends FieldValue<Echo> {

    public EchoFieldValue() {
        super(Echo.class);
    }


    public EchoFieldValue(Echo val) {
        super(val, Echo.class);
    }

}
